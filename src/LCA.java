public class LCA {

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

  static boolean bExists = false;
  static boolean cExists = false;
  public static int lca(TreeNode A, int B, int C) {
    bExists = false;
    cExists = false;
    int res = getLCA(A,B,C);
    if(bExists && cExists){
      return res;
    }else {
      return -1;
    }
  }

  static int getLCA(TreeNode a, int B, int C){
    if(a == null) return -1;
    if(a.val == B) {
      bExists = true;
    }
    if(a.val == C) {
      cExists = true;
    }
    int leftLCA = getLCA(a.left, B, C);
    int rightLCA = getLCA(a.right, B, C);
    if(leftLCA != -1 && rightLCA != -1){
      return a.val;
    }else if(a.val == B || a.val == C){
      return a.val;
    }else{
      return (leftLCA == -1 ? rightLCA : leftLCA);
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

    System.out.println(lca(a,4,8));
  }
}
