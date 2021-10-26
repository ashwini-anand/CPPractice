//https://practice.geeksforgeeks.org/problems/pairs-which-are-divisible-by-41920/1
//This can be extended to https://www.geeksforgeeks.org/count-pairs-in-array-whose-sum-is-divisible-by-k/
import java.util.HashMap;

public class DivisiblePairs {
  public static int count4Divisibiles(int arr[], int n )
  {
    HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
    int count =0;
    for(int i=0; i < n; i++){
      int rem = arr[i] % 4;
      int pairRem = (4-rem)%4;
      if(hmap.containsKey(pairRem)){
        int c = hmap.get(pairRem);
        count = count+c;
      }
      if(hmap.containsKey(rem)){
        int c = hmap.get(rem);
        hmap.put(rem, c+1);
      }else{
        hmap.put(rem,1);
      }
    }
    return count;
  }

}
