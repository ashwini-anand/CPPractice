import java.util.Arrays;
import java.util.Scanner;

public class NearestMeetingPoint {
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
      int firstP = in.nextInt();
      int secondP = in.nextInt();

      if(firstP <0 || firstP >=n || secondP <0 || secondP >=n){
        System.out.println("-1");
        continue;
      }

      int[] first = new int[n];
      int max_val = 9999999;
      Arrays.fill(first, max_val);
      int[] second = new int[n];
      Arrays.fill(second, max_val);

      first[firstP] =0;
      boolean[] vis1 = new boolean[n];
      vis1[firstP]= true;
      dfs(firstP, first, graph, vis1, 0);

      second[secondP] =0;
      boolean[] vis2 = new boolean[n];
      vis2[secondP] = true;
      dfs(secondP, second, graph, vis2, 0);

      int min = first[0] + second[0];
      int minIdx = 0;
      for(int i=1; i<n; i++){
        int sum = first[i] + second[i];
        if(min > sum){
          min = sum;
          minIdx = i;
        }
      }
      if(min >= max_val){
        System.out.println("-1");
      }else{
        System.out.println(minIdx);
      }
    }

  }

  static void dfs(int idx, int[] distArr, int[] graph, boolean[] vis, int dist){
    distArr[idx] = dist;
    int nextIdx = graph[idx];
    if(nextIdx != -1 && !vis[nextIdx]){
      vis[nextIdx] = true;
      dfs(nextIdx, distArr, graph, vis, dist+1);
    }

  }
}
