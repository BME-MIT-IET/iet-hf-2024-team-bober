package virologist.view;

import virologist.model.codes.GeneticCode;
import virologist.model.map.Laboratory;

//TODO comment

public class DrawableLaboratory extends Laboratory implements Drawable{
    /**
     * Genetikai kód hozzáadása a mezőhöz
     *
     * @param c hozzáadandó genetikai kód
     */
    public DrawableLaboratory(GeneticCode c) {
        super(c);
    }

    @Override
    public String getTexture() {
        return "/virologist/textures/Laboratory.png";
    }
}
