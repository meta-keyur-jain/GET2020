package Animal.Bird.Omnivorous;

import Animal.Bird.Bird;

/**
 * 
 * This class represent Omnivorous Birds
 */
public abstract class OmnivorousBird extends Bird 
{
    public String foodConsume;
    public String typeOfTeeth;
	/**
	 * 
	 * default constructor set the sub category of the animal to "Omnivorous"
	 */
	protected OmnivorousBird()
	{
		super.subCategory = "Omnivorous";
	}

}