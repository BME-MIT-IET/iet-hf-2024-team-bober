package virologist.model.strategy;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import virologist.model.Virologist;
import virologist.model.agents.Agent;
import virologist.model.codes.GeneticCode;

class NoInjectTest {
    private NoInject noInject;
    private Virologist attacker;
    private Virologist target;
    private GeneticCode geneticCode;
    private Agent agent;

     @BeforeEach
    public void init() {
        noInject = new NoInject();
        attacker = mock(Virologist.class);
        target = mock(Virologist.class);
        geneticCode = mock(GeneticCode.class);
        agent = mock(Agent.class);
    }

    @Test
    void injectTest() throws Exception {
        // Arrange
        
        // Act
        noInject.Inject(attacker, target, geneticCode);

        // Assert
        verify(attacker, times(1)).DecreaseActions();
        verify(geneticCode, times(0)).Create(attacker);
        verify(target, times(0)).TargetedWith(attacker, agent);
    }
}
