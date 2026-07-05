class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        
        int[] s1Count = new int[26];
        int[] windowCount = new int[26];
        
        // s1 ka count banao
        for(char c : s1.toCharArray()){
            s1Count[c - 'a']++;
        }
        
        // pehli window banao
        for(int i = 0; i < s1.length(); i++){
            windowCount[s2.charAt(i) - 'a']++;
        }
        
        // window slide karo
        for(int i = s1.length(); i < s2.length(); i++){
            if(Arrays.equals(s1Count, windowCount)) return true;
            
            // naya character add karo
            windowCount[s2.charAt(i) - 'a']++;
            // purana character hatao
            windowCount[s2.charAt(i - s1.length()) - 'a']--;
        }
        
        return Arrays.equals(s1Count, windowCount);
    }
}