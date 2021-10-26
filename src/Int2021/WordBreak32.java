package Int2021;

import java.util.*;

public class WordBreak32 {

  public static void main(String[] args) {
    String[] values = {"mobile","samsung","sam","sung",
        "man","mango","icecream","and",
        "go","i","like","ice","cream"};
    HashSet<String> dict = new HashSet<>(Arrays.asList(values));
    String str = "ilikesamsung";
    int[] dp = new int[str.length()];
    Arrays.fill(dp,-1);
    System.out.println(getRes(0, str, dp, dict));
  }

  static boolean getRes(int idx, String str, int[] dp, Set<String> dict){
    if(idx >= str.length()) return true;
    if(dp[idx] != -1){
      if(dp[idx] == 0) return false;
      else return true;
    }

    boolean isPossible = false;
    for(int i=idx; i< str.length(); i++){
      if(dict.contains(str.substring(idx,i+1))){
        isPossible = getRes(i+1, str, dp, dict);
      }
      if(isPossible) break;
    }
    if(isPossible){
      dp[idx] = 1;
    }else{
      dp[idx] =0;
    }
    return isPossible;
  }
}
