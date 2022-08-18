package com.example.sample

import com.example.sample.rcp_services.SampleGreeterGrpc
import com.example.sample.rcp_services.SampleRequest
import io.grpc.inprocess.InProcessChannelBuilder
import io.grpc.inprocess.InProcessServerBuilder
import io.grpc.testing.GrpcCleanupRule
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals


// we are not testing how the server is made and stated
// that server code
// only the service
// idk, if i should be integration testing that.
// or e2e will be fine
// imo, e2e will be fine, right?
// idk, will see
class SampleGreeterServiceImplTest {

    // instead of @Rule
    // i can annotate it with @ClassRule then it will execute on Class
    // not before every test and then tear it down after ward.
    // you know that right. lol...
    // this way these integration tests will be a bit fast.
    // since only one time initialization of this server
    // and clean up
    @get:Rule
    val gRcpCleanupRule = GrpcCleanupRule()

    @Test
    fun replyMessage() {
        // Generate a unique in-process server name.
        val serverName = InProcessServerBuilder.generateName()

        // Create a server, add service, start, and register for automatic graceful shutdown.
        gRcpCleanupRule.register(
            InProcessServerBuilder.forName(serverName).directExecutor().addService(SampleGreeterServiceImpl()).build()
                .start()
        )

        // Create a client channel and register for automatic graceful shutdown.
        val blockingStub =
            SampleGreeterGrpc.newBlockingStub(
                gRcpCleanupRule.register(InProcessChannelBuilder.forName(serverName).directExecutor().build())
            )

        val reply = blockingStub.sayHello(SampleRequest.newBuilder().setName("test name").build())

        assertEquals("Hello test name", reply.message)
    }

}