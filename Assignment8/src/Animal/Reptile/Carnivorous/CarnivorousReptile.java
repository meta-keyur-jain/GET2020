package Animal.Reptile.Carnivorous;

import Animal.Reptile.Reptile;

/**
 * 
 * This class represent Carnivorous Reptiles
 */
public abstract class CarnivorousReptile extends Reptile 
{
    public String foodConsume;
    public String typeOfTeeth;
	/**
	 * 
	 * default constructor set the sub category of the animal to "Carnivorous"
	 */
	protected CarnivorousReptile()
	{
		super.subCategory = "Carnivorous";
	}

}