package huragan11;

import io.micronaut.http.annotation.*;

@Controller("/api-gateway")
public class ApiGatewayController {

    private final GreetingService greetingService;

    public ApiGatewayController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @Get(uri="/", produces="text/plain")
    public String index() {
        return "Example Response";
    }

    @Get(uri = "/greet/{name}", produces = "text/plain")
    public String greet(String name){
        return greetingService.greet(name);
    }
}