package virologist.model.map;


import virologist.model.Virologist;

import java.util.Random;

/**
 * Olyan mező, amelyen anyag gyüjthető
 */
public class Warehouse extends Field
{
	/**
	 * Ennyivel növeli a virológusok anyagát
	 */
	private int delta;
	private int fixRandom;
	private boolean fixRandomUsed;

	public Warehouse() {
		delta = 5;
		fixRandom = 0;
		fixRandomUsed = false;
	}

	public Warehouse(int delta, int fixRandom) {
		this.delta = delta;
		this.fixRandom = fixRandom;
		fixRandomUsed = true;
	}

	private int getRandom() {
		if (fixRandomUsed) {
			return fixRandom;
		} else {
			Random random = new Random();
			return random.nextInt(2);
		}
	}

	/**
	 * Anyag gyüjtése
	 * Nem determinisztikus esetben a paraméterül kapott virológus anyagkészletét deltával növeli meg, random választva a 2 fajta anyag közül
	 * Determinisztikus esetben a paraméterül kapott virológus anyagkészletét deltával növeli meg, a kiválasztott anyag közül
	 * @param v gyüjtő virológus
	 */
	public void CollectMaterial(Virologist v) {
		int r = getRandom();
		if (r == 0) {
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
	public void DestroyMaterial(){
		delta = 0;
	}
}
