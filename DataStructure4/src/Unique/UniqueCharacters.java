package Unique;

import java.util.*;


public class UniqueCharacters {
    private Map<String, Integer> cache = new HashMap<String, Integer>();
    
    /**
     * This method is used to find the number of unique characters in a string
     * @param string 
     * @return 
     */
    public int getUniqueCharactersInAString(String string) { 
        int numberOfUniqueCharacters = 0;
        
        // checks if the map contains the already calculated result (like cache system)
        if(cache.containsKey(string)) {
            numberOfUniqueCharacters = cache.get(string); 
            System.out.println("Received from cache");
            return numberOfUniqueCharacters;
        }
           
        List<Character> list = new ArrayList<Character>();
        for (int index = 0; index < string.length(); index++) {
            list.add(string.charAt(index));
        }
        
        for (int index = 0; index < string.length(); index++) {
            if(Collections.frequency(list, string.charAt(index)) == 1) {
                numberOfUniqueCharacters ++;
            }
        }
        
        cache.put(string, numberOfUniqueCharacters);
        System.out.println("Received by calculation");
        return numberOfUniqueCharacters;
    }
}