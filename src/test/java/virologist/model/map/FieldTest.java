package virologist.model.map;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import virologist.model.Virologist;
import virologist.model.equipments.Equipment;
import static org.mockito.Mockito.*;
import java.util.ArrayList;

class FieldTest {
    private Field field;
    private Field neighbourFieldMock;
    private Virologist virologist;
    private Equipment equipment;
    private ArrayList<Field> neighbours;
    private ArrayList<Virologist> virologists;
    @Mock
    private ArrayList<Equipment> equipments;

    @SuppressWarnings("unchecked")
    @BeforeEach
    public void init() {
        neighbours = mock(ArrayList.class);
        virologists = mock(ArrayList.class);
        equipments = mock(ArrayList.class);

        field = new Field(neighbours, virologists, equipments);

        virologist = mock(Virologist.class);
        neighbourFieldMock = mock(Field.class);
        equipment = mock(Equipment.class);
    }

    @Test
    void AddNeighbourTest_when_contained() {
        // Arrange
        when(neighbours.contains(neighbourFieldMock)).thenReturn(true);

        // Act
        field.AddNeighbour(neighbourFieldMock);
        
        // Assert
        verify(neighbours, times(1)).contains(neighbourFieldMock);
        verify(neighbours, times(0)).add(neighbourFieldMock);
    }

    @Test
    void AddNeighbourTest_when_not_contained() {
        // Arrange
        when(neighbours.contains(neighbourFieldMock)).thenReturn(false);

        // Act
        field.AddNeighbour(neighbourFieldMock);
        
        // Assert
        verify(neighbours, times(1)).contains(neighbourFieldMock);
        verify(neighbours, times(1)).add(neighbourFieldMock);
    }

    @Test
    void AddVirologistTest() {
        // Arrange

        // Act
        field.AddVirologist(virologist);
        
        // Assert
        verify(virologists, times(1)).add(virologist);
        verify(virologist, times(1)).SetField(field);
    }

    @Test
    void RemoveVirologistTest() {
        // Arrange

        // Act
        field.RemoveVirologist(virologist);
        
        // Assert
        verify(virologists, times(1)).remove(virologist);
    }

    @Test
    void DropTest() {
        // Arrange

        // Act
        field.Drop(equipment);
        
        // Assert
        verify(equipments, times(1)).add(equipment);
    }

    @Test
    void PickUpEquipmentTest_when_equipments_empty() {
        // Arrange
        when(equipments.size()).thenReturn(0);
        when(equipments.remove(anyInt())).thenReturn(equipment);

        // Act
        field.PickUpEquipment(virologist);
        
        // Assert
        verify(equipments, times(0)).remove(anyInt());
        verify(virologist, times(0)).AddEquipment(equipment);
    }

    @Test
    void PickUpEquipmentTest_when_equipments_not_empty() {
        // Arrange
        when(equipments.size()).thenReturn(1);
        when(equipments.remove(anyInt())).thenReturn(equipment);

        // Act
        field.PickUpEquipment(virologist);
        
        // Assert
        verify(equipments, times(1)).remove(anyInt());
        verify(virologist, times(1)).AddEquipment(equipment);
    }
}