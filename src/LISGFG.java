import java.util.Arrays;
import java.util.Scanner;

public class LISGFG {

  static int[] resArr;
  static int[] inArr;
  public static void main (String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    int icount =0;
    while(icount < t){
      icount++;
      int n = in.nextInt();
      resArr = new int[n];
      Arrays.fill(resArr, -1);
      inArr = new int[n];
      for(int i=0; i<n;i++){
        inArr[i] = in.nextInt();
      }
      getRes(0);
      int res = resArr[0];
      for(int i=0; i<n; i++){
        if(res < resArr[i]){
          res = resArr[i];
        }
      }
      //prinArr(resArr);
      System.out.println(res);
    }
  }

  static void prinArr(int[] arr){
    for(int i=0; i< arr.length; i++){
      System.out.print(arr[i]+" ");
    }
    System.out.println();
  }

  static int getRes(int idx){
    if(idx == inArr.length){
      return 0;
    }
    if(idx == inArr.length -1){
      resArr[idx] =1;
      return 1;
    }
    if(resArr[idx] != -1){
      return resArr[idx];
    }

    resArr[idx] =1;
    int n = inArr.length;
    for(int i= n-1; i> idx; i--){
      int tmp = getRes(i);
      if(inArr[i] > inArr[idx] && resArr[i] + 1 > resArr[idx]){
        resArr[idx] = resArr[i] +1;
      }
    }
    return resArr[idx];
  }
}
