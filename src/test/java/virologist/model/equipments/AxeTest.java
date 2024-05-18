package virologist.model.equipments;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import virologist.model.Virologist;
import static org.mockito.Mockito.*;

class AxeTest {
    private Axe axe;
    private Virologist ownerVirologist;
    private Virologist targeVirologist;

    @BeforeEach
    public void init() {
        axe = new Axe();
        ownerVirologist = mock(Virologist.class);
        targeVirologist = mock(Virologist.class);
    }

    @Test
    void applyStrategy_when_used() {
        // Arrange
        // A tamadas miatt elvart esetben az used == true lesz az axe-ben.
        axe.Attack(ownerVirologist, targeVirologist);

        // Act
        axe.ApplyStrategy(ownerVirologist);

        // Assert
        verify(ownerVirologist, times(0)).SetAttackStr(axe);
    }

    @Test
    void applyStrategy_when_not_used() {
        // Arrange

        // Act
        axe.ApplyStrategy(ownerVirologist);

        // Assert
        verify(ownerVirologist, times(1)).SetAttackStr(axe);
    }

    @Test
    void attack() {
        // Arrange

        // Act
        axe.Attack(ownerVirologist, targeVirologist);
        // A tamadas utan elvart, hogy az axe-ben az used == false, ezert az axe.ApplyStrategy(ownerVirologist)-nek nem lehet hatasa az ownerVirologist-ra.
        axe.ApplyStrategy(ownerVirologist);

        // Assert
        verify(ownerVirologist, times(1)).DecreaseActions();
        verify(targeVirologist, times(1)).Kill();

        // Ha elvart modon used == false, akkor az ownerVirologist.SetAttackStr(axe) nem futhat le.
        verify(ownerVirologist, times(0)).SetAttackStr(axe);

        verify(ownerVirologist, times(1)).Reset();
    }
}