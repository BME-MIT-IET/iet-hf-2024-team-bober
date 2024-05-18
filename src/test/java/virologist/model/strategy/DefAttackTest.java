package virologist.model.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import virologist.model.Virologist;
import static org.mockito.Mockito.*;

class DefAttackTest {
    private DefAttack defAttack;
    private Virologist attacker;
    private Virologist target;

     @BeforeEach
    public void init() {
        defAttack = new DefAttack();
        attacker = mock(Virologist.class);
        target = mock(Virologist.class);
    }

    @Test
    void attackTest() {
        // Arrange

        // Act
        defAttack.Attack(attacker, target);
        
        // Assert
        verify(attacker, times(1)).DecreaseActions();
    }
}
