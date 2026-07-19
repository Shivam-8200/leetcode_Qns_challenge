class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        // nums2 pe loop
        for(int num : nums2){
            while(!stack.isEmpty() && num > stack.peek()){
                map.put(stack.pop(), num);  // next greater mila!
            }
            stack.push(num);
        }
        
        // jo bacha stack mein → -1
        while(!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }
        
        // nums1 ka answer
        int[] result = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            result[i] = map.get(nums1[i]);
        }
        
        return result;
    }
}