import java.util.Arrays;

public class NumberOfPaths {


  long numberOfPaths(int m, int n) {
    boolean visited[][] = new boolean[m+1][n+1];
    long[][] dp = new long[m+1][n+1];
    for(int i=0; i<=m; i++){
      Arrays.fill(dp[i],-1);
    }
    return dfs(0, 0, m, n, visited, dp);

  }

  long dfs(int i, int j, int m, int n, boolean[][] visited, long[][] dp){
    if(i== m-1 && j == n-1) return 1;
    if(dp[i][j] != -1) return dp[i][j];
    long res = 0;
    if(isValid(i+1, j, m, n) && !visited[i+1][j]){
      visited[i+1][j] = true;
      res += dfs(i+1, j, m, n, visited, dp);
      visited[i+1][j] = false;
    }
    if(isValid(i, j+1, m, n) && !visited[i][j+1]){
      visited[i][j+1] = true;
      res += dfs(i, j+1, m, n, visited, dp);
      visited[i][j+1] = false;
    }
    dp[i][j] = res;
    return res;
  }

  boolean isValid(int i, int j, int m, int n){
    if(i >= m || j >= n || i <0 || j <0) return false;
    return true;
  }
}
