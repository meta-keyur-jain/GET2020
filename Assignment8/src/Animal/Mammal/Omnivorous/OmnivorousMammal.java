package Animal.Mammal.Omnivorous;

import Animal.Mammal.Mammal;

/**
 * 
 * This class represent Omnivorous Mammals
 */
public abstract class OmnivorousMammal extends Mammal 
{
    public String foodConsume;
    public String typeOfTeeth;
	/**
	 * 
	 * default constructor set the sub category of the animal to "Omnivorous"
	 */
	protected OmnivorousMammal()
	{
		super.subCategory = "Omnivorous";
	}
}