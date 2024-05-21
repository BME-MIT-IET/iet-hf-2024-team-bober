package virologist.model.strategy;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import virologist.model.Virologist;
import virologist.model.equipments.Equipment;
import static org.mockito.Mockito.*;

class DefLootedTest {
    private DefLooted defLooted;
    private Virologist attacker;
    private Virologist target;
    private Equipment equipment;

     @BeforeEach
    public void init() {
        defLooted = new DefLooted();
        attacker = mock(Virologist.class);
        target = mock(Virologist.class);
        equipment = mock(Equipment.class);
    }

    @Test
    void lootedForEquipmentTest() {
        // Arrange

        // Act
        defLooted.LootedForEquipment(attacker, target, equipment);
        
        // Assert
        verify(target, times(0)).StealEquipment(attacker);
    }

    @Test
    void lootedForAminoAcidTest() {
        // Arrange

        // Act
        defLooted.LootedForAminoAcid(attacker, target);
        
        // Assert
        verify(target, times(0)).StealAminoAcid(attacker);
    }

    @Test
    void lootedForNukleotideTest() {
        // Arrange

        // Act
        defLooted.LootedForNukleotide(attacker, target);
        
        // Assert
        verify(target, times(0)).StealNukleotid(attacker);
    }
}
