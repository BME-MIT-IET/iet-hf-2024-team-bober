package virologist.model.strategy;

import virologist.model.Virologist;
import virologist.model.equipments.Equipment;
import virologist.model.map.Field;

/**
 * Felszerelés sikertelen eldobásáért felelős stratégia.
 */
public class NoDrop implements IDropStr {

	/**
	 * Felszerelés sikertelen eldobását implementáló függvény.
	 * @param v Dobó virológus
	 * @param f Virológus mezője
	 * @param e Eldobandó felszerelés
	 */
	@Override
	public void Drop(Virologist v, Field f, Equipment e) {
		v.AddEquipment(e);
		v.DecreaseActions();
	}

}
