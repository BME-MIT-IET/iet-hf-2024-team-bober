package virologist.model.map;

import virologist.model.Virologist;
import virologist.model.agents.Bear;
import virologist.model.codes.GeneticCode;

/**
 * Olyan laboratórium, amelyen a virológus megfertőződik medve vírussal
 */
public class InfectedLaboratory extends Laboratory{
    /**
     * Genetikai kód hozzáadása a mezőhöz
     *
     * @param c hozzáadandó genetikai kód
     */
    public InfectedLaboratory(GeneticCode c) {
        super(c);
    }

    /**
     * Virológus elhelyezése a mezőn és megfertőzése
     * @param v elehelyezendő virológus
     */
    @Override
    public void AddVirologist(Virologist v){
        v.TargetedWith(new Bear());
        super.AddVirologist(v);
    }
}
