package virologist.model.strategy;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import virologist.model.Virologist;
import virologist.model.equipments.Equipment;
import virologist.model.map.Field;

class NoDropTest {
    private NoDrop noDrop;
    private Virologist virologist;
    private Field field;
    private Equipment equipment;

    @BeforeEach
    public void init() {
        noDrop = new NoDrop();
        virologist = mock(Virologist.class);
        field = mock(Field.class);
        equipment = mock(Equipment.class);
    }

    @Test
    void dropTest() {
        // Arrange

        // Act
        noDrop.Drop(virologist, field, equipment);
        
        // Assert
        verify(equipment, times(0)).Disable(virologist);
        verify(field, times(0)).Drop(equipment);
        verify(virologist, times(0)).Reset();

        // Ha ezt a sort toroljuk az eredetibol: v.AddEquipment(e);	akkor az alabbit is ki kell venni.
        verify(virologist, times(1)).AddEquipment(equipment);

        verify(virologist, times(1)).DecreaseActions();
    } 
}
