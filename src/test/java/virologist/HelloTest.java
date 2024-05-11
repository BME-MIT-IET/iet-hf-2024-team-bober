package virologist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class HelloTest {
    String text;

    @BeforeEach
    public void init() {
        text = "Hello!";
    }

    @Test
    public void hello_firstTest() {
        // Arrange

        // Act

        // Assert
        assertEquals(text, text);
    }
}
