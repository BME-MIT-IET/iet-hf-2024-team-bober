package virologist.model.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import virologist.model.Virologist;
import virologist.model.agents.Bear;
import virologist.model.map.Field;

import static org.mockito.Mockito.*;

import java.util.ArrayList;

class BearMoveTest {
    private BearMove bearMove;
    private Virologist virologist;
    private Field from;
    private Field to;
    private Field randomNeighbour;
    private ArrayList<Field> neighbours;
    private ArrayList<Virologist> virologists;
    private Virologist virologist1;
    private Virologist virologist2;

    @BeforeEach
    public void init() {
        virologist = mock(Virologist.class);
        from = mock(Field.class);
        to = mock(Field.class);
        randomNeighbour = mock(Field.class);
        neighbours = new ArrayList<>();
        neighbours.add(randomNeighbour);
        virologists = new ArrayList<>();
        virologist1 = mock(Virologist.class);
        virologist2 = mock(Virologist.class);
        virologists.add(virologist1);
        virologists.add(virologist2);
        bearMove = new BearMove(randomNeighbour);
    }

    @Test
    void moveTest() {
        // Arrange
        when(from.GetNeighbours()).thenReturn(neighbours);
        when(randomNeighbour.GetVirologists()).thenReturn(virologists);

        // Act
        bearMove.Move(virologist, from, to);
        
        // Assert
        verify(from, times(1)).RemoveVirologist(virologist);
        verify(randomNeighbour, times(1)).AddVirologist(virologist);
        verify(randomNeighbour, times(1)).DestroyMaterial();
        verify(virologist1, times(1)).TargetedWith(any(Bear.class));
        verify(virologist2, times(1)).TargetedWith(any(Bear.class));
        verify(virologist, times(1)).DecreaseActions();
    }
    
}
