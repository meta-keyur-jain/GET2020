package Animal.Aqua.Carnivorous;

import Animal.Aqua.Aqua;

/**
 * 
 * This class represent animal which are Carnivorous and lives in water
 */
public abstract class CarnivorousAqua extends Aqua {
    public String foodConsume;
    public String typeOfTeeth;

    /**
     * 
     * This default constructor set the sub category of the animal to
     * "Carnivorous"
     */
    protected CarnivorousAqua() {
        super.subCategory = "Carnivorous";
    }
}