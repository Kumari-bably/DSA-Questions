import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] arr, int target, int index,
                           List<Integer> list, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (target < 0) return;

        for (int i = index; i < arr.length; i++) {

            list.add(arr[i]);                        
            backtrack(arr, target - arr[i], i, list, result); // reuse same element
            list.remove(list.size() - 1);             // backtrack
        }
    }
}