package virologist.model.codes;


import virologist.model.Virologist;

import virologist.model.agents.Agent;
import virologist.model.agents.Chorea;

import static virologist.model.Game.playerCount;

/**
 * Olyan genetikai kód, ami egy vitustánc (Chorea) típusú ágenst tud előállítani.
 */
public class ChoreaCode extends GeneticCode {
	/**
	 * Konstruktor, ami beállítja a kódhoz a megfelelő költségeket és
	 * a jövendőbeli ágens élettartamát a vitustánc ágens legyártásához.
	 */
	public ChoreaCode() {
		aminoAcidPrice = 5;
		nucleotidePrice = 6;
		turnsLeft = 1;
	}

	public ChoreaCode(int aminoAcidPrice, int nucleotidePrice, int turnsLeft) {
		this.aminoAcidPrice = aminoAcidPrice;
		this.nucleotidePrice = nucleotidePrice;
		this.turnsLeft = turnsLeft;
	}

	/**
	 * Létrehoz egy vitustánc (Chorea) ágenst.
	 * @param v a virológus, aki szeretne ágenst készíteni
	 * @return a létrehozot vitustánc ágens
	 * @throws Exception ha nem hozható létre az Agent, mert nincs hozzá elég anyaga a paraméterül kapott virológusnak.
	 */
	public Agent Create(Virologist v) throws Exception {
		v.RemoveNucleotide(nucleotidePrice);

		try {
			v.RemoveAminoAcid(aminoAcidPrice);
		} catch(Exception e) {
			v.AddNucleotide(nucleotidePrice);
			throw e;
		}

		return new Chorea(turnsLeft*playerCount);
	}

}
