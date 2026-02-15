package huragan11.orders;

import com.huragan11.inventory.grpc.ReservationStatus;
import com.huragan11.inventory.grpc.StockItem;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;
import java.util.UUID;

@Controller("/debug")
public class OrderDebugController {

    private final InventoryGateway inventoryGateway;

    public OrderDebugController(InventoryGateway inventoryGateway) {
        this.inventoryGateway = inventoryGateway;
    }

    @Get("/reserve")
    public String reserve(){
        String orderId = UUID.randomUUID().toString();

        var items = List.of(
                StockItem.newBuilder().setProductId("p1").setQuantity(2).build(),
                StockItem.newBuilder().setProductId("p2").setQuantity(20).build()
        );

        var response = inventoryGateway.reserve(orderId, items);

        if (response.getStatus() == ReservationStatus.RESERVED){
            return "RESERVED";
        }
        return "OUT OF STOCK";
    }

}
