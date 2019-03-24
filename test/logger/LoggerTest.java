package logger;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoggerTest {

    @Test
    void shouldLogAtBothPlaces() {
        Logger logger = new Logger(new LogFile(), new LogConsole());
        assertEquals(logger.log("Hello"), "Hello Hello");
    }
}