package virologist.model.map;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import virologist.model.Virologist;
import virologist.model.agents.Bear;
import virologist.model.codes.GeneticCode;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class InfectedLaboratoryTest {
    private Virologist virologist;
    private GeneticCode geneticCode;
    private InfectedLaboratory infectedLaboratory;

    @BeforeEach
    public void init() {
        virologist = mock(Virologist.class);
        geneticCode = mock(GeneticCode.class);
        infectedLaboratory = new InfectedLaboratory(geneticCode);
    }

    @Test
    void AddVirologistTest() {
        // Arrange

        // Act
        infectedLaboratory.AddVirologist(virologist);
        
        // Assert
        verify(virologist, times(1)).TargetedWith(any(Bear.class));
        assertTrue(infectedLaboratory.virologists.contains(virologist));
    }
}