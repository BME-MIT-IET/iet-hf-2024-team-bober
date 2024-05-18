package virologist.model.strategy;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import virologist.model.Virologist;
import virologist.model.agents.Agent;
import static org.mockito.Mockito.*;

class NoInjectedTest {
    private NoInjected noInjected;
    private Virologist by;
    private Virologist injected;
    private Agent agent;

    @BeforeEach
    public void init() {
        noInjected = new NoInjected();
        by = mock(Virologist.class);
        injected = mock(Virologist.class);
        agent = mock(Agent.class);
    }

    @Test
    void injectedTestSelf() {
        // Arrange

        // Act
        noInjected.Injected(injected, agent);
        
        // Assert
        verify(agent, times(0)).Apply(injected);
        verify(injected, times(0)).AddAgent(agent);
        verify(agent, times(0)).ApplyStrategy(injected);
    }

    @Test
    void injectedTestBy() {
        // Arrange

        // Act
        noInjected.Injected(by, injected, agent);
        
        // Assert
        verify(agent, times(0)).Apply(injected);
        verify(injected, times(0)).AddAgent(agent);
        verify(agent, times(0)).ApplyStrategy(injected);
    }
}
