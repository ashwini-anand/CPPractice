import java.util.Arrays;
import java.util.Scanner;

public class SubSetSumDP {

  static int[][] dpmatrix;
  static int array[];
  static int halfsum;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t > 0) {
      t--;
      int n = in.nextInt();
      array = new int[n];
      int sum = 0;
      for (int i = 0; i < n; i++) {
        array[i] = in.nextInt();
        sum += array[i];
      }
      if (sum % 2 != 0) {
        System.out.println("NO");
      } else {
        halfsum = sum / 2;
        dpmatrix = new int[n][halfsum + 1];
        for (int i = 0; i < n; i++) {
          Arrays.fill(dpmatrix[i], -1);
        }
        if (isSubSetSUm(0, 0)) {
          System.out.println("YES");
        } else {
          System.out.println("NO");
        }
      }
    }

  }

  public static boolean isSubSetSUm(int idx, int sum) {
    if (sum == halfsum) {
      return true;
    }
    if (sum > halfsum) return false;

    if (sum != halfsum && idx == array.length) {
      return false;
    }
    if (dpmatrix[idx][sum] != -1) {
      if (dpmatrix[idx][sum] == 0) return false;
      else return true;
    }

    boolean isPossible = isSubSetSUm(idx + 1, sum) || isSubSetSUm(idx + 1, sum + array[idx]);
    dpmatrix[idx][sum] = isPossible == true ? 1 : 0;
    return isPossible;

  }
}
