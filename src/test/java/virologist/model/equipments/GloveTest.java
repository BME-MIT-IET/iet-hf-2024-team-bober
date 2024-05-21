package virologist.model.equipments;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import virologist.model.Virologist;
import virologist.model.agents.Stun;
import static org.mockito.Mockito.*;

class GloveTest {
    private Glove glove;
    private int useCount = 3;
    private Virologist virologist;
    private Virologist attacker;
    private Stun agent;
    
    @BeforeEach
    public void init() {
        glove = new Glove(useCount);
        virologist = mock(Virologist.class);
        attacker = mock(Virologist.class);
        agent = mock(Stun.class);
    }

    @Test
    void applyStrategy() {
        // Arrange

        // Act
        glove.ApplyStrategy(virologist);

        // Assert
        verify(virologist, times(1)).SetInjectedStr(glove);
    }

    @Test
    void injected_with_more_than_zero_useCount() {
        // Arrange

        // Act
        glove.Injected(virologist, agent);

        // Assert
        verify(virologist, times(0)).RemoveEquipment(glove);
        verify(virologist, times(0)).Reset();
        verify(virologist, times(0)).TargetedWith(agent);
    }

    @Test
    void injected_with_zero_useCount() {
        // Arrange
        glove = new Glove(0);

        // Act
        glove.Injected(virologist, agent);

        // Assert
        verify(virologist, times(1)).RemoveEquipment(glove);
        verify(virologist, times(1)).Reset();
        verify(virologist, times(1)).TargetedWith(agent);
    }

    @Test
    void injected_with_more_than_zero_useCount_two_virologists() {
        // Arrange

        // Act
        glove.Injected(attacker, virologist, agent);

        // Assert
        verify(attacker, times(1)).TargetedWith(virologist, agent);
    }

    @Test
    void injected_with_zero_useCount_two_virologists() {
        // Arrange
        glove = new Glove(0);

        // Act
        glove.Injected(attacker, virologist, agent);

        // Assert
        verify(virologist, times(1)).RemoveEquipment(glove);
        verify(virologist, times(1)).Reset();
        verify(virologist, times(1)).TargetedWith(attacker, agent);
    }
}
