import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> equalPartition(int[] arr) {
        int n = arr.length;
        int totalSum = Arrays.stream(arr).sum();
        int targetSize = n / 2;
        if (n % 2 != 0) targetSize = (n - 1) / 2;

        ArrayList<Integer> subset1 = new ArrayList<>();
        boolean[] used = new boolean[n];

        if (findSubset(arr, 0, targetSize, 0, totalSum / 2, subset1, used)) {
            ArrayList<Integer> subset2 = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (!used[i]) subset2.add(arr[i]);
            }
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            result.add(subset1);
            result.add(subset2);
            return result;
        }

        return new ArrayList<>();
    }

    private boolean findSubset(int[] arr, int index, int size, int currSum, int targetSum,
                               ArrayList<Integer> subset, boolean[] used) {
        if (subset.size() == size) return currSum == targetSum;
        if (index >= arr.length) return false;

        subset.add(arr[index]);
        used[index] = true;
        if (findSubset(arr, index + 1, size, currSum + arr[index], targetSum, subset, used)) {
            return true;
        }
        subset.remove(subset.size() - 1);
        used[index] = false;

        return findSubset(arr, index + 1, size, currSum, targetSum, subset, used);
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] arr1 = {1, 2, 3, 4};
        System.out.println(obj.equalPartition(arr1));

        int[] arr2 = {5, 10, 15};
        System.out.println(obj.equalPartition(arr2));
    }
}