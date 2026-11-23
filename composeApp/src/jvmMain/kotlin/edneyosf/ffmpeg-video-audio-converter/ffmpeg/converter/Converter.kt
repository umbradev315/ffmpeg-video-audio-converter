package edneyosf.ffmpeg-video-audio-converter.ffmpeg.converter

import edneyosf.ffmpeg-video-audio-converter.core.common.Error
import edneyosf.ffmpeg-video-audio-converter.core.extensions.notifyMain
import edneyosf.ffmpeg-video-audio-converter.core.process.EdProcess
import edneyosf.ffmpeg-video-audio-converter.ffmpeg.data.ProgressData
import edneyosf.ffmpeg-video-audio-converter.ffmpeg.extensions.getProgressData
import edneyosf.ffmpeg-video-audio-converter.ffmpeg.ffmpeg.FFmpegArgs
import java.io.BufferedReader
import java.io.File
import java.io.InputStreamReader

class Converter(
    private val process: EdProcess,
    private val onStdout: (String) -> Unit,
    private val onProgress: (ProgressData?) -> Unit
) {

    suspend fun run(ffmpeg: String, inputFile: File, cmd: String, outputFile: File): Error? {
        var error: Error? = null

        onStdout("Command = { $cmd }")

        try {
            if (outputFile.exists() && outputFile.isFile) outputFile.delete()
            outputFile.parentFile?.mkdirs()

            if(!inputFile.exists()) return Error.INPUT_FILE_NOT_EXIST
            else if(!inputFile.isFile) return Error.INPUT_NOT_FILE

            process.conversion = ProcessBuilder(
                ffmpeg,
                FFmpegArgs.INPUT, inputFile.absolutePath,
                *cmd.normalize(),
                outputFile.absolutePath
            ).start()

            process.conversion?.let {
                notifyMain { onProgress(null) }

                BufferedReader(InputStreamReader(it.errorStream)).useLines { lines ->
                    lines.forEach { line ->
                        val progress = line.getProgressData { e -> onStdout("Error = { " + e.message + " }") }

                        if (progress != null) notifyMain { onProgress(progress) }
                        else onStdout(line)
                    }
                }

                val exitCode = it.waitFor()
                if (exitCode != 0) error = Error.CONVERSION_PROCESS_COMPLETED

            } ?: run {
                error = Error.PROCESS_NULL
            }
        }
        catch (e: Exception) {
            e.printStackTrace()
            destroyProcess()
            error = Error.CONVERSION_PROCESS
        }
        finally {
            process.conversion = null
        }

        return error
    }

    fun destroyProcess() {
        process.conversion?.destroyForcibly()
        process.conversion = null
    }

    private fun String.normalize(): Array<String> {
        val parts = mutableListOf<String>()
        val cur = StringBuilder()
        var inSingle = false
        var inDouble = false
        var escape = false

        for (ch in this) {
            if (escape) {
                cur.append(ch)
                escape = false
                continue
            }

            when (ch) {
                '\\' -> escape = true
                '"' -> if (!inSingle) inDouble = !inDouble else cur.append(ch)
                '\'' -> if (!inDouble) inSingle = !inSingle else cur.append(ch)
                else -> {
                    if (ch.isWhitespace() && !inSingle && !inDouble) {
                        if (cur.isNotEmpty()) {
                            parts.add(cur.toString())
                            cur.setLength(0)
                        }
                    } else {
                        cur.append(ch)
                    }
                }
            }
        }

        if (escape) cur.append('\\')
        if (cur.isNotEmpty()) parts.add(cur.toString())

        return parts.toTypedArray()
    }
}