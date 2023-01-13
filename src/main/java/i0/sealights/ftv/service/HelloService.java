package i0.sealights.ftv.service;

import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public Optional<String> sayHello(final String nameToGreet) {
        return Optional.of("Hello, " + nameToGreet);
    }

    public int intentionallyUnusedHelloMethod() {
        return 22;
    }
}
