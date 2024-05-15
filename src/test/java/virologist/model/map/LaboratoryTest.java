package virologist.model.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import virologist.model.Virologist;
import virologist.model.codes.GeneticCode;
import static org.mockito.Mockito.*;

class LaboratoryTest {
    private Virologist virologist;
    private GeneticCode geneticCode;
    private Laboratory laboratory;

    @BeforeEach
    public void init() {
        virologist = mock(Virologist.class);
        geneticCode = mock(GeneticCode.class);
        laboratory = new Laboratory(geneticCode);
    }

    @Test
    void LearnGeneticCode() {
        // Arrange

        // Act
        laboratory.LearnGeneticCode(virologist);
        
        // Assert
        verify(virologist, times(1)).AddGeneticCode(geneticCode);
    }
}