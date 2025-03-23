//Approach:
//Check if the length of pattern is equal to the number of words in string.
//Map each character to each word in string s. Check if that character exists in HashMap.
//If it exists in the HashMap then check if that string is equal to the current string, if not then return false
//If it does not exist, then check if the word exists in HashSet if not then add string to HashMap & hashSet
//Else if the String exists in Set, if yes then that means the string is already mapped to some character thus return false
//TC: o(N)
//SC: O(1)


import java.util.HashMap;
import java.util.HashSet;

class WordPattern {
    public boolean wordPattern(String pattern, String s) {

        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        String[] strings = s.split(" ");

        if(pattern.length()!= strings.length) return false;

        for(int i= 0; i< pattern.length(); i++){
            char chr = pattern.charAt(i);
            String word = strings[i];

            if (map.containsKey(chr)) {
                if(!map.get(chr).equals(word)){
                    return false;
                }
            }

            else{
                if(set.contains(word)) return false;

                map.put(chr, word);
                set.add(word);
            }
                
            }
            return true;
        }
        
    }
