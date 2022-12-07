package dev.futa.sealights.ftv;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class RunnerServiceTest {

    final String targetServerUrl = "http://localhost:8080";
    final RestTemplate restTemplate = new RestTemplate();

    @Test
    void shouldReturnEchoResponseForPhrase_echo() {
        // given
        final String phraseToEcho = "echo";

        // when
        ResponseEntity<String> response = restTemplate.getForEntity(
            targetServerUrl + "/echo/" + phraseToEcho,
            String.class);

        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("PONG: echo", response.getBody());
    }

    @Test
    void shouldReturnEchoResponseForPhrase_ping() {
        // given
        final String phraseToEcho = "ping";

        // when
        ResponseEntity<String> response = restTemplate.getForEntity(
            targetServerUrl + "/echo/" + phraseToEcho,
            String.class);

        // then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("PONG: ping", response.getBody());
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

        // then
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
        assertEquals(exception.getResponseBodyAsString(), "bad to the bone");
    }

}
