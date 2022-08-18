package com.example.sample

import io.grpc.Server
import io.grpc.ServerBuilder
import java.util.concurrent.TimeUnit

class GRpcServer {
    private var server: Server? = null

    fun start() {
        val port = 50012

        // we should add multiple service to same server
        server = ServerBuilder.forPort(port)
            .addService(SampleGreeterServiceImpl())
            .build()
            .start()

        Runtime.getRuntime().addShutdownHook(Thread {
            System.err.println("*** shutting down gRPC server since JVM is exiting***")
            try {
                this@GRpcServer.stop()
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        })
    }

    private fun stop() {
        server?.shutdown()?.awaitTermination(30, TimeUnit.SECONDS)
    }

    fun blockUnitShutdown() {
        server?.awaitTermination()
    }

}

fun startServer() {
    val gRpcServer = GRpcServer()
    gRpcServer.start()
    gRpcServer.blockUnitShutdown()
}