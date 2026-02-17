class Solution {

    public int[] searchRange(int[] nums, int target) {
        int first = firstPosition(nums, target);
        
        if(first == -1)
            return new int[]{-1, -1};

        int last = lastPosition(nums, target);

        return new int[]{first, last};
    }

    private int firstPosition(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) {
                ans = mid;
                high = mid - 1;   // move left
            }
            else if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return ans;
    }

    private int lastPosition(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        int ans = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(nums[mid] == target) {
                ans = mid;
                low = mid + 1;   // move right
            }
            else if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return ans;
    }
}