package Int2021;

import java.util.*;

public class PrereqTasks {

  static class Node {
    int val;
    ArrayList<Node> kids;

    public Node(int v) {
      this.val = v;
      kids = new ArrayList<>();
    }
  }

  public boolean isPossible(int N, int[][] prerequisites) {
    HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    for (int i = 0; i < N; i++) {
      Node nd = new Node(i);
      map.put(i, nd);
    }
    for (int i = 0; i < prerequisites.length; i++) {
      Node kid = map.get(prerequisites[i][0]);
      Node nd = map.get(prerequisites[i][1]);
      nd.kids.add(kid);
    }

    HashSet<Node> vis = new HashSet<>();
    HashSet<Node> recStack = new HashSet<>();

    boolean hasCycle = false;
    for (Integer ii : map.keySet()) {
      Node curr = map.get(ii);
      if (!vis.contains(curr)) {
        hasCycle = isCyclic(curr, vis, recStack);
        if (hasCycle) break;
      }
    }
    return !hasCycle;
  }

  public boolean isCyclic(Node curr, HashSet<Node> vis, HashSet<Node> recStack) {
    if (recStack.contains(curr)) return true;
    if (vis.contains(curr)) return false;
    vis.add(curr);
    recStack.add(curr);
    boolean hasCycle = false;
    for (int i = 0; i < curr.kids.size(); i++) {
      hasCycle = isCyclic(curr.kids.get(i), vis, recStack);
      if (hasCycle) break;
    }
    recStack.remove(curr);
    return hasCycle;
  }

  public void printList(List<Node> nodes){
    for(int i=0; i< nodes.size(); i++){
      System.out.println("val = "+nodes.get(i).val);
    }
  }
  public static void main(String[] args) {
    int[][] mat = new int[2][2];
    mat[0][0] = 1;
    mat[0][1] = 0;
    mat[1][0] = 0;
    mat[1][1] = 1;
    PrereqTasks pt = new PrereqTasks();
    System.out.println(pt.isPossible(2,mat));
  }
}
