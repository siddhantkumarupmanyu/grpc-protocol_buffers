package com.example.sample

import com.example.sample.rcp_services.SampleGreeterGrpc
import com.example.sample.rcp_services.SampleReply
import com.example.sample.rcp_services.SampleRequest
import io.grpc.stub.StreamObserver

// why implementation inheritance. just why??
class SampleGreeterServiceImpl : SampleGreeterGrpc.SampleGreeterImplBase() {
    override fun sayHello(request: SampleRequest, responseObserver: StreamObserver<SampleReply>) {
        val reply = SampleReply.newBuilder().setMessage("Hello ${request.name}").build()
        responseObserver.onNext(reply)
        responseObserver.onCompleted()
    }
}