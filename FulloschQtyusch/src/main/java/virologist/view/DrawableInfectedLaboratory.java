package virologist.view;

import virologist.model.codes.GeneticCode;
import virologist.model.map.InfectedLaboratory;

//TODO comment

public class DrawableInfectedLaboratory extends InfectedLaboratory implements Drawable {
    /**
     * Genetikai kód hozzáadása a mezőhöz
     *
     * @param c hozzáadandó genetikai kód
     */
    public DrawableInfectedLaboratory(GeneticCode c) {
        super(c);
    }

    @Override
    public String getTexture() {
        return "/virologist/textures/InfectedLaboratory.png";
    }
}
