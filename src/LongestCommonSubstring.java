import java.util.Arrays;

public class LongestCommonSubstring {
  int longestCommonSubstr(String S1, String S2, int n, int m){
    int len1 = S1.length();
    int len2 = S2.length();
    int[][] dp = new int[len1+1][len2+1];
    for(int i=0; i< len1; i++){
      Arrays.fill(dp[i], -1);
    }
    getRes(n-1,m-1, S1, S2, dp);
    printMat(dp);
    int max = -1;
    for(int i=0; i< len1; i++){
      for(int j=0; j < len2; j++){
        max = Math.max(max, dp[i][j]);
      }
    }
    return max;
  }

  void printMat(int[][] mat){
    int len1 = mat.length;
    int len2 = mat[0].length;
    for(int i=0; i< len1; i++){
      for(int j=0; j < len2; j++){
        System.out.print(mat[i][j]+" ");
      }
      System.out.println();
    }
    System.out.println();
  }
  int getRes(int idx1, int idx2, String s1, String s2, int[][] dp){
    int len1 = s1.length();
    int len2 = s2.length();

    if(idx1 < 0 || idx2 < 0) return 0;
    if(dp[idx1][idx2] != -1) return dp[idx1][idx2];

    if(s1.charAt(idx1) == s2.charAt(idx2)){
      int res1 = 1 + getRes(idx1-1, idx2-1, s1, s2, dp);
      getRes(idx1, idx2-1, s1, s2, dp);
      getRes(idx1-1, idx2, s1, s2, dp);
      dp[idx1][idx2] = res1;
    }else{
      dp[idx1][idx2] =0;
      getRes(idx1, idx2-1, s1, s2, dp);
      getRes(idx1-1, idx2, s1, s2, dp);
    }

    return dp[idx1][idx2];
  }

  public static void main(String[] args) {
//    String s1 = "KXCGMTMVVGFQQWSPD";
//    String s2 = "JXZADDUKVLQPKUZJZHWSUTPCAFSYAIBJHAMMEGWBTPQELRNKBLDXGUZGCSEC";
    String s1 = "WS";
    String s2 = "WSKS";
    int len1 = s1.length();
    int len2 = s2.length();
    LongestCommonSubstring lcs = new LongestCommonSubstring();
    System.out.println(lcs.longestCommonSubstr(s1,s2,len1,len2));
  }
}
