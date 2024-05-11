package virologist.model.codes;


import virologist.model.Virologist;
import virologist.model.agents.Agent;
import virologist.model.agents.Block;

import static virologist.model.Game.playerCount;


/**
 * Blokkoló hatású ágenshez tartozó genetikai kód
 */
public class BlockCode extends GeneticCode
{
	/**
	 * Konstruktor, mely beállítja a kreálható ágens költségeit és
	 * hatásánakl időtartamát
	 */
	public BlockCode() {
		aminoAcidPrice = 4;
		nucleotidePrice = 3;
		turnsLeft = 2;
	}

	public BlockCode(int aminoAcidPrice, int nucleotidePrice, int turnsLeft) {
		this.aminoAcidPrice = aminoAcidPrice;
		this.nucleotidePrice = nucleotidePrice;
		this.turnsLeft = turnsLeft;
	}

	/**
	 * Létrehoz egy Block Agent-t (ágens), és visszatér vele.
	 * Ha nem hozható létre az Agent, mert nincs hozzá elég anyag a paraméterül kapott virológusnak,
	 * akkor kivételt dob.
	 * @param v a virológus, aki szeretne ágenst készíteni
	 * @return az elkészített ágens
	 * @throws Exception ha a virológusnak nem volt elég anyaga az ágenskészítéshez
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
		return new Block(turnsLeft*playerCount);
	}

}
