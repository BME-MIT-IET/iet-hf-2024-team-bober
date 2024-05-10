package virologist.view;

import virologist.model.map.Warehouse;

//TODO comment

public class DrawableWarehouse extends Warehouse implements Drawable {
    @Override
    public String getTexture() {

        return "/virologist/textures/Warehouse.png";
    }
}
