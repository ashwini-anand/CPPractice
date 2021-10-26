package Int2021;

import java.util.Arrays;

public class StockBuySell2times {
  public int maxProfit(int[] prices) {
    int[] profit1 = new int[prices.length];
    int[] profit2 = new int[prices.length];
    Arrays.fill(profit1,0);
    Arrays.fill(profit2,0);
    int n = prices.length;
    int res=0;
    if(n ==0) return res;
    int min = prices[0];
    for(int i=1; i<n; i++){
      profit1[i] = Math.max(profit1[i-1], prices[i]-min);
      if(prices[i] < min) min = prices[i];
    }

    int max = prices[n-1];

    for(int i=n-2; i>=0; i--){
      profit2[i] = Math.max(profit2[i+1], max-prices[i]);
      if(prices[i] > max) max = prices[i];
    }
    printArray(profit1);
    printArray(profit2);

    for(int i=0; i<n; i++){
      //int tempRes=
      res = Math.max(res, profit1[i]+profit2[i]);
    }
    return res;
  }

  public static void main(String[] args) {
    StockBuySell2times sb2 = new StockBuySell2times();
    int[] arr = {3,3,5,0,0,3,1,4};
    int res = sb2.maxProfit(arr);
    System.out.println(res);
  }

  void printArray(int[] arr){
    for(int i=0; i< arr.length; i++){
      System.out.print(arr[i]+" ,");
    }
    System.out.println();
  }
}
