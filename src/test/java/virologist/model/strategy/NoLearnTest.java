package virologist.model.strategy;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import virologist.model.Virologist;
import virologist.model.map.Field;

class NoLearnTest {
    private NoLearn noLearn;
    private Virologist virologist;
    private Field field;

    @BeforeEach
    public void init() {
        noLearn = new NoLearn();
        virologist = mock(Virologist.class);
        field = mock(Field.class);
    }

    @Test
    void learnTest() {
        // Arrange

        // Act
        noLearn.Learn(virologist, field);
        
        // Assert
        verify(field, times(0)).LearnGeneticCode(virologist);
        verify(virologist, times(1)).DecreaseActions();
    }
}
