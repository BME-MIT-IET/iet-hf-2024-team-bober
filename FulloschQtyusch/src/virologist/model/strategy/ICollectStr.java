package virologist.model.strategy;

import virologist.model.Virologist;
import virologist.model.map.Field;

/**
 * Anyag gyüjtésért felelős stratégiát reprezentáló interfész.
 */
public interface ICollectStr {

	/**
	 * Anyag gyüjtésekor meghívott, az interakciót reprezentáló függvény.
	 * @param v Gyüjtő virológus
	 * @param f A mező, ahol van az anyag
	 */
	void Collect(Virologist v, Field f);

}
