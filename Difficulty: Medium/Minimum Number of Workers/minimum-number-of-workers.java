import java.util.*;

class Solution {

    public int minMen(int[] arr) {

        int n = arr.length;
        List<int[]> intervals = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) {
                int L = Math.max(0, i - arr[i]);
                int R = Math.min(n - 1, i + arr[i]);
                intervals.add(new int[]{L, R});
            }
        }

        intervals.sort((a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });

        int count = 0;
        int i = 0;
        int coveredEnd = 0;

        while (coveredEnd < n) {

            int farthest = coveredEnd;

            while (i < intervals.size() && intervals.get(i)[0] <= coveredEnd) {
                farthest = Math.max(farthest, intervals.get(i)[1] + 1);
                i++;
            }

            if (farthest == coveredEnd)
                return -1;

            count++;
            coveredEnd = farthest;
        }

        return count;
    }
}