package virologist.model.agents;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import virologist.model.Virologist;
import virologist.model.strategy.NoInjected;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BlockTest {
    private Block block;
    private Virologist virologist;
    private int timeToLive = 3;

    @BeforeEach
    public void init() {
        block = new Block(timeToLive);
        virologist = mock(Virologist.class);
    }

    @Test
    void ApplyTest() {
        // Arrange

        // Act
        block.Apply(virologist);
        
        // Assert
        verify(virologist, times(1)).RemoveAgents();
    }

    @Test
    void ApplyStrategyTest() {
        // Arrange

        // Act
        block.ApplyStrategy(virologist);
        
        // Assert
        verify(virologist, times(1)).SetInjectedStr(any(NoInjected.class));
    }
}