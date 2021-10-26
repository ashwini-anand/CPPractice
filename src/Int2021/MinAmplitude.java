package Int2021;

public class MinAmplitude {
  public int solution(int[] A, int K) {
    int n = A.length;
    int[] minLeft = new int[n];
    int min = A[0];
    minLeft[0] = min;
    for (int i = 1; i < n; i++) {
      min = Math.min(min, A[i]);
      minLeft[i] = Math.min(min, A[i]);
    }

    int[] maxLeft = new int[n];
    int max = A[0];
    maxLeft[0] = max;
    for (int i = 1; i < n; i++) {
      max = Math.max(max, A[i]);
      maxLeft[i] = Math.max(max, A[i]);
    }

    int[] minRight = new int[n];
    min = A[n - 1];
    minRight[n - 1] = min;
    for (int i = n - 2; i >= 0; i--) {
      min = Math.min(min, A[i]);
      minRight[i] = Math.min(min, A[i]);
    }

    int[] maxRight = new int[n];
    max = A[n - 1];
    maxRight[n - 1] = max;
    for (int i = n - 2; i >= 0; i--) {
      max = Math.max(max, A[i]);
      maxRight[i] = Math.max(max, A[i]);
    }

//    printArr(minLeft);
//    printArr(maxLeft);
//    printArr(minRight);
//    printArr(maxRight);
    int amp = Integer.MAX_VALUE;
    int start = 0;
    int end = K-1;
    while (end < n) {
      if (start == 0) {
        int diff = maxRight[end+1] - minRight[end+1];
        amp = Math.min(amp, diff);
      } else if (end == n - 1) {
        int diff = maxLeft[start-1] - minLeft[start-1];
        amp = Math.min(amp, diff);
      } else {
        int mmin = Math.min(minLeft[start-1], minRight[end+1]);
        int mmax = Math.max(maxLeft[start-1], maxRight[end+1]);
        int diff = mmax - mmin;
        amp = Math.min(amp, diff);
      }
      start++;
      end++;
    }

    return amp;
  }

  void printArr(int[] arr){
    for(int i=0; i< arr.length; i++){
      System.out.print(arr[i]+", ");
    }
    System.out.println();
  }
  public static void main(String[] args) {
    MinAmplitude ma = new MinAmplitude();
    int[] arr = {5,3,6,1,3};
    int res = ma.solution(arr, 4);
    System.out.println(res);
  }
}
