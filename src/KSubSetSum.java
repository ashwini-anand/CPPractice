import java.util.Arrays;
import java.util.Scanner;

public class KSubSetSum {

  static int[] arr;
  static int n;
  static int k;
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int abc = Integer.parseInt("555",8);
    System.out.println(abc);
    String bcd = Integer.toString(abc,16);
    System.out.println(bcd);
//    int t = in.nextInt();
//    while(t-- >0){
//      n = in.nextInt();
//      arr = new int[n];
//      for(int i=0; i<n; i++){
//        arr[i] = in.nextInt();
//      }
//      k = in.nextInt();
//      int res = isKPartitionPossible(arr,n,k) ? 1: 0;
//      System.out.println(res);
//    }
  }
  static boolean isKPartitionPossible(int a[], int n, int k) {
    if (k == 1) return true;
    if (k > n) return false;
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += a[i];
    }
    if (sum % k != 0) return false;
    int subsetSum = sum / k;
    int[] subsetSumTracker = new int[k];
    boolean taken[] = new boolean[n];
    //subsetSumTracker[k-1] = a[0];
    //taken
    Arrays.fill(subsetSumTracker,0);
    Arrays.fill(taken, false);
    boolean isPos = isKPartitionPossibleUtil(a, n, k, 0, 0, taken, subsetSumTracker, subsetSum);
    return isPos;
  }

  static boolean isKPartitionPossibleUtil(int[] a, int n, int k, int curTrackerIdx, int currArrIdx, boolean[] taken, int[] subsetSumTracker, int subsetSum) {
    if(subsetSumTracker[curTrackerIdx] == subsetSum){
      if(curTrackerIdx == k-2) return true;
      else return isKPartitionPossibleUtil(a,n,k,curTrackerIdx+1,0,taken,subsetSumTracker,subsetSum);
    }
    for(int i= currArrIdx; i<n; i++){
      if(taken[i]) continue;
      int tmp = subsetSumTracker[curTrackerIdx] + a[i];
      if(tmp > subsetSum) continue;
      taken[i] = true;
      subsetSumTracker[curTrackerIdx] = tmp;
      boolean ispos = isKPartitionPossibleUtil(a,n,k,curTrackerIdx,i+1,taken, subsetSumTracker,subsetSum);
      subsetSumTracker[curTrackerIdx] = subsetSumTracker[curTrackerIdx] - a[i];
      taken[i] = false;
      if(ispos) return true;
    }
    return false;
  }
}
