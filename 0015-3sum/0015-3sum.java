class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
Arrays.sort(nums);

for(int i = 0; i < nums.length-1; i++){
    if(i > 0 && nums[i] == nums[i-1]) continue;
    
    int L = i+1;
    int R = nums.length-1;
    
    while(L < R){
        int sum = nums[i] + nums[L] + nums[R];
        
        if(sum == 0){
            result.add(Arrays.asList(nums[i], nums[L], nums[R]));
            while(L < R && nums[L] == nums[L+1]) L++;
            while(L < R && nums[R] == nums[R-1]) R--;
            L++;
            R--;
        }
        else if(sum < 0) L++;
        else R--;
    }
}
return result;
}
}