package i0.sealights.ftv.service;

import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class GoodbyeService {

    public Optional<String> sayGoodbye(final String nameToGreet) {
        return Optional.of("B" + "ye, ".toLowerCase() + nameToGreet);
    }

    public int intentionallyUnusedHelloMethod() {
        return 24;
    }
}
