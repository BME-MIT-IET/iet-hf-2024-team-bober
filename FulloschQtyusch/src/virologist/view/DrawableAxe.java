package virologist.view;

import virologist.model.equipments.Axe;

/**
 * A fejszének a képernyőre kirajzolható változata.
 */
public class DrawableAxe extends Axe implements Drawable {

    /**
     * Visszatér a fejsze textúrájának az elérési útjával.
     *
     * @return Az elérési út
     */
    @Override
    public String getTexture(){
        return "/virologist/textures/fejszeSlot.png";
    }

}
