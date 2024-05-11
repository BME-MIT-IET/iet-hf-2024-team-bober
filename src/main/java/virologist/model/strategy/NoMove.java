package virologist.model.strategy;

import virologist.model.Virologist;
import virologist.model.map.Field;

/**
 * Sikertelen mozgásért felelős stratégia.
 */
public class NoMove implements IMoveStr {

	/**
	 * Sikertelen mozgást implementáló függvény.
	 * @param v Mozgó virológus
	 * @param from Virológus aktuális mezője
	 * @param to Új mező, amelyre lépni szeretne
	 */
	@Override
	public void Move(Virologist v, Field from, Field to) {
		v.DecreaseActions();
	}

}
