import java.util.*;

public class CanBeRearrangedToPalindrome {
  static String input;
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while(t-- >0){
      input = in.next();
      String res = getRes();
      System.out.println(res);
    }
  }

  static String getRes(){
    HashMap<Character, Integer> countMap = new HashMap<>();
    for(int i=0; i< input.length(); i++){
      char currCahr = input.charAt(i);
      if(countMap.containsKey(currCahr)){
        int count = countMap.get(currCahr);
        count++;
        countMap.put(currCahr,count);
      }else{
        countMap.put(currCahr,1);
      }
    }
    boolean singleSet = false;
    for(char ch : countMap.keySet()){
      int currCharCount = countMap.get(ch);
      if(currCharCount > 1 && currCharCount%2 !=0) return "No";
      if(currCharCount == 1 && input.length()%2==0 || (currCharCount == 1 && input.length()%2 !=0 && singleSet)) return "No";
      if(currCharCount == 1 && input.length()%2!=0) singleSet=true;
    }
    return "Yes";
  }
}
