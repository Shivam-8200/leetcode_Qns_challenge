class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p.length() > s.length()) return result;
        int[] pCount = new int[26];
        int[] windowCount = new int[26];
        
        for(char c : p.toCharArray()){
            pCount[c - 'a']++;
        }
        
        for(int i = 0; i < p.length(); i++){
            windowCount[s.charAt(i) - 'a']++;
        }
        
        for(int i = p.length(); i < s.length(); i++){
            if(Arrays.equals(pCount, windowCount))
                result.add(i - p.length());
            
            windowCount[s.charAt(i) - 'a']++;
            windowCount[s.charAt(i - p.length()) - 'a']--;
        }
        
        // last window check!
        if(Arrays.equals(pCount, windowCount))
            result.add(s.length() - p.length());
        
        return result;
    }
}