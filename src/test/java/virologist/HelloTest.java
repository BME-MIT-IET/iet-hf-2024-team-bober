package virologist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

class HelloTest {

    @BeforeEach
    public void init() {
                
    }

    @Test
    void hello_firstTest() {
        // Arrange

        // Act
        boolean result = true;

        // Assert
        assertEquals(true, result);
    }
}
