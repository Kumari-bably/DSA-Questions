import java.util.*;

class Solution {

    public ArrayList<Integer> spirallyTraverse(int matrix[][]) {

        int n = matrix.length;
        int m = matrix[0].length;

        int top = 0, bottom = n - 1;
        int left = 0, right = m - 1;

        ArrayList<Integer> ans = new ArrayList<>();

        while (top <= bottom && left <= right) {

            for (int j = left; j <= right; j++)
                ans.add(matrix[top][j]);
            top++;

            for (int i = top; i <= bottom; i++)
                ans.add(matrix[i][right]);
            right--;

            if (top <= bottom) {
                for (int j = right; j >= left; j--)
                    ans.add(matrix[bottom][j]);
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--)
                    ans.add(matrix[i][left]);
                left++;
            }
        }

        return ans;
    }
}