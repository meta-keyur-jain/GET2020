package Animal.Aqua.Herbivore;

import Animal.Aqua.Aqua;

/**
 *
 * This class represent animal which are Herbivore and lives in water
 */
public abstract class HerbivoreAqua extends Aqua 
{
    public String foodConsume;
    public String typeOfTeeth;
	/**
	 * 
	 * This default constructor set the sub category of the animal to "Herbivorous"
	 */
	protected HerbivoreAqua()
	{
		super.subCategory = "Herbivorous";
	}

}