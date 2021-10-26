import java.util.Scanner;

import java.util.*;
import java.lang.*;
import java.io.*;

public class MaxSumWithoutAdjacent {
  static int[] arr;
  static int[] dp;
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while(t-- > 0){
      int n = in.nextInt();
      arr = new int[n];
      for(int i=0; i<n; i++){
        arr[i] = in.nextInt();
      }
      dp = new int[n+1];
      Arrays.fill(dp,-1);
      int res = getRes(0);
      System.out.println(res);
    }
  }

  static int getRes(int idx){
    int n = arr.length;
    if(idx >=n) return 0;
    if(dp[idx]!=-1) return dp[idx];
    int res1 = arr[idx] + getRes(idx+2);
    int res2 = getRes(idx+1);
    int res = Math.max(res1,res2);
    dp[idx] = res;
    return res;
  }

  static String findNumber(List<Integer> arr, int k) {
    Integer[] arr1 = new Integer[arr.size()];
    arr.toArray(arr1);
    boolean res = findUtil(arr1,k, 0, arr1.length-1);
    String retres = res ? "YES": "NO";
    return retres;
  }

  static boolean findUtil(Integer[] arr,int k, int start, int end){
    if(end < start || start < 0 || end > arr.length){
      return false;
    }
    if(end - start ==0) {
      boolean res = arr[end] == k ?  true :  false;
      return res;
    }
    int mid = (end-start)/2;
    if(arr[mid] == k){
      return true;
    }else if(arr[mid] > k){
      return findUtil(arr,k,start,mid-1);
    }else{
      return findUtil(arr,k,mid+1,end);
    }
  }
}
