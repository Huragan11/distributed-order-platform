package huragan11;

import jakarta.inject.Singleton;

@Singleton
public class GreetingService {
    public String greet(String name){
        return "Hello " + name + "!";
    }
}
