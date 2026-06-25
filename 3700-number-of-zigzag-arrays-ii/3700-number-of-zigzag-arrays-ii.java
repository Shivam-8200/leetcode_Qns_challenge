import java.util.Arrays;

class Solution {
    static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int k = r - l + 1;

        int sz = 2 * k;
        long[][] M = new long[sz][sz];

        for (int u = 0; u < k; u++) {
            for (int v = 0; v < u; v++) {
                M[v + k][u] = 1;
            }
        }

        for (int u = 0; u < k; u++) {
            for (int v = u + 1; v < k; v++) {
                M[v][u + k] = 1;
            }
        }

        long[] state = new long[sz];
        for (int v = 0; v < k; v++) {
            state[v] = v;
            state[v + k] = k - 1 - v;
        }

        long[][] Mpow = matPow(M, n - 2, sz);
        long[] result = matVecMul(Mpow, state, sz);

        long ans = 0;
        for (long x : result)
            ans = (ans + x) % MOD;
        return (int) ans;
    }

    long[][] matMul(long[][] A, long[][] B, int sz) {
        long[][] C = new long[sz][sz];
        for (int i = 0; i < sz; i++)
            for (int t = 0; t < sz; t++) {
                if (A[i][t] == 0)
                    continue;
                for (int j = 0; j < sz; j++)
                    C[i][j] = (C[i][j] + A[i][t] * B[t][j]) % MOD;
            }
        return C;
    }

    long[][] matPow(long[][] M, long p, int sz) {

        long[][] result = new long[sz][sz];
        for (int i = 0; i < sz; i++)
            result[i][i] = 1;

        while (p > 0) {
            if ((p & 1) == 1)
                result = matMul(result, M, sz);
            M = matMul(M, M, sz);
            p >>= 1;
        }
        return result;
    }

    long[] matVecMul(long[][] M, long[] v, int sz) {
        long[] res = new long[sz];
        for (int i = 0; i < sz; i++)
            for (int j = 0; j < sz; j++)
                res[i] = (res[i] + M[i][j] * v[j]) % MOD;
        return res;
    }
}