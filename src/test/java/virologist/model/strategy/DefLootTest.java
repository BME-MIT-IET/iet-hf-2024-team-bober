package virologist.model.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import virologist.model.Virologist;
import static org.mockito.Mockito.*;

class DefLootTest {
    private DefLoot defLoot;
    private Virologist attacker;
    private Virologist target;

     @BeforeEach
    public void init() {
        defLoot = new DefLoot();
        attacker = mock(Virologist.class);
        target = mock(Virologist.class);
    }

    @Test
    void lootAminoTest() {
        // Arrange

        // Act
        defLoot.LootAmino(attacker, target);
        
        // Assert
        verify(attacker, times(1)).DecreaseActions();
        verify(target, times(1)).StealAminoAcid(attacker);
    }

    @Test
    void lootNucleotide() {
        // Arrange

        // Act
        defLoot.LootNucleotide(attacker, target);
        
        // Assert
        verify(attacker, times(1)).DecreaseActions();
        verify(target, times(1)).StealNukleotid(attacker);
    }

    @Test
    void lootEquipment() {
        // Arrange

        // Act
        defLoot.LootEquipment(attacker, target);
        
        // Assert
        verify(attacker, times(1)).DecreaseActions();
        verify(target, times(1)).StealEquipment(attacker);
    }
}