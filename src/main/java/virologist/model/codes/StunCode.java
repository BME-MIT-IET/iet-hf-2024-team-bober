package virologist.model.codes;


import virologist.model.Virologist;
import virologist.model.agents.Agent;
import virologist.model.agents.Stun;

import static virologist.model.Game.playerCount;

/**
 * Olyan genetikai kód, ami egy bénító (Stun) típusú ágenst tud előállítani.
 */
public class StunCode extends GeneticCode {
	/**
	 * Konstruktor, ami beállítja a kódhoz a megfelelő költségeket és
	 * a jövendőbeli ágens élettartamát a bénító ágens legyártásához.
	 */
	public StunCode() {
			aminoAcidPrice = 7;
			nucleotidePrice = 2;
			turnsLeft = 1;
	}

	public StunCode(int aminoAcidPrice, int nucleotidePrice, int turnsLeft) {
		this.aminoAcidPrice = aminoAcidPrice;
		this.nucleotidePrice = nucleotidePrice;
		this.turnsLeft = turnsLeft;
	}

	/**
	 * Létrehoz egy bénító (Stun) ágenst.
	 * @param v a virológus, aki szeretne ágenst készíteni
	 * @return a létrehozott bénító ágens
	 * @throws Exception ha nem hozható létre az ágens, mert nincs hozzá elég anyag a paraméterül kapott virológusnak.
	 */
	public Agent Create(Virologist v) throws Exception {

		v.RemoveNucleotide(nucleotidePrice);

		try {
			v.RemoveAminoAcid(aminoAcidPrice);
		} catch(Exception e){
			v.AddNucleotide(nucleotidePrice);
			throw e;
		}
		
		return new Stun(turnsLeft*playerCount);
	}

}
