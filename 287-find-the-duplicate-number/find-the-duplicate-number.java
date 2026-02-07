class Solution {
    public int findDuplicate(int[] nums) {
        // Floyd's Tortoise and Hare
        int slow = nums[0];
        int fast = nums[0];

        // Phase 1: find intersection
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: find entrance to cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}