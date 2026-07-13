class Solution {
    public int romanToInt(String s) {
        int result = 0;
        
        for(int i = 0; i < s.length(); i++){
            int curr = getValue(s.charAt(i));
            int next = (i+1 < s.length()) ? getValue(s.charAt(i+1)) : 0;
            
            if(curr < next){
                result -= curr;  // IV, IX case!
            } else {
                result += curr;  // normal case!
            }
        }
        return result;
    }
    
    // helper method
    private int getValue(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}