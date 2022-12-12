package dev.futa.sealights.ftv.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Optional;
import org.junit.jupiter.api.Test;

public class EchoServiceTest {

    private EchoService echoService = new EchoService();

    @Test
    void shouldReturnValidEchoResponse() {
        // given
        final String phrase = "some phrase";

        // when
        String response = echoService.doEcho(phrase).get();

        // then
        assertEquals("PONG: some phrase", response);
    }

    @Test
    void shouldReturnEptyResponseForPhrasesStartedWithAsterix() {
        // given
        final String phrase = "*asterix";

        // when
        Optional<String> response = echoService.doEcho(phrase);

        // then
        assertFalse(response.isPresent());
    }

    @Test
    void shouldReturn13OnUnusedFunction() {
        // when
        int actual = echoService.intentionallyUnusedMethod();

        // then
        assertEquals(13, actual);
    }

}
