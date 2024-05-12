package virologist.model.agents;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import virologist.model.Virologist;
import static org.mockito.Mockito.*;

class ChoreaTest {
    private Chorea chorea;
    private Virologist virologist;
    private int timeToLive = 3;

    @BeforeEach
    public void init() {
        chorea = new Chorea(timeToLive);
        virologist = mock(Virologist.class);
    }

    @Test
    void ApplyTest() {
        // Arrange

        // Act
        chorea.Apply(virologist);
        
        // Assert
        verify(virologist, times(3)).Move();
    }
}