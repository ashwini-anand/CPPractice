import java.util.*;

public class Test {
  static int[] arr;
  static int[][] dp;
  static int target;
  public static void main (String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while(t-- >0){
      int n = in.nextInt();
      arr = new int[n];
      int sum =0;
      for(int i=0; i<n; i++){
        arr[i] = in.nextInt();
        sum += arr[i];
      }
      if(!isEven(sum)){
        System.out.println("NO");
        continue;
      }
      target = sum/2;
      dp = new int[n][target+1];

      for(int i=0; i<n; i++){
        Arrays.fill(dp[i], -1);
      }

      int res = getRes(0,target);
      if(res==1){
        System.out.println("YES");
      }else{
        System.out.println("NO");
      }
    }
  }

  static int getRes(int idx, int sum){
    if(sum==0) return 1;
    if(sum < 0) return 0;
    if(idx >= arr.length) return 0;
    if(dp[idx][sum] != -1) return dp[idx][sum];
    else{
      int res1 = getRes(idx+1, sum-arr[idx]);
      int res2 = getRes(idx+1, sum);
      if(res1 ==1 || res2 ==1) dp[idx][sum] = 1;
      else dp[idx][sum] = 0;
    }
    return dp[idx][sum];
  }

  static boolean isEven(int x){
    if(x%2==0) return true;
    else return false;
  }
}

