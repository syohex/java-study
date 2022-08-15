package org.syohex.okhttp02

import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import okio.BufferedSink
import okio.buffer
import okio.sink
import java.io.File
import java.io.IOException

fun main() {
    downloadFile("https://rise-stage.bioinf.unc.edu/cue_audio/sampleaudio.mp3", "C:\\temp\\a.mp3")
}

fun downloadFile(url: String, localFileName: String) {
    val request: Request = Request.Builder()
        .url(url)
        .build()

    val client = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }).build()
    client.newCall(request).enqueue(object : Callback {

        override fun onFailure(call: Call, e: IOException) {
            println("error $e")
        }

        @Throws(IOException::class)
        override fun onResponse(call: Call, response: Response) {
            if (!response.isSuccessful) throw IOException("Unexpected code $response")

            val file = File(localFileName)
            val contentLength = response.body!!.contentLength()
            println("contentLength=$contentLength")

            val body = response.body
            val source = body!!.source()
            val DOWNLOAD_CHUNK_SIZE:Long = 2048
            val sink: BufferedSink = file.sink().buffer()

            var totalRead: Long = 0
            var read: Long = 0
            while (source.read(sink.buffer(), DOWNLOAD_CHUNK_SIZE).also {
                    read = it
                } != -1L) {
                totalRead += read
            }
            sink.writeAll(source)
            sink.flush()
            sink.close()

            println("Success")
        }
    })
}