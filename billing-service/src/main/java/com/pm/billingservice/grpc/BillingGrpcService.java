package com.pm.billingservice.grpc;

import billing.BillingResponse;
import billing.BillingServiceGrpc;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.server.service.GrpcService;

@Slf4j
@GrpcService
public class BillingGrpcService extends BillingServiceGrpc.BillingServiceImplBase {

    @Override
    public void createBillingAccount(billing.BillingRequest billingRequest, StreamObserver<billing.BillingResponse> responseObserver) {
        log.info("createBillingAccount request received : {}", billingRequest.toString());

        // Business logic i.e save to to db, perform calculations

        BillingResponse billingResponse = BillingResponse.newBuilder().setAccountId("12345").setStatus("ACTIVE").build();
        responseObserver.onNext(billingResponse);
        responseObserver.onCompleted();
    }
}
