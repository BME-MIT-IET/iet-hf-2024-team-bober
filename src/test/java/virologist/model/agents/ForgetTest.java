package virologist.model.agents;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import virologist.model.Virologist;
import static org.mockito.Mockito.*;

class ForgetTest {
    private Forget forget;
    private Virologist virologist;
    private int timeToLive = 3;

    @BeforeEach
    public void init() {
        forget = new Forget(timeToLive);
        virologist = mock(Virologist.class);
    }

    @Test
    void ApplyTest() {
        // Arrange

        // Act
        forget.Apply(virologist);
        
        // Assert
        verify(virologist, times(1)).RemoveGeneticCodes();
    }
}