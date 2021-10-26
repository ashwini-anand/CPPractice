//Given a matrix of dimension r*c where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
//    0 : Empty cell
//    1 : Cells have fresh oranges
//    2 : Cells have rotten oranges
//
//    So, we have to determine what is the minimum time required to rot all oranges.
//    A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time.
//    If it is impossible to rot every orange then simply return -1.

import java.util.*;

public class RottenOranges {

  static int[][] mat;
  static int r;
  static int c;
  static LinkedList<Pos> queue;

  static class Pos{
   int i;
   int j;

   public Pos(int i, int j){
     this.i = i;
     this.j = j;
   }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while(t-- >0){
      r = in.nextInt();
      c = in.nextInt();
      mat = new int[r][c];
      queue = new LinkedList<>();
      for(int i=0; i<r; i++){
        for(int j=0; j<c; j++){
          int entry = in.nextInt();
          mat[i][j] = entry;
          if(entry ==2) queue.addFirst(new Pos(i,j));
        }
      }

      queue.addFirst(new Pos(-1, -1));
//      printMat();
//      printQueue();
      int count = bfs();

      boolean is1present = false;
      for(int i=0; i<r; i++){
        for(int j=0; j<c; j++){
          if(mat[i][j]==1){
            is1present = true;
            break;
          }
        }
        if(is1present) break;
      }

      if(is1present) System.out.println("-1");
      else System.out.println(count);

    }
  }

  static boolean isDelimiter(Pos p){
    return (p.i == -1 && p.j == -1);
  }

  static boolean proceed(int i, int j){
    if(i<0 || i>=r || j<0 || j>=c) return false;
    if(mat[i][j] ==1) return true;
    else return false;
  }

  static int bfs(){
    int count =0;

    while(!queue.isEmpty()){

      if(isDelimiter(queue.peekLast())){
        queue.removeLast();
        if(!queue.isEmpty()) {
          count++;
          queue.addFirst(new Pos(-1,-1));
        }
//        printMat();
//        printQueue();
        continue;
      }

      Pos p = queue.removeLast();
      int i = p.i; int j= p.j;
      if(proceed(i-1,j)){
        mat[i-1][j] = 2;
        queue.addFirst(new Pos(i-1,j));
      }

      if(proceed(i+1,j)){
        mat[i+1][j] = 2;
        queue.addFirst(new Pos(i+1,j));
      }

      if(proceed(i,j-1)){
        mat[i][j-1] = 2;
        queue.addFirst(new Pos(i,j-1));
      }

      if(proceed(i,j+1)){
        mat[i][j+1] = 2;
        queue.addFirst(new Pos(i,j+1));
      }
      //printMat();
    }
    return count;
  }

  static void printMat(){
    for(int i=0; i<r; i++){
      for(int j=0; j<c; j++){
        System.out.print(mat[i][j]+" ");
      }
      System.out.println();
    }

    //System.out.println();
  }

  static void printQueue(){

    for(int i=queue.size()-1; i>=0; i--){
      Pos p = queue.get(i);
      System.out.print("{"+p.i+" "+p.j+"},  ");
    }
//    for(Pos p: queue){
//      System.out.print("{"+p.i+" "+p.j+"},  ");
//    }
    System.out.println();
    System.out.println();
  }
}
