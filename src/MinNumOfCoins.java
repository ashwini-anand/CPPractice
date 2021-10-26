import java.util.Arrays;

public class MinNumOfCoins {


  public int minCoins(int coins[], int num, int sum)
  {
    int[][] dp = new int[sum+1][num+1];
    for(int i=0; i<sum+1; i++){
      Arrays.fill(dp[i], -1);
    }
    int res = getRes(sum, 0, dp, coins);
    if(res > (Integer.MAX_VALUE-1000)) return -1;
    return res;
  }

  public int getRes(int sum, int index, int[][] dp, int[] coins){
    if(sum <0) return Integer.MAX_VALUE-1000;
    if(sum==0) return 0;
    if(index >= coins.length) return Integer.MAX_VALUE-1000;
    if(dp[sum][index] != -1) return dp[sum][index];
    int res1 = getRes(sum-coins[index], index, dp, coins) + 1;
    int res2 = getRes(sum, index+1, dp, coins);
    int res = Math.min(res1, res2);
    dp[sum][index] = res;
    return res;
  }
}
