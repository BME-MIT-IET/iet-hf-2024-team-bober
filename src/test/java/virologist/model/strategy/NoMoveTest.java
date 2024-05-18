package virologist.model.strategy;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import virologist.model.Virologist;
import virologist.model.map.Field;

class NoMoveTest {
    private NoMove noMove;
    private Virologist virologist;
    private Field from;
    private Field to;

    @BeforeEach
    public void init() {
        noMove = new NoMove();
        virologist = mock(Virologist.class);
        from = mock(Field.class);
        to = mock(Field.class);
    }

    @Test
    void moveTest() {
        // Arrange

        // Act
        noMove.Move(virologist, from, to);
        
        // Assert
        verify(from, times(0)).RemoveVirologist(virologist);
        verify(to, times(0)).AddVirologist(virologist);
        verify(virologist, times(1)).DecreaseActions();
    }
}
