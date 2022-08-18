package com.example.sample

import com.example.sample.rcp_services.SampleGreeterGrpc
import com.example.sample.rcp_services.SampleReply
import com.example.sample.rcp_services.SampleRequest
import io.grpc.inprocess.InProcessChannelBuilder
import io.grpc.inprocess.InProcessServerBuilder
import io.grpc.stub.StreamObserver
import io.grpc.testing.GrpcCleanupRule
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

// we are not testing how the channel is made and to whom it's connected
// only the SampleGreeterServiceClient
// idk, if i should be integration testing that.
// or e2e will be fine
// imo, e2e will be fine, right?
// idk, will see
class SampleGreeterServiceClientTest {

    // instead of @Rule
    // i can annotate it with @ClassRule then it will execute on Class
    // not before every test and then tear it down after ward.
    // you know that right. lol...
    // this way these integration tests will be a bit fast.
    // since only one time initialization of this server
    // and clean up
    @get:Rule
    val gRcpCleanupRule = GrpcCleanupRule()

    // only mock interfaces
    // not even abstract classes
    // use fakes
    private val fakeService = object : SampleGreeterGrpc.SampleGreeterImplBase() {

        val response = SampleReply.newBuilder().setMessage("reply").build()
        var request = SampleRequest.newBuilder().setName("nothing").build()

        // i know i am not following tell don't ask
        // or CQS principle but for now
        override fun sayHello(request: SampleRequest, responseObserver: StreamObserver<SampleReply>) {
            this.request = request
            responseObserver.onNext(response)
            responseObserver.onCompleted()
        }
    }

    // can't think of a better test name, rn
    @Test
    fun askServer() {
        //- this block can be in setup
        val serverName = InProcessServerBuilder.generateName()

        gRcpCleanupRule.register(
            InProcessServerBuilder.forName(serverName).directExecutor().addService(fakeService).build().start()
        )

        val channel = gRcpCleanupRule.register(
            InProcessChannelBuilder.forName(serverName).directExecutor().build()
        )

        val client = SampleGreeterServiceClient(channel)
        //-

        val response = client.greet("test")

        val request = SampleRequest.newBuilder().setName("test").build()
        assertEquals(fakeService.request, request)
        assertEquals(response, fakeService.response)
    }

}

// i could have done what these guys did,
// instead of using fakes.
// but that i think is a bad practice.
// fake is a better candidate here. imo.
// and as i said 
/*
 private final GreeterGrpc.GreeterImplBase serviceImpl =
      mock(GreeterGrpc.GreeterImplBase.class, delegatesTo(
          new GreeterGrpc.GreeterImplBase() {
          // By default the client will receive Status.UNIMPLEMENTED for all RPCs.
          // You might need to implement necessary behaviors for your test here, like this:
          //
          // @Override
          // public void sayHello(HelloRequest request, StreamObserver<HelloReply> respObserver) {
          //   respObserver.onNext(HelloReply.getDefaultInstance());
          //   respObserver.onCompleted();
          // }
          }));
 */
// only mock interfaces not even abstract classes
// fake them if you need

// one could say i am redoing by creating fake
// what mockito can do
// one can partner this way it's faster,
// but tbh that would be like premature optimization
// the thing is this is what i learned.
// use the tools correctly
// and not overusing them
// and avoid tight coupling
// it's not boilerplate, never was, never is and never will be

// this way you can say, every code we write in tests is just boilerplate
// so TDD is just boilerplate[1]. lol
// doesn't make any sense...

// [1] but tbh, for some it does... i am just sad for them,
// but again they suffer in the end... so it's their choice...
// whatever, i like or love it, anyway... :)
