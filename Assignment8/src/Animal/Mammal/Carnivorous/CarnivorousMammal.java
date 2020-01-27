package Animal.Mammal.Carnivorous;

import Animal.Mammal.Mammal;

/**
 * 
 * This class represent Carnivorous Mammals
 */
abstract class CarnivorousMammal extends Mammal 
{
    public String foodConsume;
    public String typeOfTeeth;
	/**
	 * 
	 * default constructor set the sub category of the animal to "Carnivorous"
	 */
	protected CarnivorousMammal()
	{
		super.subCategory = "Carnivorous";
	}
}