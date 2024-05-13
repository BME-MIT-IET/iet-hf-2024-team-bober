package virologist.model.map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import virologist.model.Virologist;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class WarehouseTest {
    private Virologist virologist;
    private Warehouse warehouse;
    private int delta;

    @BeforeEach
    public void init() {
        virologist = mock(Virologist.class);
        delta = 5;
    }

    @Test
    void CollectMaterialTest_AminoAcid() {
        // Arrange
        warehouse = new Warehouse(delta, 0);

        // Act
        warehouse.CollectMaterial(virologist);
        
        // Assert
        verify(virologist, times(1)).AddAminoAcid(delta);
        verify(virologist, times(0)).AddNucleotide(anyInt());
    }

    @Test
    void CollectMaterialTest_Nucleotide() {
        // Arrange
        warehouse = new Warehouse(delta, 1);

        // Act
        warehouse.CollectMaterial(virologist);
        
        // Assert
        verify(virologist, times(0)).AddAminoAcid(anyInt());
        verify(virologist, times(1)).AddNucleotide(delta);
    }

    @Test
    void DestroyMaterial_ThenCollectMaterialTest_AminoAcid() {
        // Arrange
        warehouse = new Warehouse(delta, 0);

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
        warehouse = new Warehouse(delta, 1);

        // Act
        warehouse.DestroyMaterial();
        warehouse.CollectMaterial(virologist);
        
        // Assert
        verify(virologist, times(0)).AddAminoAcid(anyInt());
        verify(virologist, times(1)).AddNucleotide(0);
    }
}