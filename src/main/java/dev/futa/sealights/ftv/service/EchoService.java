package dev.futa.sealights.ftv.service;

import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class EchoService {

    public Optional<String> doEcho(final String phrase) {
        if (phrase.startsWith("*")) {
            return Optional.empty();
        }
        if (phrase.startsWith("upper-")) {
            return Optional.of("UPPERCASE PONG: " + phrase.toUpperCase());
        }
        return Optional.of("PONG: " + phrase);
    }

    public int intentionallyUnusedMethod() {
        return 13;
    }
}
