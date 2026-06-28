class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
   Arrays.sort(nums);
Set<List<Integer>> result = new HashSet<>(); // duplicates automatically handle!

for(int i = 0; i < nums.length-1; i++){
    int L = i+1, R = nums.length-1;
    while(L < R){
        int sum = nums[i] + nums[L] + nums[R];
        if(sum == 0){
            result.add(Arrays.asList(nums[i], nums[L], nums[R]));
            L++; R--;
        }
        else if(sum < 0) L++;
        else R--;
    }
}
return new ArrayList<>(result);
}
}