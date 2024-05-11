package virologist.model.equipments;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import virologist.model.Virologist;
import static org.mockito.Mockito.*;

class BagTest {
    private Bag bag;
    private final int delta = 5;
    private Virologist virologist;

    @BeforeEach
    public void init() {
        bag = new Bag(delta);
        virologist = mock(Virologist.class);
    }

    @Test
    void apply() {
        // Arrange

        // Act
        bag.Apply(virologist);

        // Assert
        verify(virologist, times(1)).IncreaseLimit(delta);
    }
    
    @Test
    void disable() {
        // Arrange

        // Act
        bag.Disable(virologist);

        // Assert
        verify(virologist, times(1)).DecreaseLimit(delta);
    }
}