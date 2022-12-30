package i0.sealights.ftv.service;

import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class GoodbyeService {

    public Optional<String> sayGoodbye(final String nameToGreet) {
        return Optional.of("Bye, " + nameToGreet);
    }

    public int intentionallyUnusedHelloMethod() {
        return 24;
    }
}
