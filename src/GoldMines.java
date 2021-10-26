import java.util.*;

public class GoldMines {

  static int n;
  static int m;
  static int inMat[][];
  static int dpMat[][][];
  static int res;

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while(t-- >0){
      res = Integer.MIN_VALUE;
      n = in.nextInt();
      m = in.nextInt();
      inMat = new int[n][m];

      int sum =0;
      for(int i=0; i<n ; i++){
        for(int j=0; j<m; j++){
          int nextVal = in.nextInt();
          inMat[i][j] = nextVal;
          sum+=nextVal;
        }
      }

      dpMat = new int[n][m][sum+1];

      for(int i=0; i<n ; i++){
        for(int j=0; j<m; j++){
          Arrays.fill(dpMat[i][j], -1);
        }
      }
      for(int i=0; i<n; i++){
        getRes(i,0,0);
      }
      System.out.println(res);
    }
  }

  static void getRes(int i, int j, int curSum) {
    //if(curSum > res) res = curSum;
    if(dpMat[i][j][curSum] == -1) {
      dpMat[i][j][curSum] = 1;
    }else{
      return;
    }
    curSum += inMat[i][j];
    if(!canMove(i, j+1) && !canMove(i+1, j+1) && !canMove(i-1,j+1)){
      if(curSum > res) res = curSum;
    }else{
      if(canMove(i, j+1)){
        getRes(i, j+1, curSum);
      }
      if(canMove(i+1,j+1)){
        getRes(i+1, j+1, curSum);
      }
      if(canMove(i-1, j+1)){
        getRes(i-1, j+1, curSum);
      }
    }
  }

  static boolean canMove(int i, int j){
    if(i <n && j <m && i>=0 && j >=0) return true;
    return false;
  }
}
