import java.util.*;

class Solution {
    
    public int median(int matrix[][]) {
        
        int n = matrix.length;
        int m = matrix[0].length;
        
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][m - 1]);
        }
        
        int desired = (n * m) / 2;
        
        while (low <= high) {
            
            int mid = low + (high - low) / 2;
            int count = 0;
            
            for (int i = 0; i < n; i++) {
                count += countSmallerEqual(matrix[i], mid);
            }
            
            if (count <= desired)
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        return low;
    }

    private int countSmallerEqual(int[] row, int target) {
        
        int l = 0, r = row.length - 1;
        
        while (l <= r) {
            int mid = (l + r) / 2;
            
            if (row[mid] <= target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        
        return l;
    }
}