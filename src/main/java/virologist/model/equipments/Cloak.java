package virologist.model.equipments;


import virologist.model.Virologist;
import virologist.model.strategy.NoInjected;

/**
 * Védőfelszerelés, amely stratégiát biztosít viselőjén bizonyos eséllyel, érinthetetlenné teszi, ágensek felől
 */
public class Cloak extends Equipment
{
	private double fixRandom;
	private boolean fixRandomUsed;

	public Cloak() {
		fixRandom = 0.0;
		fixRandomUsed = false;
	}

	public Cloak(double fixRandom) {
		this.fixRandom = fixRandom;
		fixRandomUsed = true;
	}

	private double getRandom() {
		if (fixRandomUsed) {
			return fixRandom;
		} else {
			return Math.random();
		}
	}

	/**
	 * Alkalmazza az ágensek felől érinthetetlen stratégiát bizonyos eséllyel
	 * @param v viselő virológus
	 */
	public void ApplyStrategy(Virologist v)
	{
		if (getRandom() < 0.823)
			v.SetInjectedStr(new NoInjected());
	}
}
