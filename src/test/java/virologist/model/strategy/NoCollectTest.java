package virologist.model.strategy;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import virologist.model.Virologist;
import virologist.model.map.Field;

class NoCollectTest {
    private NoCollect noCollect;
    private Virologist virologist;
    private Field field;

    @BeforeEach
    public void init() {
        noCollect = new NoCollect();
        virologist = mock(Virologist.class);
        field = mock(Field.class);
    }

    @Test
    void collectTest() {
        // Arrange

        // Act
        noCollect.Collect(virologist, field);
        
        // Assert
        verify(field, times(0)).CollectMaterial(virologist);
        verify(virologist, times(1)).DecreaseActions();
    }
}
