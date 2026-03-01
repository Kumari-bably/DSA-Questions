import java.util.*;

class Solution {
    public static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        
        int left = 0;
        long currentSum = 0;  // Use long to avoid overflow
        
        for (int right = 0; right < arr.length; right++) {
            currentSum += arr[right];
            
            while (currentSum > target && left <= right) {
                currentSum -= arr[left];
                left++;
            }
            
            if (currentSum == target) {
                result.add(left + 1);  
                result.add(right + 1);  
                return result;
            }
        }
        
        result.add(-1);
        return result;
    }
}