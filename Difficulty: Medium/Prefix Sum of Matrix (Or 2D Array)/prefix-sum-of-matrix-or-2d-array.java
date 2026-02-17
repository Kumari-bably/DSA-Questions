import java.util.*;

class Solution {

    public ArrayList<Long> submatrixSum(long[][] a, int n, int m,
                                        int[][] query, int q) {

        long[][] prefix = new long[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                prefix[i][j] = a[i][j];

                if (i > 0)
                    prefix[i][j] += prefix[i - 1][j];

                if (j > 0)
                    prefix[i][j] += prefix[i][j - 1];

                if (i > 0 && j > 0)
                    prefix[i][j] -= prefix[i - 1][j - 1];
            }
        }

        ArrayList<Long> result = new ArrayList<>();

        for (int i = 0; i < q; i++) {

            int r1 = query[i][0];
            int c1 = query[i][1];
            int r2 = query[i][2];
            int c2 = query[i][3];

            long sum = prefix[r2][c2];

            if (r1 > 0)
                sum -= prefix[r1 - 1][c2];

            if (c1 > 0)
                sum -= prefix[r2][c1 - 1];

            if (r1 > 0 && c1 > 0)
                sum += prefix[r1 - 1][c1 - 1];

            result.add(sum);
        }

        return result;
    }
}