class Solution {
    public int zigZagArrays(int n, int l, int r) {
        final int MOD = 1_000_000_007;
        int k = r - l + 1; 
        long[][] dp = new long[k][2];
        
        
        for (int v = 0; v < k; v++) {
            dp[v][0] = v;         
            dp[v][1] = k - 1 - v; 
        }
        
        // Now extend from length 2 to length n
        for (int i = 2; i < n; i++) {
            long[][] ndp = new long[k][2];
            
            // Prefix sum of dp[*][0] and dp[*][1]
            long[] prefUp = new long[k + 1];   // prefUp[i] = sum of dp[0..i-1][0]
            long[] prefDown = new long[k + 1]; // prefDown[i] = sum of dp[0..i-1][1]
            
            for (int v = 0; v < k; v++) {
                prefUp[v + 1] = (prefUp[v] + dp[v][0]) % MOD;
                prefDown[v + 1] = (prefDown[v] + dp[v][1]) % MOD;
            }
            
            for (int v = 0; v < k; v++) {
                // To reach v going DOWN (dir=1):
                // previous element must have come UP to something > v
                // i.e., prev > v AND prev's last move was UP (dir=0)
                // sum of dp[v+1 .. k-1][0]
                ndp[v][1] = (prefUp[k] - prefUp[v + 1] + MOD) % MOD;
                
                // To reach v going UP (dir=0):
                // previous element must have come DOWN to something < v
                // i.e., prev < v AND prev's last move was DOWN (dir=1)
                // sum of dp[0 .. v-1][1]
                ndp[v][0] = prefDown[v] % MOD;
            }
            
            dp = ndp;
        }
        
        // Sum all dp values
        long ans = 0;
        for (int v = 0; v < k; v++) {
            ans = (ans + dp[v][0] + dp[v][1]) % MOD;
        }
        return (int) ans;
    }
}