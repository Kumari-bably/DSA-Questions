import java.util.*;

class Solution {
    public int countSubarrays(int[] arr) {
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ans += (n - i);
            } else {
                ans += (stack.peek() - i);
            }

            stack.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] arr1 = {1, 2, 1};
        int res1 = obj.countSubarrays(arr1);
        System.out.println(res1);

        int[] arr2 = {1, 3, 5, 2};
        int res2 = obj.countSubarrays(arr2);
        System.out.println(res2);
    }
}