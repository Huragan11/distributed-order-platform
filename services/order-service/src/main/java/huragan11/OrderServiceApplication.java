package huragan11;

import org.slf4j.bridge.SLF4JBridgeHandler;
import io.micronaut.runtime.Micronaut;

public class OrderServiceApplication {

    public static void main(String[] args) {
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
        Micronaut.run(OrderServiceApplication.class, args);
    }
}
