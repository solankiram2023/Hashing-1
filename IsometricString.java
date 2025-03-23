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