package Animal.Aqua.Omnivorous;

import Animal.Aqua.Aqua;

/**
 * 
 * This class represent animal which are Omnivorous and lives in water
 */
public abstract class OmnivorousAqua extends Aqua 
{
    public String foodConsume;
    public String typeOfTeeth;
	/**
	 * 
	 * This default constructor set the sub category of the animal to "Omnivorous"
	 */
	protected OmnivorousAqua()
	{
		super.subCategory = "Omnivorous";
	}

}