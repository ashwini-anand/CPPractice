import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

public class VerticalOrderBT {


  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
      left = null;
      right = null;
    }
  }

  static class TreeNodeWithVl {
    TreeNode tnode;
    int vline;

    TreeNodeWithVl(TreeNode nd, int vl) {
      tnode = nd;
      vline = vl;
    }
  }

  static TreeMap<Integer, ArrayList<Integer>> hmap;

  public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
    hmap = new TreeMap<>();
    getRes(A);
    ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
    if(A == null) return all;
    getRes(A);
    for (Integer ii : hmap.keySet()) {
      all.add(hmap.get(ii));
    }
    return all;
  }

  public static void getRes(TreeNode nd) {

    LinkedList<TreeNodeWithVl> queue = new LinkedList<>();
    queue.addFirst(new TreeNodeWithVl(nd, 0));
    while (!queue.isEmpty()) {
      TreeNodeWithVl tdvl = queue.removeLast();
      TreeNode td = tdvl.tnode;
      int vline = tdvl.vline;
      if (hmap.containsKey(vline)) {
        ArrayList<Integer> al = hmap.get(vline);
        al.add(td.val);
        hmap.put(vline, al);
      } else {
        ArrayList<Integer> al = new ArrayList<>();
        al.add(td.val);
        hmap.put(vline, al);
      }
      if (td.left != null) queue.addFirst(new TreeNodeWithVl(td.left, vline - 1));
      if (td.right != null) queue.addFirst(new TreeNodeWithVl(td.right, vline + 1));
    }
  }
}
