
public class Hcf_lcm {

    /**
     * This is the method to find the hcf of two number using euclid algorithim.    
     * @param num1 is the integer value.
     * @param num2 is the integer value.
     * @return the hcf of two number.
     */
    public int hcf(int num1,int num2){
        if(num2!=0) {

            return hcf(num2,num1%num2);
        }
        return num1;
    }    

    /** 
     * This is the method to find the lcm of two number.    
     * @param num1 is the integer value.
     * @param num2 is the integer value.
     * @return result is the integer value which contain Lcm of two number.
     */
    public int lcm(int num1,int num2) {
        int result;
        int hcf1 = hcf(num1,num2);

        if(hcf1==0) {

            throw new AssertionError("divide by zero error");
        } 
        else 
        {
            result = (num1*num2)/hcf1;
        }
        return result;    
    }
}
