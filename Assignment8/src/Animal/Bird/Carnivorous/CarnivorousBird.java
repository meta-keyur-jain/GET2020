package Animal.Bird.Carnivorous;

import Animal.Bird.Bird;

/**
 * 
 * This class represent Carnivorous Birds
 */
public abstract class CarnivorousBird extends Bird 
{
    public String foodConsume;
    public String typeOfTeeth;
	/**
	 * 
	 * default constructor set the sub category of the animal to "Carnivorous"
	 */
	protected CarnivorousBird()
	{
		super.subCategory = "Carnivorous";
	}

}