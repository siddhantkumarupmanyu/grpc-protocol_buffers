package com.example.sample

import com.example.sample.rcp_services.SampleGreeterGrpc
import com.example.sample.rcp_services.SampleReply
import com.example.sample.rcp_services.SampleRequest
import io.grpc.Channel
import io.grpc.ManagedChannel
import io.grpc.ManagedChannelBuilder
import io.grpc.StatusRuntimeException
import java.util.concurrent.TimeUnit


// 'channel' here is a Channel, not a ManagedChannel, so it is not this code's responsibility to
// shut it down.
class SampleGreeterServiceClient(private val channel: Channel) {

    // Passing Channels to code makes code easier to test and makes it easier to reuse Channels.
    private val blockingStub = SampleGreeterGrpc.newBlockingStub(channel)

    fun greet(name: String): SampleReply {
        val request = SampleRequest.newBuilder().setName(name).build()
        try {
            return blockingStub.sayHello(request)
        } catch (e: StatusRuntimeException) {
            System.err.println("Exceptions ${e.printStackTrace()}")
            throw e
        }
    }
}

// it a wrapper around the managedChannel
// so it's not representing the right thing
// this word is not correct
// still fine for now
// it's like same/common channel for every service for a particular server
class GRpcClient {

    private lateinit var channel: ManagedChannel

    fun connectAndGreet(target: String) {
        // Create a communication channel to the server, known as a Channel. Channels are thread-safe
        // and reusable. It is common to create channels at the beginning of your application and reuse
        // them until the application shuts down.
        channel = ManagedChannelBuilder.forTarget(target)
            // Channels are secure by default (via SSL/TLS). For the example we disable TLS to avoid
            // needing certificates.
            .usePlaintext()
            .build()

        try {
            val client = SampleGreeterServiceClient(channel)
            client.greet("test name")
        } finally {
            // ManagedChannels use resources like threads and TCP connections. To prevent leaking these
            // resources the channel should be shut down when it will no longer be used. If it may be used
            // again leave it running.
            channel.shutdownNow().awaitTermination(5, TimeUnit.SECONDS)
        }
    }

}

fun main() {
    // Access a service running on the local machine on port 50051
    val target = "localhost:50001"
    val client = GRpcClient()
    client.connectAndGreet(target)
}