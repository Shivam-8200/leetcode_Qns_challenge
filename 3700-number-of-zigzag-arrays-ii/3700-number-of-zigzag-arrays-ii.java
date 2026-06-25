import java.util.Arrays;

class Solution {
    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int k = r - l + 1;

        // dp[v][0] = ways ending at v, next must go DOWN (came UP)
        // dp[v][1] = ways ending at v, next must go UP  (came DOWN)
        // State vector size = 2k

        // Build transition matrix for ONE step
        // Step type alternates: odd steps = "pick something lower" etc.
        // Easier: build matrix for 2 steps combined (up then down)

        // Actually let's do it cleanly:
        // State = dp[0..k-1][0] followed by dp[0..k-1][1]  → size 2k vector
        // Build single-step matrix, then do matrix^(n-1)

        int sz = 2 * k;
        // M[i][j] = contribution of state j to state i after one step
        long[][] M = new long[sz][sz];

        // From dp[u][0] (came UP, so u is a peak, next must go DOWN)
        //   → contributes to dp[v][1] where v < u  (going DOWN from u)
        for (int u = 0; u < k; u++) {
            for (int v = 0; v < u; v++) {
                // state u+0 contributes to state v+k (dp[v][1])
                M[v + k][u] = 1;
            }
        }

        // From dp[u][1] (came DOWN, so u is a valley, next must go UP)
        //   → contributes to dp[v][0] where v > u  (going UP from u)
        for (int u = 0; u < k; u++) {
            for (int v = u + 1; v < k; v++) {
                // state u+k contributes to state v+0 (dp[v][0])
                M[v][u + k] = 1;
            }
        }

        // Initial state after placing first element:
        // dp[v][0] = v        (v values below, came UP)
        // dp[v][1] = k-1-v    (values above, came DOWN)
        long[] state = new long[sz];
        for (int v = 0; v < k; v++) {
            state[v]     = v;       // dp[v][0]
            state[v + k] = k - 1 - v; // dp[v][1]
        }

        // Apply M^(n-2) to state  (we already have length-2 info in state)
        long[][] Mpow = matPow(M, n - 2, sz);
        long[] result = matVecMul(Mpow, state, sz);

        long ans = 0;
        for (long x : result) ans = (ans + x) % MOD;
        return (int) ans;
    }

    // Matrix × Matrix
    long[][] matMul(long[][] A, long[][] B, int sz) {
        long[][] C = new long[sz][sz];
        for (int i = 0; i < sz; i++)
            for (int t = 0; t < sz; t++) {
                if (A[i][t] == 0) continue; // pruning
                for (int j = 0; j < sz; j++)
                    C[i][j] = (C[i][j] + A[i][t] * B[t][j]) % MOD;
            }
        return C;
    }

    // Matrix ^ p
    long[][] matPow(long[][] M, long p, int sz) {
        // Identity matrix
        long[][] result = new long[sz][sz];
        for (int i = 0; i < sz; i++) result[i][i] = 1;

        while (p > 0) {
            if ((p & 1) == 1) result = matMul(result, M, sz);
            M = matMul(M, M, sz);
            p >>= 1;
        }
        return result;
    }

    // Matrix × Vector
    long[] matVecMul(long[][] M, long[] v, int sz) {
        long[] res = new long[sz];
        for (int i = 0; i < sz; i++)
            for (int j = 0; j < sz; j++)
                res[i] = (res[i] + M[i][j] * v[j]) % MOD;
        return res;
    }
}