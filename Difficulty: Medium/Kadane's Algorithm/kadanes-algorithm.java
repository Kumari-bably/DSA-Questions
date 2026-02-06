class Solution {
    public static long maxSubarraySum(int[] arr) {
        long currentSum = arr[0];
        long maxSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}

    // For testing
   