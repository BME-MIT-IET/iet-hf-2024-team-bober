package virologist.model.agents;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import virologist.model.Virologist;
import virologist.model.strategy.BearMove;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BearTest {
    private Bear bear;
    private Virologist virologist;

    @BeforeEach
    public void init() {
        bear = new Bear();
        virologist = mock(Virologist.class);
    }

    @Test
    void getTimeToLiveTest() {
        // Arrange

        // Act
        String result = bear.getTimeToLive();
        
        // Assert
        assertEquals("infinity", result);
    }

    @Test
    void ApplyStrategyTest() {
        // Arrange

        // Act
        bear.ApplyStrategy(virologist);
        
        // Assert
        verify(virologist, times(1)).SetMoveStr(any(BearMove.class));
    }

    @Test
    void updateTest() {
        // Arrange

        // Act
        bear.Update(virologist);
        
        // Assert
        verifyNoInteractions(virologist);
    }
}