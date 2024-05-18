package virologist.model.strategy;

import virologist.model.Virologist;
import virologist.model.map.Field;

/**
 * Mozgásért felelős stratégiát reprezentáló interfész.
 */
public interface IMoveStr {
	/**
	 * Virológus mozgásakor meghívott, az interakciót reprezentáló függvény.
	 * @param v Mozgó virológus
	 * @param from Virológus aktuális mezője
	 * @param to Új mező, amelyre lépni szeretne
	 */
	void Move(Virologist v, Field from, Field to);
}
