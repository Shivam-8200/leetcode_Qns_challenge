class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Step 1 - HashMap + Stack
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < nums2.length; i++){
            while(!stack.isEmpty() && nums2[i] > stack.peek()){
                map.put(stack.pop(), nums2[i]);  // next greater mila!
            }
            stack.push(nums2[i]);
        }
        
        // stack mein jo bacha → -1!
        while(!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }
        
        // Step 2 - nums1 ka answer nikalo
        int[] result = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            result[i] = map.get(nums1[i]);
        }
        
        return result;
    }
}