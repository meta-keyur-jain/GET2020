package Animal;

abstract public class Animal 
{	
   
    public String category;
    
    public String subCategory;
    
    public String species;
    
    public String uniqueName;
    
    public double age;
    
    public double weight;
    
    /**
     * 
     * This method return the sound of the animal as a String eg for Lion "Roars"
     * @return String Object
     */
    abstract public  String getSound();
}