package virologist.model.strategy;

import virologist.model.Virologist;
import virologist.model.map.Field;

/**
 * Genetikai kód tanulásért felelős stratégiát reprezentáló interfész.
 */
public interface ILearnStr {

	/**
	 * Egy genetikai kód megtanulásakor meghívott, az interakciót reprezentáló függvény.
	 * @param v Tanuló virológus
	 * @param f Virológus mezője
	 */
	void Learn(Virologist v, Field f);

}
