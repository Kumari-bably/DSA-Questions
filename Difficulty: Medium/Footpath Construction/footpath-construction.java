import java.util.*;

class Solution {

    public int[] createFootpath(int n, int m, int[][] a,
                                int q, int[][] queries) {

        int[][] TL = new int[n][m];
        int[][] TR = new int[n][m];
        int[][] BL = new int[n][m];
        int[][] BR = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                TL[i][j]=a[i][j];
                if(i>0) TL[i][j]=Math.min(TL[i][j],TL[i-1][j]);
                if(j>0) TL[i][j]=Math.min(TL[i][j],TL[i][j-1]);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=m-1;j>=0;j--){
                TR[i][j]=a[i][j];
                if(i>0) TR[i][j]=Math.min(TR[i][j],TR[i-1][j]);
                if(j<m-1) TR[i][j]=Math.min(TR[i][j],TR[i][j+1]);
            }
        }

        for(int i=n-1;i>=0;i--){
            for(int j=0;j<m;j++){
                BL[i][j]=a[i][j];
                if(i<n-1) BL[i][j]=Math.min(BL[i][j],BL[i+1][j]);
                if(j>0) BL[i][j]=Math.min(BL[i][j],BL[i][j-1]);
            }
        }

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                BR[i][j]=a[i][j];
                if(i<n-1) BR[i][j]=Math.min(BR[i][j],BR[i+1][j]);
                if(j<m-1) BR[i][j]=Math.min(BR[i][j],BR[i][j+1]);
            }
        }

        int[] ans=new int[q];

        for(int k=0;k<q;k++){

            int r=queries[k][0]-1;
            int c=queries[k][1]-1;

            int sum=0;

            if(r>0 && c>0) sum+=TL[r-1][c-1];
            if(r>0 && c<m-1) sum+=TR[r-1][c+1];
            if(r<n-1 && c>0) sum+=BL[r+1][c-1];
            if(r<n-1 && c<m-1) sum+=BR[r+1][c+1];

            ans[k]=sum;
        }

        return ans;
    }
}