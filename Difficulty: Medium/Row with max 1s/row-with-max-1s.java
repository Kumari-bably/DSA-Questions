class Solution {

    public int rowWithMax1s(int arr[][]) {

        int n = arr.length;
        int m = arr[0].length;

        int rowIndex = -1;

        int i = 0;
        int j = m - 1;

        while (i < n && j >= 0) {

            if (arr[i][j] == 1) {
                rowIndex = i;  
                j--;            
            } else {
                i++;           
            }
        }

        return rowIndex;
    }
}