import java.util.*;

class Solution {

    public ArrayList<Integer> prevSmaller(int[] arr) {

        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }

            if (st.isEmpty())
                result.add(-1);
            else
                result.add(st.peek());

            st.push(arr[i]);
        }

        return result;
    }
}