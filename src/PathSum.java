import java.util.ArrayList;

public class PathSum {

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

  static ArrayList<ArrayList<Integer>> res;

  public static ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
    res = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> al = new ArrayList<Integer>();
    getRes(al, A, B);
    return res;
  }

  public static void getRes(ArrayList<Integer> al , TreeNode nd, int residual){
    int newResidual = residual - nd.val;
    al.add(nd.val);
    if(isLeaf(nd) && newResidual == 0) {
      printAl(al);
      res.add(al);
      return;
    }
    if(newResidual < 0) return;
    if(nd.left != null) getRes(new ArrayList<>(al), nd.left, newResidual);
    if(nd.right != null) getRes(new ArrayList<>(al),nd.right, newResidual);
  }

  public static boolean isLeaf(TreeNode a){
    return a.left == null && a.right == null;
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

  public static void printAl(ArrayList<Integer> al) {
    for (int i = 0; i < al.size(); i++) {
      System.out.print(al.get(i) + " ");
    }
    System.out.println();
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

    printAal(pathSum(a,8));
  }
}
