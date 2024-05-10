package virologist.view;

import virologist.model.equipments.Equipment;
import virologist.model.map.Shelter;

//TODO comment

public class DrawableShelter extends Shelter implements Drawable {
    /**
     * Védőfelszerelés hozzáadása
     *
     * @param e hozzáadandó felszerelés
     */
    public DrawableShelter(Equipment e) {
        super(e);
    }

    @Override
    public String getTexture() {
        return "/virologist/textures/Shelter.png";
    }
}
