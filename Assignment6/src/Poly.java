
import java.util.Arrays;


public final class Poly
{
    private final int power[];
    private final int cofficient[];

    public Poly(int[] power, int[] cofficient) {
        this.power = power;
        this.cofficient = cofficient;
    }

/**
 * This method is used to return the value of the polynomial for the given value of the variable.
 * @param var_value is float variable.
 * @return return the value of the polynomial.
 */
    public float evalauate(float var_value) {
        
        float evaluateResult = 0;
        
        for(int index = 0; index < cofficient.length ; index++) {
            evaluateResult = evaluateResult + (float) (cofficient[index] * (Math.pow(var_value, power[index])));
        }
        
        return evaluateResult;
    }

    /**
     * This method calculate the degree of the polynomial.
     * @return return the degree of the polynomial.
     */

    public int degree() {
        int max_degree = 0;
        Arrays.sort(power);
        max_degree =  power[power.length-1];
        return max_degree;
    }


    /**
     * This method return the sum of the polynomials p1 and p2.
     * @param p1 is the poly object contain two array of degree and cofficient.
     * @param p2 is the poly object contain two array of degree and cofficient.
     * @return return the sum of the polynomials p1 and p2 in object.
     */

    public static Poly poly_add(Poly p1 , Poly p2) {
        int count = 0;
        for( int  index = 0 ; index < p1.power.length ; index++) {
            
            for( int  index1 = 0 ; index1 < p2.power.length ; index1++) {
                
                if(p1.power[index] == p2.power[index1]) {
                    
                    count++;
                    break;
                }
            }
        } 
        
        int size  = p1.power.length + p2.power.length -count;
        int [] power_array = new int[size];
        int [] coff_array = new int[size];
        
        for(int index = 0; index < p1.power.length-1 ; index++ ) {
            
            for(int index1 = index+1; index1 < p1.power.length ; index1++ ) {
                
                if(p1.power[index] > p1.power[index1]) {
                    int temp;
                    temp = p1.power[index];
                    p1.power[index] = p1.power[index1];
                    p1.power[index1]= temp;
                    int temp1;
                    temp1 = p1.cofficient[index];
                    p1.cofficient[index] = p1.cofficient[index1];
                    p1.cofficient[index1] = temp1;
                }
            }
        }
        for(int index = 0; index < p2.power.length-1 ; index++ ) {
            
            for(int index1 = index+1; index1 < p2.power.length ; index1++ ) {
  
                if(p2.power[index] > p2.power[index1]) {
                    int temp;
                    temp = p2.power[index];
                    p2.power[index] = p2.power[index1];
                    p2.power[index1]= temp;
                    int temp1;
                    temp1 = p2.cofficient[index];
                    p2.cofficient[index] = p2.cofficient[index1];
                    p2.cofficient[index1] = temp1;
                }
            }
        }
        int index_power = -1;
        int index_coff = -1;
        int index=0,index1=0,count_i=0,count_j=0;
        
        while(index < p1.power.length && index1 < p2.power.length) {
            
            if(p1.power[index]==p2.power[index1]) {
                
                power_array[++index_power] = p1.power[index];
                coff_array[++index_coff] = p1.cofficient[index]+p2.cofficient[index1];
                index++;
                index1++;
                count_i++;
                count_j++;

            }
            else if(p1.power[index]<p2.power[index1]) {

                power_array[++index_power] = p1.power[index];
                coff_array[++index_coff] = p1.cofficient[index];
                index++;
                count_i++;
            }
            else {

                power_array[++index_power] = p2.power[index1];
                coff_array[++index_coff] = p2.cofficient[index1];
                index1++;
                count_j++;
            }

        } 

        for(int temporary=count_i ; temporary<p1.power.length ; temporary++) {
            
            power_array[++index_power] = p1.power[temporary];
            coff_array[++index_coff] = p1.cofficient[temporary];
        }



        for(int temporary=count_j ; temporary<p2.power.length ; temporary++) {
            
            power_array[++index_power] = p2.power[temporary];
            coff_array[++index_coff] = p2.cofficient[temporary];
        }
      
        return  new Poly(power_array,coff_array);

    }

   
    /**
     * This method return the multiplication of the polynomials p1 and p2.
     * @param p1 is the Poly object contain two array of degree and cofficient.
     * @param p2 is the Poly object contain two array of degree and cofficient.
     * @return return the multiplication of the polynomials p1 and p2 in object.
     */
    public static Poly multiply(Poly p1 , Poly p2) {

        int count = 0;
        for( int  index = 0 ; index < p1.power.length ; index++) {
            
            for( int  index1 = 0 ; index1 < p2.power.length ; index1++) {
                
                if(p1.power[index] == p2.power[index1]) {
                    
                    count++;
                    break;
                }
            }
        }
        
        int size  = p1.power.length + p2.power.length-count; 
        int [] power_array = new int[size];
        int [] coff_array = new int[size];

        Poly result = new Poly(new int[]{0} , new int[]{0});
        
        for(int index=0 ; index < p1.power.length ; index++) {

            for(int index1=0; index1 < p2.power.length ; index1++) {

                power_array[index1] = p1.power[index]+p2.power[index1];


                coff_array[index1] = p1.cofficient[index]*(p2.cofficient[index1]);
                
            }



            Poly newobj = new Poly(power_array,coff_array);

            result = poly_add(result,newobj);   
        }

        
        
     return new Poly(power_array,coff_array);
    }


    public int[] getpower() {
    return power;
    }

    public int[] getcoff() {
    return cofficient;
    } 
   
}



