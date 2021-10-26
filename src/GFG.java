import java.util.*;
import java.io.*;

public class GFG {
  static int n;
  static int m;
  static char[][] matrix;
  static boolean[][] vis;
  static class Pair {
    int r;
    int c;
    public Pair(int r, int c){
      this.r = r;
      this.c = c;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
   // System.out.println("enter t");
    int t = in.nextInt();

    while(t-- > 0){
      //System.out.println("enter n and m");
      n = in.nextInt();
      m = in.nextInt();
      matrix = new char[n][m];
      vis = new boolean[n][m];

      //System.out.println("enter string");
      for(int i=0; i<n; i++){
        String str = in.next();
        for(int j=0; j<m; j++){
          matrix[i][j] = str.charAt(j);
        }
      }

      //printMatrix();
      int count =0;
      for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
          if(matrix[i][j] == 'X' && !vis[i][j]){
            count++;
            bfs(i,j);
          }
        }
      }
      System.out.println(count);
    }
  }

  public static void bfs(int r, int c) {
    LinkedList<Pair> queue = new LinkedList<>();
    queue.addFirst(new Pair(r,c));
    while(queue.size() >0){
      Pair p = queue.removeLast();
      vis[p.r][p.c] = true;
      //System.out.println("c="+c+" r="+r);
      if(p.c-1 >= 0 && matrix[p.r][p.c-1] == 'X' && !vis[p.r][p.c-1]){
        queue.addFirst(new Pair(p.r, p.c-1));
      }
      if(p.c+1 < m && matrix[p.r][p.c+1] == 'X' && !vis[p.r][p.c+1]){
        queue.addFirst(new Pair(p.r, p.c+1));
      }
      if(p.r-1 >= 0 && matrix[p.r-1][p.c] == 'X' && !vis[p.r-1][p.c]){
        queue.addFirst(new Pair(p.r-1, p.c));
      }
      if(p.r+1 < n && matrix[p.r+1][p.c] == 'X' && !vis[p.r+1][p.c]){
        queue.addFirst(new Pair(p.r+1, p.c));
      }
    }
  }

  public static void printMatrix(){
    for (int i=0 ; i<n; i++){
      for(int j=0; j<m; j++){
        System.out.print(matrix[i][j]+" ");
      }
      System.out.println();
    }
  }
}
