import java.util.*;

public class Ch2 {

  public static void main(String[] args) {
    int[] aortedarr = {1, 1, 1, 2, 2};
    isMajority(1, aortedarr);
  }

  static void isMajority(int x, int[] sortedArr) {
    //int[] sortedArr = copyToArray(arr);
    int size = sortedArr.length;
    boolean isAtMiddle = sortedArr[size / 2] == x ? true : false;
    if (isAtMiddle) {
      int half = size / 2;
      int leftMostIndex = leftMostIndex(sortedArr, x, 0, half);
      int rightMostIndex = rightMostIndex(sortedArr, x, half, size - 1);
      int count = rightMostIndex - leftMostIndex + 1;
      if (count > size / 2) {
        System.out.println("True");
      } else {
        System.out.println("False");
      }
    } else {
      System.out.println("False");
    }

  }

  static int leftMostIndex(int[] sortedArr, int x, int startIdx, int endIdx) {
    if (startIdx == endIdx) return endIdx;
    int mid = (endIdx - startIdx + 1) / 2 + startIdx;
    if (sortedArr[mid] == x) {
      if (mid - 1 == 0 || sortedArr[mid - 1] != x) {
        return mid;
      } else {
        int abc = 1;
        return leftMostIndex(sortedArr, x, startIdx, mid - 1);
      }
    } else {
      int bcd = 3;
      return leftMostIndex(sortedArr, x, mid + 1, endIdx);
    }
  }

  static int rightMostIndex(int[] sortedArr, int x, int startIdx, int endIdx) {
    if (startIdx == endIdx) return endIdx;
    int mid = (endIdx - startIdx + 1) / 2 + startIdx;
    if (sortedArr[mid] == x) {
      if (mid + 1 == endIdx || sortedArr[mid + 1] != x) return mid;
      else {
        return rightMostIndex(sortedArr, x, mid + 1, endIdx);
      }
    } else {
      return rightMostIndex(sortedArr, x, startIdx, mid - 1);
    }
  }

  static int[] copyToArray(List<Integer> arr) {
    int[] sortedArr = new int[arr.size()];
    for (int i = 0; i < arr.size(); i++) {
      sortedArr[i] = arr.get(i);
    }
    return sortedArr;
  }
}
