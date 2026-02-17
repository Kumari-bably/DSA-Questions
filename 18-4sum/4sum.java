import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < n - 3; i++) {

            // skip duplicate i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < n - 2; j++) {

                // skip duplicate j
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = n - 1;

                long remaining = (long)target - nums[i] - nums[j];

                while (left < right) {

                    long sum = nums[left] + nums[right];

                    if (sum == remaining) {

                        result.add(Arrays.asList(
                                nums[i], nums[j], nums[left], nums[right]
                        ));

                        left++;
                        right--;

                        // skip duplicates
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    }
                    else if (sum < remaining)
                        left++;
                    else
                        right--;
                }
            }
        }
        return result;
    }
}