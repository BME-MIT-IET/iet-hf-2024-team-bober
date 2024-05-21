package virologist.model.strategy;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import virologist.model.Virologist;
import virologist.model.agents.Agent;
import virologist.model.codes.GeneticCode;

class DefInjectTest {
    private DefInject defInject;
    private Virologist attacker;
    private Virologist target;
    private GeneticCode geneticCode;
    private Agent agent;

     @BeforeEach
    public void init() {
        defInject = new DefInject();
        attacker = mock(Virologist.class);
        target = mock(Virologist.class);
        geneticCode = mock(GeneticCode.class);
        agent = mock(Agent.class);
    }

    @Test
    void injectTest_enough_material() throws Exception {
        // Arrange
        doNothing().when(target).TargetedWith(attacker, agent);
        when(geneticCode.Create(attacker)).thenReturn(agent);
        
        // Act and Assert
        assertDoesNotThrow(() -> defInject.Inject(attacker, target, geneticCode));
        verify(attacker, times(1)).DecreaseActions();
        verify(geneticCode, times(1)).Create(attacker);
        verify(target, times(1)).TargetedWith(attacker, agent);
    }

    @Test
    void injectTest_not_enough_material() throws Exception {
        // Arrange
        doThrow(new Exception("I don't have enough material!")).when(geneticCode).Create(attacker);

        // Act and Assert
        assertDoesNotThrow(() -> defInject.Inject(attacker, target, geneticCode));
        verify(attacker, times(1)).DecreaseActions();
        verify(geneticCode, times(1)).Create(attacker);
        verify(target, times(0)).TargetedWith(attacker, agent);
    }
}
