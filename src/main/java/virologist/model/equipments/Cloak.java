package virologist.model.equipments;


import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.JDKRandomGenerator;
import virologist.model.Virologist;
import virologist.model.strategy.NoInjected;

/**
 * Védőfelszerelés, amely stratégiát biztosít viselőjén bizonyos eséllyel, érinthetetlenné teszi, ágensek felől
 */
public class Cloak extends Equipment {
	private RandomGenerator random;

	public Cloak() {
		random = new JDKRandomGenerator();
	}

	public Cloak(RandomGenerator secureRandom) {
		this.random = secureRandom;
	}

	/**
	 * Alkalmazza az ágensek felől érinthetetlen stratégiát bizonyos eséllyel
	 * @param v viselő virológus
	 */
	public void ApplyStrategy(Virologist v)
	{
		if (random.nextDouble() < 0.823)
			v.SetInjectedStr(new NoInjected());
	}
}
