public class MaxDepthTree {

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

  public int maxDepth(TreeNode A) {
    return getDepth(A,0);
  }

  public static int getDepth(TreeNode A, int depth){
    char[] abc = "".toCharArray();
    if( A == null) return depth;
    else{
      return Math.max(getDepth(A.left, depth+1), getDepth(A.right, depth + 1));
    }
  }
}
