class Solution {
    public int romanToInt(String s) {
        
        // Step 1 - HashMap banao
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        // Step 2 - right se left loop
        int result = 0;
        int prev = 0;
        
        for(int i = s.length()-1; i >= 0; i--){
            int curr = map.get(s.charAt(i));  // current value
            
            // Step 3 - compare karo
            if(curr < prev){
                result -= curr;  // subtract!
            } else {
                result += curr;  // add!
            }
            
            prev = curr;  // prev update karo!
        }
        
        return result;
    }
}