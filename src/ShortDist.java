import java.util.Scanner;

public class ShortDist {
  static int max = -99999;
  public static void main(String args[] ) throws Exception {
        /* Sample code to perform I/O:
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        */

    // Write your code here
    Scanner in = new Scanner(System.in);

    int t = in.nextInt();

    while(t-- >0){
      int n = in.nextInt();
      int[] graph = new int[n];

      for(int i=0; i<n; i++){
        graph[i] = in.nextInt();
      }

      boolean vis[] = new boolean[n];
      for(int i=0; i<n ;i++){
        if(!vis[i]){
          int res = getMax(i, graph, vis);
          max = Math.max(res,max);
        }
      }

      if(max <0){
        System.out.println("-1");
      }else{
        System.out.println(max);
      }
    }

  }

  static int getMax(int idx, int[] graph, boolean[] vis){
    vis[idx] = true;
    int nextIdx = graph[idx];
    int res =-1;
    if(nextIdx !=-1 && !vis[nextIdx]){
      res = getMax(nextIdx, graph, vis);
      if(res < 0){
        return -1;
      }else{
        return res+idx;
      }
    }if(nextIdx !=-1 && vis[nextIdx]){
      return nextIdx+idx;
    }else{
      return -1;
    }
  }
}
