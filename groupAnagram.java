//Approach: For the given array of strings we need to sort the current string and check if it exists in the HashMap
//If yes then we can store inside the list
//If no then we can add that to HashMap.
//TC: O(N*K*logK)
//SC: O(N*K)



import java.util.*;

class GroupAnagrams{
    public List<List<String>> groupAnagrams(String[] strs){
        Map<String, List<String>> groups = new HashMap<>();

        for (String s: strs) {
            int[] count = new int[26];
            for (char c: s.toCharArray()){
                count[c-'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for(int i=0; i<26;i++){
                sb.append(count[i]);
                sb.append('#');
            }

            String key = sb.toString();

            groups.putIfAbsent(key, new ArrayList<>());
            groups.get(key).add(s);
            
            
        }
        return new ArrayList<>(groups.values());
    }

}