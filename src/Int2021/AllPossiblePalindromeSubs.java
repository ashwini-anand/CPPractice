//https://practice.geeksforgeeks.org/problems/find-all-possible-palindromic-partitions-of-a-string/1/
package Int2021;

import java.util.*;

public class AllPossiblePalindromeSubs {
  static String sc = "-@";
  static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {

    HashMap<Integer, ArrayList<String>> dp = new HashMap<>();
    ArrayList<String> iRes = getRes(0, S, dp);
    ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
    for(int i=0; i<iRes.size(); i++){
      String[] currout = iRes.get(i).split(sc);
      ArrayList<String> t = new ArrayList<String>(Arrays.asList(currout));
      res.add(t);
    }
    return res;
  }

  static ArrayList<String> getRes(int idx, String str, HashMap<Integer, ArrayList<String>> dp){
    if(idx >= str.length()) {
      ArrayList<String> res = new ArrayList<String>();
      res.add("");
      return res;
    }
    if(dp.containsKey(idx)) return dp.get(idx);
    ArrayList<String> res = new ArrayList<String>();
    for(int i=idx; i< str.length(); i++){
      String sub = str.substring(idx, i+1);
      if(isPalindrome(sub)){
        ArrayList<String> it = getRes(i+1, str, dp);
        //printList(it);
        for(int j=0; j< it.size(); j++){
          String cr = it.get(j);
          res.add(sub+sc+cr);
        }
      }
    }
    //printList(res);
    dp.put(idx, res);
    return res;
  }

  static boolean isPalindrome(String str){
    //System.out.println(str);
    int i=0;
    int j = str.length()-1;
    boolean isPalin = true;
    while(i <= j){
      if(str.charAt(i) != str.charAt(j)){
        isPalin = false;
      }
      i++;
      j--;
    }
    return isPalin;
  }

  public static void main(String[] args) {
    ArrayList<ArrayList<String>>  res =  allPalindromicPerms("geeks");
    for(int i=0; i< res.size(); i++){
      printList(res.get(i));
    }
  }

  static void printList(List<String> stringList){
    for(int i=0; i< stringList.size(); i++){
      System.out.print(stringList.get(i)+" ");
    }
    System.out.println();
  }
}
