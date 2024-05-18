package virologist.model.strategy;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import virologist.model.Virologist;
import virologist.model.map.Field;
import static org.mockito.Mockito.*;

class DefMoveTest {
    private DefMove defMove;
    private Virologist virologist;
    private Field from;
    private Field to;

    @BeforeEach
    public void init() {
        defMove = new DefMove();
        virologist = mock(Virologist.class);
        from = mock(Field.class);
        to = mock(Field.class);
    }

    @Test
    void moveTest() {
        // Arrange

        // Act
        defMove.Move(virologist, from, to);
        
        // Assert
        verify(from, times(1)).RemoveVirologist(virologist);
        verify(to, times(1)).AddVirologist(virologist);
        verify(virologist, times(1)).DecreaseActions();
    }
}
