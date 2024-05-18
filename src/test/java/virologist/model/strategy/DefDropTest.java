package virologist.model.strategy;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import virologist.model.Virologist;
import virologist.model.equipments.Equipment;
import virologist.model.map.Field;

class DefDropTest {
    private DefDrop defDrop;
    private Virologist virologist;
    private Field field;
    private Equipment equipment;

    @BeforeEach
    public void init() {
        defDrop = new DefDrop();
        virologist = mock(Virologist.class);
        field = mock(Field.class);
        equipment = mock(Equipment.class);
    }

    @Test
    void dropTest() {
        // Arrange

        // Act
        defDrop.Drop(virologist, field, equipment);
        
        // Assert
        verify(equipment, times(1)).Disable(virologist);
        verify(field, times(1)).Drop(equipment);
        verify(virologist, times(1)).Reset();
        verify(virologist, times(1)).DecreaseActions();
    } 
}
