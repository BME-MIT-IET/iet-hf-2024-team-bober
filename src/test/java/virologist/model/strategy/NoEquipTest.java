package virologist.model.strategy;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import virologist.model.Virologist;
import virologist.model.map.Field;

class NoEquipTest {
    private NoEquip noEquip;
    private Virologist virologist;
    private Field field;

    @BeforeEach
    public void init() {
        noEquip = new NoEquip();
        virologist = mock(Virologist.class);
        field = mock(Field.class);
    }

    @Test
    void equipTest() {
        // Arrange

        // Act
        noEquip.Equip(virologist, field);

        // Assert
        (verify(field, times(0))).PickUpEquipment(virologist);
        verify(virologist, times(1)).DecreaseActions();
    } 
}
