package huragan11;

import io.micronaut.http.annotation.*;

@Controller("/api-gateway")
public class ApiGatewayController {

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }
}