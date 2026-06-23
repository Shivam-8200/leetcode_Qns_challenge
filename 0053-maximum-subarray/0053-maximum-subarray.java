class Solution {
    public int maxSubArray(int[] nums) {
       int currentsum =nums[0];
       int MaxSum=nums[0];
       int i =1;
       while(i<nums.length){
        currentsum = Math.max(nums[i],currentsum+nums[i]);
        MaxSum = Math.max(MaxSum,currentsum);
        i++;
       } 
        return MaxSum;
    } 
}