class Solution {
    public boolean isAnagram(String s, String t) {
        // Step 1 - length check
        if(s.length() != t.length()) return false;

        // Step 2 - s ka HashMap
        HashMap<Character, Integer> smap = new HashMap<>();
        for(char c : s.toCharArray()){  // String nahi char!
            if(smap.containsKey(c)){
                smap.put(c, smap.get(c) + 1);
            } else {
                smap.put(c, 1);
            }
        }

        // Step 3 - t ka HashMap
        HashMap<Character, Integer> tmap = new HashMap<>();
        for(char c : t.toCharArray()){
            if(tmap.containsKey(c)){
                tmap.put(c, tmap.get(c) + 1);
            } else {
                tmap.put(c, 1);
            }
        }

        // Step 4 - compare karo
        return smap.equals(tmap);
    }
}