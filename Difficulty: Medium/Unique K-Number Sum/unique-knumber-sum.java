import java.util.*;

class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void backtrack(ArrayList<ArrayList<Integer>> result, ArrayList<Integer> temp, int k, int remaining, int start) {
        if (temp.size() == k && remaining == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (temp.size() > k || remaining < 0) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            temp.add(i);
            backtrack(result, temp, k, remaining - i, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution ob = new Solution();
        
        int n1 = 9, k1 = 3;
        ArrayList<ArrayList<Integer>> ans1 = ob.combinationSum(n1, k1);
        System.out.println(ans1);

        int n2 = 3, k2 = 3;
        ArrayList<ArrayList<Integer>> ans2 = ob.combinationSum(n2, k2);
        System.out.println(ans2);
    }
}