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

    // For testing
    public static void main(String[] args) {
        int[] arr1 = {2, 3, -8, 7, -1, 2, 3};
        System.out.println(maxSubarraySum(arr1)); // 11

        int[] arr2 = {-2, -4};
        System.out.println(maxSubarraySum(arr2)); // -2

        int[] arr3 = {5, 4, 1, 7, 8};
        System.out.println(maxSubarraySum(arr3)); // 25
    }
}
