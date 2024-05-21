package virologist.model.map;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import virologist.model.Virologist;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import org.apache.commons.math3.random.JDKRandomGenerator;

class WarehouseTest {
    private Virologist virologist;
    private Warehouse warehouse;
    private int delta;
    private JDKRandomGenerator random;

    @BeforeEach
    public void init() {
        virologist = mock(Virologist.class);
        delta = 5;
        random = mock(JDKRandomGenerator.class);
        warehouse = new Warehouse(delta, random);
    }

    @Test
    void CollectMaterialTest_AminoAcid() {
        // Arrange
        when(random.nextInt(anyInt())).thenReturn(0);

        // Act
        warehouse.CollectMaterial(virologist);
        
        // Assert
        verify(virologist, times(1)).AddAminoAcid(delta);
        verify(virologist, times(0)).AddNucleotide(anyInt());
    }

    @Test
    void CollectMaterialTest_Nucleotide() {
        // Arrange
        when(random.nextInt(anyInt())).thenReturn(1);

        // Act
        warehouse.CollectMaterial(virologist);
        
        // Assert
        verify(virologist, times(0)).AddAminoAcid(anyInt());
        verify(virologist, times(1)).AddNucleotide(delta);
    }

    @Test
    void DestroyMaterial_ThenCollectMaterialTest_AminoAcid() {
        // Arrange
        when(random.nextInt(anyInt())).thenReturn(0);

        // Act
        warehouse.DestroyMaterial();
        warehouse.CollectMaterial(virologist);
        
        // Assert
        verify(virologist, times(1)).AddAminoAcid(0);
        verify(virologist, times(0)).AddNucleotide(anyInt());
    }

    @Test
    void DestroyMaterial_ThenCollectMaterialTest_Nucleotide() {
        // Arrange
        when(random.nextInt(anyInt())).thenReturn(1);

        // Act
        warehouse.DestroyMaterial();
        warehouse.CollectMaterial(virologist);
        
        // Assert
        verify(virologist, times(0)).AddAminoAcid(anyInt());
        verify(virologist, times(1)).AddNucleotide(0);
    }
}