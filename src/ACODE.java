import java.util.*;
import java.lang.*;

public class ACODE {
  static String input;
  static int[] dp;

  public static void main(String[] args) throws java.lang.Exception {
    Scanner in = new Scanner(System.in);
//    char ab = 'd';
//    int assd = Math.min('d','a');
//    System.out.println(assd);
//    System.out.println(ab-'a');
    while (true) {
      input = in.next();
      if (input.length() ==1 && Integer.parseInt(input) == 0) break;
      dp = new int[input.length()+1];
      Arrays.fill(dp,-1);
      System.out.println(getRes(0));
    }
  }

  static int getRes(int idx) {
    if (idx == input.length()) return 1;
    if(dp[idx] != -1) return dp[idx];
    int res1 = getRes(idx + 1);
    int res2 = 0;
    int res3 = 0;
    if (idx + 1 < input.length()) {
      if (getIntAtIndex(idx) == 1) {
        res2 = getRes(idx + 2);
      } else if (getIntAtIndex(idx) == 2) {
        if (getIntAtIndex(idx + 1) <= 6) {
          res3 = getRes(idx + 2);
        }
      }
    }
    dp[idx] = res1 + res2 + res3;
    return dp[idx];
  }

  static int getIntAtIndex(int idx) {
    return Integer.parseInt("" + input.charAt(idx));
  }
}
