package virologist.model.map;



import virologist.model.Virologist;
import virologist.model.codes.GeneticCode;

/**
 * Olyan mező, amelyen genetikai kód tanulható
 */
public class Laboratory extends Field
{
	private final GeneticCode code;

	/**
	 * Genetikai kód hozzáadása a mezőhöz
	 * @param c hozzáadandó genetikai kód
	 */
	public Laboratory(GeneticCode c) {
		code = c;
	}

	/**
	 * Genetikai kód tanuása a mezőn
	 * @param v tanuló virológus
	 */
	public void LearnGeneticCode(Virologist v) {
		v.AddGeneticCode(code);
	}
}
