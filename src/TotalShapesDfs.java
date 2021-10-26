import java.util.Scanner;

public class TotalShapesDfs {
  static int n;
  static int m;
  static char[][] matric;
  static boolean[][] vis;

  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();

    while(t-- >0){
      n = in.nextInt();
      m = in.nextInt();
      matric = new char[n][m];
      vis = new boolean[n][m];

      for(int i=0; i<n; i++){
        String str = in.next();
        for(int j=0; j<m; j++){
          matric[i][j] = str.charAt(j);
        }
      }

      //printMatrix();

      int count=0;

      for(int i=0; i<n; i++){
        for(int j=0; j<m; j++){
          if(matric[i][j] == 'X' && !vis[i][j]){
            count++;
            dfs(i,j);
          }
        }
      }
      System.out.println(count);
    }
  }

  public static void dfs(int rr, int cc){
    vis[rr][cc] = true;
    int[] xr = {0,0,1,-1};
    int[] yc = {1,-1,0,0};
    for(int i=0; i<4; i++){
      int newrr = rr+xr[i];
      int newcc = cc+yc[i];
      if(isValid(rr+xr[i], cc+yc[i]) && matric[newrr][newcc] == 'X' && !vis[newrr][newcc]){
        dfs(newrr,newcc);
      }
    }
  }

  public static boolean isValid(int r, int c){
    return (r >=0 && r < n && c >=0 && c <m);
  }

  public static void printMatrix(){
    for (int i=0 ; i<n; i++){
      for(int j=0; j<m; j++){
        System.out.print(matric[i][j]+" ");
      }
      System.out.println();
    }
  }
}
