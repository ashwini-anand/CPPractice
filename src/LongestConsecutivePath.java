import java.util.Arrays;

public class LongestConsecutivePath {

  static int[][] dp;
  static int n;
  static int m;
  static int[] rowIdx = {0,1,1,-1,1,0,-1,-1};
  static int[] colIdx = {1,0,1,1,-1,-1,0,-1};
  public static void main(String args[])
  {
    char mat[][] = { {'a','c','d'},
        { 'h','b','a'},
        { 'i','g','f'}};

    System.out.println(getLen(mat, 'a') );
    System.out.println(getLen(mat, 'e') );
    System.out.println(getLen(mat, 'b') );
    System.out.println(getLen(mat, 'f') );
  }

  private static int getLen(char[][] mat, char c) {
    n = mat.length;
    m = mat[0].length;
    dp = new int[n][m];
    for(int i=0; i<n; i++){
      Arrays.fill(dp[i], -1);
    }

    int res =0;
    for(int i=0; i<n; i++){
      for(int j=0; j<m; j++){
        if(mat[i][j] == c){
          for(int k=0; k<8; k++){
            res = Math.max(res, getLenUtil(mat, i+rowIdx[k], j+colIdx[k], c));
          }
          res = res+1;
        }
      }
    }
    return res;
  }

  static int getLenUtil(char[][] mat, int i, int j, char prev){
    if(!proceed(i,j,prev, mat)) return 0;
    if(dp[i][j] != -1) return dp[i][j];
    int res = -1;
    for(int k=0; k<8; k++){
      res = Math.max(res, getLenUtil(mat, i+rowIdx[k], j+colIdx[k], mat[i][j]));
    }
    dp[i][j] = 1+res;
    return dp[i][j];
  }

  static boolean proceed(int i, int j, char prev, char[][] mat){
    if(i <0 || i>=n || j <0 || j>= m) return false;
    if((mat[i][j] - prev) ==1) return true;
    else return false;
  }
}
