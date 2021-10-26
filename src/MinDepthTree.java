public class MinDepthTree {
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

  public int minDepth(TreeNode A) {
    if( A == null) return 0;
    return getMinDepth(A,0);
  }

  public static int getMinDepth(TreeNode A, int depth){
    if( A.left == null && A.right == null) return depth+1;
    else{
      int resLeft = Integer.MAX_VALUE;
      int resRight = Integer.MAX_VALUE;
      if(A.left != null) resLeft = getMinDepth(A.left, depth+1);
      if(A.right != null) resRight = getMinDepth(A.right, depth +1);
      return Math.min(resLeft, resRight);
    }
  }
}
