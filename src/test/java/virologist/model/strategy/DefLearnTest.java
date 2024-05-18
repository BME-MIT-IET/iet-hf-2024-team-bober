package virologist.model.strategy;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import virologist.model.Virologist;
import virologist.model.map.Field;

class DefLearnTest {
    private DefLearn defLearn;
    private Virologist virologist;
    private Field field;

    @BeforeEach
    public void init() {
        defLearn = new DefLearn();
        virologist = mock(Virologist.class);
        field = mock(Field.class);
    }

    @Test
    void learnTest() {
        // Arrange

        // Act
        defLearn.Learn(virologist, field);
        
        // Assert
        verify(field, times(1)).LearnGeneticCode(virologist);
        verify(virologist, times(1)).DecreaseActions();
    }
}
