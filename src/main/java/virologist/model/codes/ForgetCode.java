package virologist.model.codes;



import virologist.model.Virologist;
import virologist.model.agents.Agent;
import virologist.model.agents.Forget;

import static virologist.model.Game.playerCount;

/**
 * Olyan genetikai kód, ami egy felejtő (Forget) típusú ágenst tud előállítani.
 */
public class ForgetCode extends GeneticCode
{
	/**
	 * Konstruktor, mely beállítja a létrehozhatóü felejtő ágens költségeit és időtartamát.
	 */
	public ForgetCode() {
		aminoAcidPrice = 6;
		nucleotidePrice = 6;
		turnsLeft = 1;
	}

	public ForgetCode(int aminoAcidPrice, int nucleotidePrice, int turnsLeft) {
		this.aminoAcidPrice = aminoAcidPrice;
		this.nucleotidePrice = nucleotidePrice;
		this.turnsLeft = turnsLeft;
	}

	/**
	 * Létrehoz egy feleljtő (Forget) ágenst. és visszatér vele.
	 * @param v a virológus, aki szeretné ágenst készíteni.
	 * @return a létrehozott ágens.
	 * @throws Exception ha nem hozható létre az Agent, mert nincs hozzá elég anyag a paraméterül kapott virológusnak.
	 */
	public Agent Create(Virologist v) throws Exception
	{

		v.RemoveNucleotide(nucleotidePrice);
		try{
			v.RemoveAminoAcid(aminoAcidPrice);
		}
		catch(Exception e){
			v.AddNucleotide(nucleotidePrice);
			throw e;
		}
		return new Forget(turnsLeft*playerCount);
	}

}
