import java.util.Arrays;

public class GS1 {
  public static void main(String[] args) {
    int[] arr = {2, 4, 6};
    int total=6;
    int[][] dp = new int[arr.length][total+1];
    for(int i=0; i<arr.length; i++){
      Arrays.fill(dp[i], -1);
    }
    System.out.println(countWays(total,0,arr,dp));
  }

  static int countWays(int remaining, int index, int[] arr, int[][] dp) {
    if (remaining == 0) return 1;
    if (index >= arr.length || remaining < 0) return 0;
    if (dp[index][remaining] != -1) return dp[index][remaining];
    int res =0;
    for(int i=0; i<arr.length; i++){
      res += countWays(remaining - arr[i], i, arr, dp);
    }
    dp[index][remaining] = res;
    return dp[index][remaining];
  }
}
