import java.util.ArrayList;
import java.util.LinkedList;

public class Zigzag {

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

  public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {

    LinkedList<TreeNode> stack1 = new LinkedList<>();
    LinkedList<TreeNode> stack2 = new LinkedList<>();
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

    stack1.addFirst(A);

    while (!stack1.isEmpty() || !stack2.isEmpty()) {

      ArrayList<Integer> al1 = new ArrayList<>();
      ArrayList<Integer> al2 = new ArrayList<>();

      while (!stack1.isEmpty()) {
        TreeNode p = stack1.removeFirst();
        al1.add(p.val);
        if(p.left != null) stack2.addFirst(p.left);
        if(p.right != null) stack2.addFirst(p.right);
      }
     // System.out.println("size of al1 is "+al1.size());
      if (!al1.isEmpty()) res.add(al1);

      while (!stack2.isEmpty()) {
        TreeNode p2 = stack2.removeFirst();
        al2.add(p2.val);
        if(p2.right != null) stack1.addFirst(p2.right);
        if(p2.left != null) stack1.addFirst(p2.left);
      }
     // System.out.println("size of al2 is "+al2.size());;
      if (!al2.isEmpty()) res.add(al2);
    }
    return res;
  }

  public static void printAl(ArrayList<Integer> al) {
    for (int i = 0; i < al.size(); i++) {
      System.out.print(al.get(i) + " ");
    }
    System.out.println();
  }

  public static void printAal(ArrayList<ArrayList<Integer>> aal) {
    for (int j = 0; j < aal.size(); j++) {
      ArrayList<Integer> al = aal.get(j);
      for (int i = 0; i < al.size(); i++) {
        System.out.print(al.get(i) + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    TreeNode a = new TreeNode(1);
    TreeNode b = new TreeNode(2);
    TreeNode c = new TreeNode(3);
    TreeNode d = new TreeNode(4);
    TreeNode e = new TreeNode(5);
    TreeNode f = new TreeNode(6);
    TreeNode g = new TreeNode(7);

    a.left = b;
    a.right = c;
    b.left = d;
    b.right = e;
    c.left = f;
    c.right = g;

    printAal(zigzagLevelOrder(a));
  }
}
