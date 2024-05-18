package virologist.model.map;


import virologist.model.Virologist;
import org.apache.commons.math3.random.RandomGenerator;
import org.apache.commons.math3.random.JDKRandomGenerator;

/**
 * Olyan mező, amelyen anyag gyüjthető
 */
public class Warehouse extends Field
{
	/**
	 * Ennyivel növeli a virológusok anyagát
	 */
	private int delta;
	private RandomGenerator random;

	public Warehouse() {
		delta = 5;
		this.random = new JDKRandomGenerator();
	}

	public Warehouse(int delta, JDKRandomGenerator random) {
		this.delta = delta;
		this.random = random;
	}

	/**
	 * Anyag gyüjtése
	 * Nem determinisztikus esetben a paraméterül kapott virológus anyagkészletét deltával növeli meg, random választva a 2 fajta anyag közül
	 * Determinisztikus esetben a paraméterül kapott virológus anyagkészletét deltával növeli meg, a kiválasztott anyag közül
	 * @param v gyüjtő virológus
	 */
	public void CollectMaterial(Virologist v) {
		if (random.nextInt(2) == 0) {
			v.AddAminoAcid(delta);
		}
		else {
			v.AddNucleotide(delta);
		}
	}

	/**
	 * A mezőn az anyagok tönkretételét szimbolizálja, nem vehető fel anyag ezután a mezőről
	 */
	@Override
	public void DestroyMaterial() {
		delta = 0;
	}
}
