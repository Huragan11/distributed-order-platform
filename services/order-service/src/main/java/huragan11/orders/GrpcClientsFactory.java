package huragan11.orders;

import com.huragan11.inventory.grpc.InventoryServiceGrpc;
import io.micronaut.context.annotation.Factory;
import io.micronaut.grpc.annotation.GrpcChannel;
import jakarta.inject.Singleton;

@Factory
public class GrpcClientsFactory {

    @Singleton
    InventoryServiceGrpc.InventoryServiceBlockingStub inventoryBlockingStub(@GrpcChannel("inventory") io.grpc.Channel channel){
        return InventoryServiceGrpc.newBlockingStub(channel);
    }
}
