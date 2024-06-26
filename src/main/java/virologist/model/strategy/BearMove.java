package virologist.model.strategy;

import virologist.model.Virologist;
import virologist.model.agents.Bear;
import virologist.model.map.Field;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;


public class BearMove implements IMoveStr {
    Field randomNeighbour;

	public BearMove() {
	}

    public BearMove(Field randomNeighbour) {
        this.randomNeighbour = randomNeighbour;
	}

    @Override
    public void Move(Virologist v, Field from, Field to) {

        ArrayList<Field> neighbours = from.GetNeighbours();
        from.RemoveVirologist(v);

        randomNeighbour = neighbours.get(ThreadLocalRandom.current().nextInt(0, neighbours.size()));

        randomNeighbour.AddVirologist(v);
        randomNeighbour.DestroyMaterial();
        
        for (Virologist vir : randomNeighbour.GetVirologists()) {
            vir.TargetedWith(new Bear());
        }
        
        v.DecreaseActions();
    }
}
