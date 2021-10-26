import java.util.*;
import java.lang.*;
import java.io.*;

public class StockBuySell {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while (t-- > 0) {
      int n = in.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = in.nextInt();
      }
      String res = getRes(arr);
      if (res == "") System.out.println("No Profit");
      else System.out.println(res);
    }
  }

  static String getRes(int[] arr) {
    String res = "";
    int n = arr.length;
    int i = 0;
    int j = 0;
    while (i < n) {
      int small = 0;
      int large = 0;
      while (i + 1 < arr.length && arr[i] > arr[i + 1]) {
        i++;
      }
      if (i == arr.length - 1) return res;
      small = i;
      j = i;
      while (j + 1 < arr.length && arr[j] < arr[j + 1]) {
        j++;
      }
      large = j;
      res += "(" + small + " " + large + ") ";
      i = large + 1;
    }
    return res;
  }
}
