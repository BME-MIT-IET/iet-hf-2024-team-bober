package virologist.model.strategy;


import virologist.model.Virologist;
import virologist.model.equipments.Equipment;

/**
 *  Virológusra irányuló kifosztásért felelős stratégia, egedélyezi a kifosztást
 */
public class Looted implements ILootedStr
{
	private int delta;

	/**
	 * Sikeres kifosztásért felelős stratégia létrehozása
	 */
	public Looted() {
		delta = 1;
	}

	public Looted(int delta) {
		this.delta = delta;
	}

	/**
	 * Felszerelésre irányuló kifosztás
	 * @param v kifosztó virológus
	 * @param from kifosztandó virológus
	 * @param e kifosztandó felszerelés
	 */
	@Override
	public void LootedForEquipment(Virologist v, Virologist from, Equipment e)
	{
		e.Disable(from);
		from.RemoveEquipment(e);
		v.AddEquipment(e);
	}

	/**
	 * Aminosavra irányuló kifosztás
	 * @param v kifosztó virológus
	 * @param from kifosztandó virológus
	 */
	@Override
	public void LootedForAminoAcid(Virologist v, Virologist from)
	{
		try {
			from.RemoveAminoAcid(delta);
			v.AddAminoAcid(delta);
		} catch (Exception e) {
			//Nem volt mit elvenni
		}
	}

	/**
	 * Nukleotidra irányuló kifosztás
	 * @param v kifosztó virológus
	 * @param from kifosztandó virológus
	 */
	@Override
	public void LootedForNukleotide(Virologist v, Virologist from)
	{
		try{
			from.RemoveNucleotide(delta);
			v.AddNucleotide(delta);
		}catch (Exception e){
			//Nem volt mit elvenni
		}
	}
}
