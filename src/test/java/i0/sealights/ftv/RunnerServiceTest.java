package i0.sealights.ftv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@ActiveProfiles("fixedport")
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class RunnerServiceTest {

    final String targetServerUrl = "http://localhost:8080";
    final RestTemplate restTemplate = new RestTemplate();

    @BeforeAll
    static void setup() {
        int i = 1;
    }

    @Test
    void shouldReturnEchoResponseForPhrase_echo() {
        // given
        final String phraseToEcho = "echo";

        // when
        ResponseEntity<String> response = restTemplate.getForEntity(
            targetServerUrl + "/echo/" + phraseToEcho,
            String.class);

        sleep();

        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("PONG: echo", response.getBody());

        sleep();
    }

    @Test
    void shouldReturnEchoResponseForPhrase_ping() {
        // given
        final String phraseToEcho = "ping";

        // when
        ResponseEntity<String> response = restTemplate.getForEntity(
            targetServerUrl + "/echo/" + phraseToEcho,
            String.class);

        sleep();

        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("PONG: ping", response.getBody());

        sleep();
    }

    @Test
    void shouldReturnEchoResponseForPhrase_asterisk() {
        // given
        final String phraseToEcho = "*asterisk";

        // when
        HttpClientErrorException exception = assertThrows(HttpClientErrorException.class, () -> {
            restTemplate.getForEntity(
                targetServerUrl + "/echo/" + phraseToEcho,
                String.class);
        });

        sleep();

        // then
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
        assertEquals(exception.getResponseBodyAsString(), "bad to the bone");
    }

    @Test
    void shouldReturnHelloWorld() {
        // when
        ResponseEntity<String> actualResponse = restTemplate.getForEntity(
            targetServerUrl + "/hello",
            String.class);

        sleep();

        // then
        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
        assertEquals(actualResponse.getBody(), "Hello World!");

        sleep();
    }

    private void sleep() {
        try {
            Thread.sleep(2_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
//
//    @Test
//    public void printSystemProps() {
//        System.getenv().forEach((key, value) -> {
//            System.out.println("ENV:  " + key + " => " + value);
//        });
//
//        System.getProperties().entrySet().forEach(entry -> {
//            System.out.println("PRO:  " + entry.getKey() + " => " + entry.getValue());
//        });
//
//        new RestTemplate().getForEntity(
//            "http://localhost:8080/echo/blah",
//            String.class);
//
//        assert true;
//    }

}

