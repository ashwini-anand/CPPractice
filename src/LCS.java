import java.util.*;

public class LCS {
  static char[] str1;
  static char[] str2;
  static int[][] dpmat;
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();

    while (t-- > 0) {
      int a = in.nextInt();
      int b = in.nextInt();
      str1 = in.next().toCharArray();
      str2 = in.next().toCharArray();
      dpmat = new int[str1.length][str2.length];
      for(int i=0; i<dpmat.length; i++){
        Arrays.fill(dpmat[i], -1);
      }
      int res = getResult(0, 0);
      System.out.println(res);
    }
  }

  public static int getResult(int idx1, int idx2) {
    if (idx1 == str1.length || idx2 == str2.length) return 0;
    if(dpmat[idx1][idx2] != -1) return dpmat[idx1][idx2];
    if (str1[idx1] == str2[idx2]) {
      int res = 1 + getResult(idx1 + 1, idx2 + 1);
      dpmat[idx1][idx2] = res;
      return res;
    }
    int res = Math.max(getResult(idx1 + 1, idx2), getResult(idx1, idx2 + 1));
    dpmat[idx1][idx2] = res;
    return res;
  }
}
