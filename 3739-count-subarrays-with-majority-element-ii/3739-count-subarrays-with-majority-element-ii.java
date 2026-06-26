class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : -1);
        }
        
        int offset = n + 1;          
        int size = 2 * n + 3;        
        long[] bit = new long[size + 1];
        
        long ans = 0;
        
        // insert prefix[0]
        update(bit, prefix[0] + offset, size);
        
        for (int j = 1; j <= n; j++) {
            int v = prefix[j] + offset;
            ans += query(bit, v - 1);   
            update(bit, v, size);
        }
        
        return ans;
    }
    
    private void update(long[] bit, int i, int n) {
        for (; i <= n; i += i & (-i)) {
            bit[i]++;
        }
    }
    
    private long query(long[] bit, int i) {
        long s = 0;
        for (; i > 0; i -= i & (-i)) {
            s += bit[i];
        }
        return s;
    }
}