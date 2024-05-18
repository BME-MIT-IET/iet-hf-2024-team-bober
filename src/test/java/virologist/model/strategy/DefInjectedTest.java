package virologist.model.strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import virologist.model.Virologist;
import virologist.model.agents.Agent;
import static org.mockito.Mockito.*;

class DefInjectedTest {
    private DefInjected defInjected;
    private Virologist by;
    private Virologist injected;
    private Agent agent;

    @BeforeEach
    public void init() {
        defInjected = new DefInjected();
        by = mock(Virologist.class);
        injected = mock(Virologist.class);
        agent = mock(Agent.class);
    }

    @Test
    void injectedTestSelf() {
        // Arrange

        // Act
        defInjected.Injected(injected, agent);
        
        // Assert
        verify(agent, times(1)).Apply(injected);
        verify(injected, times(1)).AddAgent(agent);
        verify(agent, times(1)).ApplyStrategy(injected);
    }

    @Test
    void injectedTestBy() {
        // Arrange

        // Act
        defInjected.Injected(by, injected, agent);
        
        // Assert
        verify(agent, times(1)).Apply(injected);
        verify(injected, times(1)).AddAgent(agent);
        verify(agent, times(1)).ApplyStrategy(injected);
    }
}
