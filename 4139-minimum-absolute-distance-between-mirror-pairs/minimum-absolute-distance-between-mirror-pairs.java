import java.util.*;

public class Solution {

    private int reverse(int x) {
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + (x % 10);
            x /= 10;
        }
        return rev;
    }

    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {

            // Check if current number matches any reversed previous number
            if (map.containsKey(nums[i])) {
                minDist = Math.min(minDist, i - map.get(nums[i]));
            }

            // Store reversed value of current number
            map.put(reverse(nums[i]), i);
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}