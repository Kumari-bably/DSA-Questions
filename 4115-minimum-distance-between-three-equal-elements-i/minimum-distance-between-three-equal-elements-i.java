import java.util.*;

public class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Step 1: Store indices for each value
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        int minDist = Integer.MAX_VALUE;

        // Step 2: Check groups
        for (List<Integer> list : map.values()) {
            if (list.size() < 3) continue;

            // Step 3: Check consecutive triples
            for (int i = 0; i <= list.size() - 3; i++) {
                int a = list.get(i);
                int c = list.get(i + 2);

                int dist = 2 * (c - a);
                minDist = Math.min(minDist, dist);
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}