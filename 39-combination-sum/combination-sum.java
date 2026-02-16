import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] arr, int target, int index,
                           List<Integer> path, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (index == arr.length || target < 0)
            return;
        path.add(arr[index]);
        backtrack(arr, target - arr[index], index, path, result);
        path.remove(path.size() - 1);
        backtrack(arr, target, index + 1, path, result);
    }
}