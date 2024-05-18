package virologist.model.strategy;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import virologist.model.Virologist;
import virologist.model.map.Field;

class DefEquipTest {
    private DefEquip defEquip;
    private Virologist virologist;
    private Field field;

    @BeforeEach
    public void init() {
        defEquip = new DefEquip();
        virologist = mock(Virologist.class);
        field = mock(Field.class);
    }

    @Test
    void equipTest() {
        // Arrange

        // Act
        defEquip.Equip(virologist, field);

        // Assert
        (verify(field, times(1))).PickUpEquipment(virologist);
        verify(virologist, times(1)).DecreaseActions();
    } 
}
