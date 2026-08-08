class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i <= n; i++){
            
            // End pe 0 daalo — saare remaining bars pop ho jaayein!
            int currHeight = (i == n) ? 0 : heights[i];
            
            // Jab chhota bar aaya — pichle bade bars ka area nikalo!
            while(!stack.isEmpty() && currHeight < heights[stack.peek()]){
                
                // Height = jo bar pop hua uski height
                int height = heights[stack.pop()];
                
                // Width = stack empty → i tak, warna beech ka gap!
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                
                // Area update karo!
                maxArea = Math.max(maxArea, height * width);
            }
            
            // Index push karo!
            stack.push(i);
        }
        return maxArea;
    }
}