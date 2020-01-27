package Animal.Bird.Herbivore;

import Animal.Bird.Bird;

/**
 * 
 * This class represent Herbivorous Birds
 */
public abstract class HerbivoreBird extends Bird 
{   
    public String foodConsume;
    public String typeOfTeeth;
	/**
	 * 
	 * default constructor set the sub category of the animal to "Herbivorous"
	 */
	protected HerbivoreBird()
	{
		super.subCategory = "Herbivorous";
	}
 
}