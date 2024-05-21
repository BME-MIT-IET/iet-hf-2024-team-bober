package virologist.model.strategy;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import virologist.model.Virologist;

class NoLootTest {
    private NoLoot noLoot;
    private Virologist attacker;
    private Virologist target;

     @BeforeEach
    public void init() {
        noLoot = new NoLoot();
        attacker = mock(Virologist.class);
        target = mock(Virologist.class);
    }

    @Test
    void lootAminoTest() {
        // Arrange

        // Act
        noLoot.LootAmino(attacker, target);
        
        // Assert
        verify(attacker, times(1)).DecreaseActions();
        verify(target, times(0)).StealAminoAcid(attacker);
    }

    @Test
    void lootNucleotide() {
        // Arrange

        // Act
        noLoot.LootNucleotide(attacker, target);
        
        // Assert
        verify(attacker, times(1)).DecreaseActions();
        verify(target, times(0)).StealNukleotid(attacker);
    }

    @Test
    void lootEquipment() {
        // Arrange

        // Act
        noLoot.LootEquipment(attacker, target);
        
        // Assert
        verify(attacker, times(1)).DecreaseActions();
        verify(target, times(0)).StealEquipment(attacker);
    }
}
