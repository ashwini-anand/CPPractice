import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class SnakeLadder {
  static int largeNumber = Integer.MAX_VALUE - 1000;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      int ladNum = in.nextInt();
      HashMap<Integer, Integer> ladders = new HashMap<>();
      for (int i = 0; i < ladNum; i++) {
        int o = in.nextInt();
        int d = in.nextInt();
        ladders.put(o, d);
      }
      int n = 30;
      int[] board = new int[n + 1];
      int[] dp = new int[n + 1];
      Arrays.fill(dp, -1);
      boolean[] instack = new boolean[n + 1];
      int res = Integer.MAX_VALUE;
      int idx = 1;
      if (ladders.containsKey(idx)) {
        int nextDest = ladders.get(idx);
        res = Math.min(res, getRes(nextDest, board, instack, dp, ladders, n));
      }
      for (int i = 1; i <= 6; i++) {
        instack[i] = true;
        res = Math.min(res, 1 + getRes(idx + i, board, instack, dp, ladders, n));
        System.out.println("idx+i=" + (idx + i) + " res=" + res);
        instack[i] = false;
      }
      System.out.println(res);
    }
  }

  static int getRes(int idx, int[] board, boolean[] instack, int[] dp, HashMap<Integer, Integer> ladders, int n) {
    if (idx == n || (ladders.containsKey(idx) && ladders.get(idx) == n)) return 0;
    if (idx > n) return largeNumber;
    if (dp[idx] != -1) return dp[idx];
    instack[idx] = true;
    int res = largeNumber;
    if (ladders.containsKey(idx)) {
      int nextDest = ladders.get(idx);
      if (!instack[nextDest]) {
        res = Math.min(res, getRes(nextDest, board, instack, dp, ladders, n));
      }
    }

    for (int i = 1; i <= 6; i++) {
      if (idx + i <= n && !instack[idx + i]) {
        res = Math.min(res, 1 + getRes(idx + i, board, instack, dp, ladders, n));
      }
    }
    instack[idx] = false;
    dp[idx] = res;
    //System.out.println(res);
    return res;

  }
}
