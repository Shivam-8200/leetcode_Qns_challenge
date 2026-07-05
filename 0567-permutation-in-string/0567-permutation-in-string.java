class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        // s1 ka count
        for(char c : s1.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        int count = map.size();  // kitne unique chars match karne hain
        int left = 0;
        
        for(int right = 0; right < s2.length(); right++){
            char rc = s2.charAt(right);
            
            // naya character
            if(map.containsKey(rc)){
                map.put(rc, map.get(rc) - 1);
                if(map.get(rc) == 0) count--;  // ek character match hua!
            }
            
            // window size s1.length() se badi hui
            if(right - left + 1 > s1.length()){
                char lc = s2.charAt(left);
                if(map.containsKey(lc)){
                    map.put(lc, map.get(lc) + 1);
                    if(map.get(lc) == 1) count++;  // match tuta!
                }
                left++;
            }
            
            if(count == 0) return true;  // sab match!
        }
        return false;
    }
}