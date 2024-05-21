package virologist.model.agents;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import virologist.model.Virologist;
import virologist.model.strategy.Looted;
import virologist.model.strategy.NoCollect;
import virologist.model.strategy.NoDrop;
import virologist.model.strategy.NoEquip;
import virologist.model.strategy.NoInject;
import virologist.model.strategy.NoInjected;
import virologist.model.strategy.NoLearn;
import virologist.model.strategy.NoLoot;
import virologist.model.strategy.NoMove;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class StunTest {
    private Stun forget;
    private Virologist virologist;
    private int timeToLive = 3;

    @BeforeEach
    public void init() {
        forget = new Stun(timeToLive);
        virologist = mock(Virologist.class);
    }

    @Test
    void ApplyStrategyTest() {
        // Arrange

        // Act
        forget.ApplyStrategy(virologist);
        
        // Assert
        verify(virologist, times(1)).SetInjectedStr(any(NoInjected.class));
        verify(virologist, times(1)).SetCollectStr(any(NoCollect.class));
        verify(virologist, times(1)).SetDropStr(any(NoDrop.class));
        verify(virologist, times(1)).SetEquipStr(any(NoEquip.class));
        verify(virologist, times(1)).SetInjectStr(any(NoInject.class));
        verify(virologist, times(1)).SetLearnStr(any(NoLearn.class));
        verify(virologist, times(1)).SetLootedStr(any(Looted.class));
        verify(virologist, times(1)).SetLootStr(any(NoLoot.class));
        verify(virologist, times(1)).SetMoveStr(any(NoMove.class));
    }
}