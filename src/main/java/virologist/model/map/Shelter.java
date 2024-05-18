package virologist.model.map;


import virologist.model.equipments.Equipment;

/**
 * Olyan mező, amelyen egy védőfelszerelés gyüjthető
 */
public class Shelter extends Field
{
	/**
	 * Védőfelszerelés hozzáadása
	 * @param e hozzáadandó felszerelés
	 */
	public Shelter(Equipment e) {
		if (e != null) {
			equipments.add(e);
		}
	}
}
