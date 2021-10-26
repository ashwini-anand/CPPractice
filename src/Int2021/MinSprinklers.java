//https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
//Accepted
package Int2021;

import java.util.Arrays;
import java.util.Comparator;

public class MinSprinklers {
  class Range {
    int idx;
    int right;
    int left;

    public Range(int i, int r, int l) {
      this.idx = i;
      this.right = r;
      this.left = l;
    }
  }

  class RangeComaprator implements Comparator<Range> {
    //@overide
    public int compare(Range r1, Range r2) {
      return r1.right - r2.right;
    }
  }

  public int minTaps(int n, int[] ranges) {
    Range[] rgs = new Range[ranges.length];
    for (int i = 0; i < ranges.length; i++) {
      rgs[i] = new Range(i, i + ranges[i], i - ranges[i]);
    }
    Arrays.sort(rgs, new RangeComaprator());

    int maxL = rgs.length - 1;
    int targetR = rgs.length - 1;
    int count = 0;
    int k = rgs.length - 1;
    boolean done = false;
    for (int i = rgs.length - 1; i >= 0; i--) {
      while (k >=0 && rgs[k].right >= targetR) {
        if (rgs[k].left <= maxL) {
          maxL = rgs[k].left;
        }
        k--;
      }
      i = k;
      count++;
      if (maxL <= 0) {
        done = true;
        break;
      }
      if(targetR == maxL) break;
      targetR = maxL;
    }
    if (maxL <= 0) return count;
    else return -1;
  }

  public static void main(String[] args) {
    int ranges1[] = {4,0,0,0,0,0,0,0,4};
    int ranges2[] = {0,0,0,0};
    int ranges3[] = {3,1,5,0,4,3,2,5,0,2,4,2,1,3,4,4,5,1,3,2,3,0,1,3,1,0,3,2,0,3,4,2,1,0,5,5,0,4,2};
    MinSprinklers ms = new MinSprinklers();
    System.out.println(ms.minTaps(ranges3.length, ranges3));
  }
}
