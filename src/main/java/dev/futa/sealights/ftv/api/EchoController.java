package dev.futa.sealights.ftv.api;

import static org.springframework.http.ResponseEntity.badRequest;

import dev.futa.sealights.ftv.service.EchoService;
import java.util.Objects;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EchoController {

    private final EchoService echoService;

    public EchoController(EchoService echoService) {
        this.echoService = echoService;
    }

    @GetMapping("/echo/{phrase}")
    public ResponseEntity<String> echo(@PathVariable("phrase") String phrase) {

        return echoService.doEcho(phrase)
            .map(ResponseEntity::ok)
            .orElse(badRequest().body("bad to the bone"));

    }

    @GetMapping("/hello")
    public String unusedEndpoint() {
        return "Hello World!";
    }

}
