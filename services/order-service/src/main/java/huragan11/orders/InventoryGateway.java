package huragan11.orders;

import com.huragan11.inventory.grpc.InventoryServiceGrpc;
import com.huragan11.inventory.grpc.ReserveStockRequest;
import com.huragan11.inventory.grpc.ReserveStockResponse;
import com.huragan11.inventory.grpc.StockItem;
import jakarta.inject.Singleton;

import java.util.List;

@Singleton
public class InventoryGateway {

    private final InventoryServiceGrpc.InventoryServiceBlockingStub stub;

    public InventoryGateway(InventoryServiceGrpc.InventoryServiceBlockingStub stub) {
        this.stub = stub;
    }

    public ReserveStockResponse reserve(String orderId, List<StockItem> items) {
        ReserveStockRequest request = ReserveStockRequest.newBuilder()
                .setOrderId(orderId)
                .addAllItems(items)
                .build();
        return stub.reserveStock(request);
    }


}
