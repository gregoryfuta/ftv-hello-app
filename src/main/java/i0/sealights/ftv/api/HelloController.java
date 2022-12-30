package i0.sealights.ftv.api;

import static org.springframework.http.ResponseEntity.badRequest;

import i0.sealights.ftv.service.HelloService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService echoService) {
        this.helloService = echoService;
    }

    @GetMapping("/echo2/{phrase}")
    public ResponseEntity<String> echo(@PathVariable("phrase") String phrase) {
        return helloService.sayHello(phrase)
            .map(ResponseEntity::ok)
            .orElse(badRequest().body("bad to the bone, " + phrase));
    }

    @GetMapping("/hello2")
    public String unusedEndpoint() {
        return "Hello World!";
    }

    @GetMapping("/hello2/date")
    public String echoDate() {
        return LocalDate.now().format(DateTimeFormatter.ISO_DATE);
    }
}
