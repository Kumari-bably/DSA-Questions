import java.util.*;

class Solution {
    public boolean has132Pattern(int[] arr) {
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int third = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] < third) {
                return true;
            }
            while (!stack.isEmpty() && arr[i] > stack.peek()) {
                third = stack.pop();
            }
            stack.push(arr[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();
        int[] arr1 = {4, 7, 11, 5, 13, 2};
        System.out.println(obj.has132Pattern(arr1));

        int[] arr2 = {11, 11, 12, 9};
        System.out.println(obj.has132Pattern(arr2));
    }
}