package virologist.model.equipments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import virologist.model.Virologist;
import virologist.model.strategy.IInjectedStr;
import virologist.model.strategy.NoInjected;

import static org.mockito.Mockito.*;

class CloakTest {
    private Cloak cloak;
    private Virologist virologist;

    @BeforeEach
    public void init() {
        cloak = new Cloak();
        virologist = mock(Virologist.class);
    }

    @Test
    void applyStrategy_when_random_is_smaller_then_0point823() {
        // Arrange
        cloak = new Cloak(0.822);

        // Act
        cloak.ApplyStrategy(virologist);

        // Assert
        verify(virologist, times(1)).SetInjectedStr(any(IInjectedStr.class));
    }

    @Test
    void applyStrategy_when_random_is_not_smaller_then_0point823() {
        // Arrange
        cloak = new Cloak(0.823);

        // Act
        cloak.ApplyStrategy(virologist);

        // Assert
        verify(virologist, times(0)).SetInjectedStr(any(NoInjected.class));
    }
}