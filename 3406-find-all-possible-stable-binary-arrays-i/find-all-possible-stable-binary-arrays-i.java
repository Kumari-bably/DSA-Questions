class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfStableArrays(int zero, int one, int limit) {

        long[][] dp0 = new long[zero + 1][one + 1];
        long[][] dp1 = new long[zero + 1][one + 1];

        for (int i = 1; i <= Math.min(zero, limit); i++) {
            dp0[i][0] = 1;
        }

        for (int j = 1; j <= Math.min(one, limit); j++) {
            dp1[0][j] = 1;
        }

        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {

                if (i > 0) {
                    for (int k = 1; k <= Math.min(limit, i); k++) {
                        dp0[i][j] = (dp0[i][j] + dp1[i - k][j]) % MOD;
                    }
                }

                if (j > 0) {
                    for (int k = 1; k <= Math.min(limit, j); k++) {
                        dp1[i][j] = (dp1[i][j] + dp0[i][j - k]) % MOD;
                    }
                }
            }
        }

        return (int)((dp0[zero][one] + dp1[zero][one]) % MOD);
    }
}