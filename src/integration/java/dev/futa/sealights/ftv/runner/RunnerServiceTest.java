package dev.futa.sealights.ftv.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Optional;
import org.junit.jupiter.api.Test;

public class RunnerServiceTest {

    private EchoService echoService = new EchoService();

    @Test
    void shouldReturnValidEchoResponse() {
        // given
        final String phrase = "integration";

        // when
        String response = echoService.doEcho(phrase).get();

        // then
        assertEquals("PONG: some phrase", response);
    }

}
