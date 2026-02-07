package com.huragan11.inventory.grpc;

import com.huragan11.inventory.grpc.InventoryServiceGrpc.InventoryServiceImplBase;
import io.grpc.stub.StreamObserver;
import io.micronaut.grpc.annotation.GrpcService;

@GrpcService
public class InventoryGrpcService extends InventoryServiceImplBase {

    @Override
    public void reserveStock(ReserveStockRequest request, StreamObserver<ReserveStockResponse> responseObserver) {
        boolean allAvailable = request.getItemsList().stream()
                .allMatch(stockItem -> stockItem.getQuantity() <= 10);

        ReservationStatus status = allAvailable ? ReservationStatus.RESERVED : ReservationStatus.OUT_OF_STOCK;

        ReserveStockResponse response = ReserveStockResponse.newBuilder().setStatus(status).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
