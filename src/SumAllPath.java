import java.util.ArrayList;

public class SumAllPath {

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

  static ArrayList<Integer> resList;

  public int sumNumbers(TreeNode A) {
    resList = new ArrayList<Integer>();
    if (A == null) return 0;
    getResList(A, "0");
    int sum = 0;
    for (int i = 0; i < resList.size(); i++) {
      sum = (sum + resList.get(i)) % 1003;
    }
    return sum;
  }

  public static void getResList(TreeNode a, String path) {
    String newPath = Integer.toString((Integer.parseInt(path + Integer.toString(a.val))) % 1003);

    if (isLeaf(a)) {
      resList.add(Integer.parseInt(newPath));
      return;
    }
    if (a.left != null) getResList(a.left, newPath);
    if (a.right != null) getResList(a.right, newPath);
  }

  public static boolean isLeaf(TreeNode td) {
    if (td.left == null && td.right == null) return true;
    return false;
  }
}
