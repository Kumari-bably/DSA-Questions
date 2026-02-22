import java.util.*;

class Solution {
    public int maxPeople(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            left[i] = 1;
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                left[i] += left[stack.pop()];
            }
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            right[i] = 1;
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                right[i] += right[stack.pop()];
            }
            stack.push(i);
        }

        int maxPeople = 0;
        for (int i = 0; i < n; i++) {
            int total = left[i] + right[i] - 1;
            maxPeople = Math.max(maxPeople, total);
        }

        return maxPeople;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] arr1 = {6, 2, 5, 4, 5, 1, 6};
        System.out.println(obj.maxPeople(arr1));
        int[] arr2 = {1, 3, 6, 4};
        System.out.println(obj.maxPeople(arr2));
    }
}