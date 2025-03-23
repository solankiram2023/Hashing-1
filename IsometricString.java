//Approach #1
//We are taking 2 HashMaps and maintain mapping of each character of str1-> str2. Loop over 1st string
//and map each character str1 and str2. Loop over 2nd string and map each character of str2 to str1. 
//If the character is already mapped then check if the mapped character is equal to the current character in another string.
//If yes, then we move ahead otherwise its not isomorphic string . We repeat trhis process while looping over str2.

//TC: O(2N) -> O(N)
//sc: O(2*26) -> O(1)


//Approach #2
//We are using HashMap and HastSet, We check in Str1 is mapped to current character in  str2 and is present in HashMap.
//Check if character that current character in str1 in mapped is equal to str2's current charater, if not then its not isomorphic.
//If its not present in HashMap.Check if its present in HashSet which means the character is already mapped to something that would mean its not isomorphic . Otherwise add the character to HashMap & HashSet.


import java.util.HashMap;
import java.util.HashSet;


class IsometricString {
    public boolean isIsomorphic(String s, String t) {
        // Create a HashMap to store mapping from s -> t
        HashMap<Character, Character> sMap = new HashMap<>();
        // Create a HashSet to track characters already mapped in t
        HashSet<Character> set = new HashSet<>();

        // If lengths are different, they cannot be isomorphic
        if (s.length() != t.length()) {
            return false;
        }

        // Iterate through all characters in both strings
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            // If sChar is already mapped
            if (sMap.containsKey(sChar)) {
                // Check if the mapping is consistent
                if (sMap.get(sChar) != tChar) {
                    return false;
                }
            } 
            // If sChar is not yet mapped
            else {
                // If tChar is already mapped to another character → inconsistent mapping
                if (set.contains(tChar)) {
                    return false;
                }

                // Create new mapping and mark tChar as already mapped
                sMap.put(sChar, tChar);
                set.add(tChar);
            }
        }

        // If no inconsistencies were found, the strings are isomorphic
        return true;
    }
}