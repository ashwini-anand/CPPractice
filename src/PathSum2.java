public class PathSum2 {
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

  static int target;

  public static int hasPathSum(TreeNode A, int B) {
    target = B;
    if (A == null && B != 0) return 0;
    if (A == null && B == 0) return 1;

    if (dfs(A, 0)) {
      return 1;
    }
    return 0;
  }

  public static boolean dfs(TreeNode node, int sum) {
    int newSum = sum + node.val;
    if (node.left == null && node.right == null) {
      if (newSum == target) return true;
      else return false;
    } else {
      boolean lres = false;
      boolean rres = false;
      if (node.left != null) lres = dfs(node.left, newSum);
      if (node.right != null) rres = dfs(node.right, newSum);
      return lres || rres;
    }
  }
}
