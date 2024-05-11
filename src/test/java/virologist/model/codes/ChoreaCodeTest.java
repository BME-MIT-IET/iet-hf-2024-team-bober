package virologist.model.codes;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import virologist.model.Virologist;
import static org.mockito.Mockito.*;

class ChoreaCodeTest {
    private ChoreaCode choreaCode;
    int aminoAcidPrice = 5;
	int nucleotidePrice = 6;
	int turnsLeft = 1;
    private Virologist virologist;

    @BeforeEach
    public void init() {
        choreaCode = new ChoreaCode(aminoAcidPrice, nucleotidePrice, turnsLeft);
        virologist = mock(Virologist.class);
    }

    @Test
    void create_virologist_has_enough_aminoAcid_and_nucleotide() throws Exception {
        // Arrange
        doNothing().when(virologist).RemoveNucleotide(nucleotidePrice);
        doNothing().when(virologist).RemoveAminoAcid(aminoAcidPrice);

        // Act and Assert
        assertDoesNotThrow(() -> choreaCode.Create(virologist));
        verify(virologist, times(1)).RemoveNucleotide(nucleotidePrice);
        verify(virologist, times(1)).RemoveAminoAcid(aminoAcidPrice);
        verify(virologist, times(0)).AddNucleotide(nucleotidePrice);
    }

    @Test
    void create_virologist_has_enough_aminoAcid_but_not_enough_nucleotide() throws Exception {
        // Arrange
        doThrow(new Exception("I don't have such many nucleotide!")).when(virologist).RemoveNucleotide(nucleotidePrice);
        doNothing().when(virologist).RemoveAminoAcid(aminoAcidPrice);

        // Act and Assert
        Exception exception = assertThrows(Exception.class, () -> {
            choreaCode.Create(virologist);
        });
        assertEquals("I don't have such many nucleotide!", exception.getMessage());
        verify(virologist, times(1)).RemoveNucleotide(nucleotidePrice);
        verify(virologist, times(0)).RemoveAminoAcid(aminoAcidPrice);
        verify(virologist, times(0)).AddNucleotide(nucleotidePrice);
    }

    @Test
    void create_virologist_has_enough_nucleotide_but_not_enough_aminoAcid() throws Exception {
        // Arrange
        doNothing().when(virologist).RemoveNucleotide(nucleotidePrice);
        doThrow(new Exception("I don't have such many amino acid!")).when(virologist).RemoveAminoAcid(aminoAcidPrice);

        // Act and Assert
        Exception exception = assertThrows(Exception.class, () -> {
            choreaCode.Create(virologist);
        });
        assertEquals("I don't have such many amino acid!", exception.getMessage());
        verify(virologist, times(1)).RemoveNucleotide(nucleotidePrice);
        verify(virologist, times(1)).RemoveAminoAcid(aminoAcidPrice);
        verify(virologist, times(1)).AddNucleotide(nucleotidePrice);
    }

    @Test
    void create_virologist_has_not_enough_nucleotide_and_aminoAcid() throws Exception {
        // Arrange
        doThrow(new Exception("I don't have such many nucleotide!")).when(virologist).RemoveNucleotide(nucleotidePrice);
        doThrow(new Exception("I don't have such many amino acid!")).when(virologist).RemoveAminoAcid(aminoAcidPrice);

        // Act and Assert
        Exception exception = assertThrows(Exception.class, () -> {
            choreaCode.Create(virologist);
        });
        assertEquals("I don't have such many nucleotide!", exception.getMessage());
        verify(virologist, times(1)).RemoveNucleotide(nucleotidePrice);
        verify(virologist, times(0)).RemoveAminoAcid(aminoAcidPrice);
        verify(virologist, times(0)).AddNucleotide(nucleotidePrice);
    }
}
