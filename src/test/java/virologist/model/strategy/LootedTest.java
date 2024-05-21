package virologist.model.strategy;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import virologist.model.Virologist;
import virologist.model.equipments.Equipment;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class LootedTest {
    private Looted looted;
    private Virologist attacker;
    private Virologist target;
    private Equipment equipment;
    private int delta;

    @BeforeEach
    public void init() {
        delta = 1;
        looted = new Looted(delta);
        attacker = mock(Virologist.class);
        target = mock(Virologist.class);
        equipment = mock(Equipment.class);
    }

    @Test
    void lootedForEquipmentTest() {
        // Arrange

        // Act
        looted.LootedForEquipment(attacker, target, equipment);
        
        // Assert
        verify(equipment, times(1)).Disable(target);
        verify(target, times(1)).RemoveEquipment(equipment);
        verify(attacker, times(1)).AddEquipment(equipment);
    }

    @Test
    void lootedForAminoAcidTest_something_to_steal() throws Exception {
        // Arrange
        doNothing().when(target).RemoveAminoAcid(delta);

        // Act and Assert
        assertDoesNotThrow(() -> looted.LootedForAminoAcid(attacker, target));
        verify(target, times(1)).RemoveAminoAcid(delta);
        verify(attacker, times(1)).AddAminoAcid(delta);
    }

    @Test
    void lootedForAminoAcidTest_nothing_to_steal() throws Exception {
        // Arrange
        doThrow(new Exception("I don't have it!")).when(target).RemoveAminoAcid(anyInt());

        // Act and Assert
        assertDoesNotThrow(() -> looted.LootedForAminoAcid(attacker, target));
        verify(target, times(1)).RemoveAminoAcid(delta);
        verify(attacker, times(0)).AddAminoAcid(anyInt());
    }

    @Test
    void lootedForNukleotideTest_something_to_steal() throws Exception {
        // Arrange
        doNothing().when(target).RemoveNucleotide(delta);

        // Act and Assert
        assertDoesNotThrow(() -> looted.LootedForNukleotide(attacker, target));
        verify(target, times(1)).RemoveNucleotide(delta);
        verify(attacker, times(1)).AddNucleotide(delta);
    }

    @Test
    void lootedForNukleotideTest_nothing_to_steal() throws Exception {
        // Arrange
        doThrow(new Exception("I don't have it!")).when(target).RemoveNucleotide(delta);

        // Act and Assert
        assertDoesNotThrow(() -> looted.LootedForNukleotide(attacker, target));
        verify(target, times(1)).RemoveNucleotide(delta);
        verify(attacker, times(0)).AddNucleotide(anyInt());
    }
}
