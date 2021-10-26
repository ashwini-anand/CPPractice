import java.util.*;

public class GS2 {

  public static void main(String[] args) {
    LinkedList <Integer> ll = new LinkedList<>();
    ll.add(5); ll.add(2); ll.add(3); ll.add(1); ll.add(4);
    System.out.println(getCountOfPossibleTeams(ll));
  }
  static int countPossibleTeams(List<Integer> coders) {
    int[] numOfGreater = new int[coders.size()];
    for(int i=0; i<coders.size(); i++){
      int currVal = coders.get(i);
      for(int j=i+1; j <coders.size(); j++){
        if(coders.get(j) > currVal) numOfGreater[i]++;
      }
    }

    int resAtEachIndex[] = new int[coders.size()];

    for(int i=0; i< coders.size(); i++){
      int currVal = coders.get(i);
      for(int j=i+1; j<coders.size(); j++){
        if(coders.get(j) > currVal) resAtEachIndex[i] += numOfGreater[j];
      }
    }

    int res =0;
    for(int i=0; i< resAtEachIndex.length; i++){
      res += resAtEachIndex[i];
    }
    return res;
  }

  static int getCountOfPossibleTeams(List<Integer> coders){
    int resUphold = countPossibleTeams(coders);
    Collections.reverse(coders);
    int resReverse = countPossibleTeams(coders);
    return resUphold+resReverse;
  }

}
