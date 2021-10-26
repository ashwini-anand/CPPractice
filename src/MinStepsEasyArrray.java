import java.lang.*;
import java.util.*;
import java.io.*;

public class MinStepsEasyArrray {
  static class Point{
    int x;
    int y;
    Point(int xcord, int ycord){
      this.x = xcord;
      this.y = ycord;
    }
  }

  static class PointComparator implements Comparator<Point>{

    @Override
    public int compare(Point o1, Point o2) {
      int dist1 = o1.x*o1.x + o1.y*o1.y;
      int dist2 = o2.x*o2.x + o2.y*o2.y;
      return dist1 - dist2;
    }
  }

  public static int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
    Point[] parray = new Point[A.size()];
    for(int i=0; i< A.size(); i++){
      Point p = new Point(A.get(i), B.get(i));
      parray[i] = p;
    }
    return getRes(parray);
  }

  public static int getRes(Point[] parray){
    PointComparator pcom = new PointComparator();
    int sum =0;
    for(int i=0; i<parray.length-1; i++){
      int diffX = Math.abs(parray[i].x - parray[i+1].x);
      int diffY = Math.abs(parray[i].y - parray[i+1].y);
      sum = sum + Math.max(diffX, diffY);
    }
    return sum;
  }

  public static void main(String[] args) {
    ArrayList<Integer> listA = new ArrayList<>(Arrays.asList( 4, 8, -7, -5, -13, 9, -7, 8 ));
    ArrayList<Integer> listB = new ArrayList<>(Arrays.asList(4, -15, -10, -3, -13, 12, 8, -8));
    int res = coverPoints(listA,listB);
    System.out.println(res);
  }
}
