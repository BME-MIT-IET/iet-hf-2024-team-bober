package virologist.view;

import virologist.model.map.Field;

//TODO comment

public class DrawableField extends Field implements Drawable {
    @Override
    public String getTexture() {
        return "/virologist/textures/Field.png";
    }
}
