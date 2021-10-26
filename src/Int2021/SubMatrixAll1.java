//https://practice.geeksforgeeks.org/problems/largest-square-formed-in-a-matrix0806/1
// Lesson: Better to loop over each cell of matrix instead of doing maxSquareUtil(r,c+1,dp, mat, n, m).... in each condition
package Int2021;

import java.util.Arrays;

public class SubMatrixAll1 {
  static int maxSquare(int n, int m, int mat[][]){
    int[][] dp = new int[n][m];
    for(int i=0; i<n; i++){
      Arrays.fill(dp[i],-1);
    }
    maxSquareUtil(0, 0, dp, mat, n, m);

    int max=0;
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        max = Math.max(max, dp[i][j]);
      }
    }
    printMatrix(dp);
    return max;
  }

  static int maxSquareUtil(int r, int c, int[][] dp, int[][] mat, int n, int m){
    if(r <0 || r >=n || c < 0 || c >= m) return 0;
    if(dp[r][c] != -1) return dp[r][c];
    if(r==n-1 || c == m-1) {
      System.out.println("test1-----");
      dp[r][c] = mat[r][c];
      maxSquareUtil(r,c+1,dp, mat, n, m);
      maxSquareUtil(r+1, c+1,dp, mat, n, m);
      maxSquareUtil(r+1,c,dp, mat, n, m);
      printMatrix(dp);
      return mat[r][c];
    }
    if(mat[r][c] == 0){
      dp[r][c] = mat[r][c];
      maxSquareUtil(r,c+1,dp, mat, n, m);
      maxSquareUtil(r+1, c+1,dp, mat, n, m);
      maxSquareUtil(r+1,c,dp, mat, n, m);
      return 0;
    }
    int res = 1+Math.min(maxSquareUtil(r,c+1,dp, mat, n, m),
        Math.min(maxSquareUtil(r+1, c+1,dp, mat, n, m),
            maxSquareUtil(r+1,c,dp, mat, n, m)));
    dp[r][c] = res;
    return res;
  }

  public static void main(String[] args) {
    String strarr1str = "0   0   1   0   1   1 0   1   1   1   0   0 0   0   1   1   1   1 1   1   0   1   1   1 1   1   1   1   1   1 1   1   0   1   1   1";
    String strarr1[] = strarr1str.split("\\s+");
    int[] arr1 = convertStringToArray(strarr1str);
    //printMatrix(convertArrToMat(6,6,arr1));
    //System.out.println(maxSquare(6,6, convertArrToMat(6,6,arr1)));
    String strarr2str = "1 0 1 1 0 1 0 0 1 1";
    int[] arr2 = convertStringToArray(strarr2str);
    printMatrix(convertArrToMat(1,10,arr2));
    System.out.println(maxSquare(1,10, convertArrToMat(1,10,arr2)));

  }

  static int[] convertStringToArray(String strarr1str){
    String strarr1[] = strarr1str.split("\\s+");
    int[] arr1 = new int[strarr1.length];
    int i=0;
    for(String str: strarr1){
      arr1[i++]=Integer.parseInt(str);
    }
    return arr1;
  }

  static int[][] convertArrToMat(int n, int m, int[] arr){
    int[][] mat = new int[n][m];
    int i=0;
    for(int r=0; r<n; r++){
      for(int c=0; c<m; c++){
        mat[r][c] = arr[i];
        i++;
      }
    }
    return mat;
  }

  static void printMatrix(int[][] mat){
    int n = mat.length;
    int m = mat[0].length;
    for(int i=0; i<n; i++){
      for(int j=0; j<m ; j++){
        System.out.print(mat[i][j]+" ");
      }
      System.out.println();
    }
  }
}
