package Int2021;

import java.util.*;

public class LeetcodeMergeIntervals56 {
  static class Mpair{
    int x;
    int y;
    public Mpair(int x, int y){
      this.x=x;
      this.y = y;
    }
  }
  public int[][] merge(int[][] intervals) {
    int n = intervals.length;
    //int m = intervals[0].length;
    Mpair[] pairs = new Mpair[n];
    for(int i=0; i<n; i++){
      Mpair mp = new Mpair(intervals[i][0], intervals[i][1]);
      pairs[i] = mp;
    }

    Arrays.sort(pairs, new Comparator<Mpair>(){
      public int compare(Mpair p1, Mpair p2){
        if(p1.y < p2.x) return -1;
        else if(p1.x > p2.y) return 1;
        else{
          return p1.x - p2.x;
          // if(p1.x < p2.x) return -1;
          // else if(p)return 1;
        }
      }
    });
    ArrayList<Mpair> res = new ArrayList<Mpair>();
    if(pairs.length == 1){
      int[][] resM = new int[1][2];
      resM[0][0] = pairs[0].x;
      resM[0][1] = pairs[0].y;
      return resM;
    }

    int currStart = -1;
    int currEnd = -1;
    for(int i=0;i<n-1; i++){
      currStart = pairs[i].x;
      currEnd = pairs[i].y;
      while(i<n-1 && canMerge(currStart, currEnd, pairs[i+1])){
        currStart = Math.min(currStart, pairs[i+1].x);
        currEnd = Math.max(currEnd, pairs[i+1].y);
        i++;
      }
      res.add(new Mpair(currStart, currEnd));
    }
    if(!canMerge(currStart, currEnd, pairs[n-1])){
      res.add(new Mpair(pairs[n-1].x, pairs[n-1].y));
    }

    int resLen = res.size();
    int[][] resMat = new int[resLen][2];
    for(int i=0; i< resLen; i++){
      resMat[i][0] = res.get(i).x;
      resMat[i][1] = res.get(i).y;
    }
    return resMat;
  }

  public boolean canMerge(int start, int end, Mpair p){
    if((p.y >= start && p.y <= end) || (end >= p.x && end <= p.y) ) return true;
    return false;
  }
}
