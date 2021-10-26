import java.util.LinkedList;

public class TwoSum {

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

  static LinkedList<TreeNode> incstack;
  static LinkedList<TreeNode> decstack;

  public static int t2Sum(TreeNode A, int B) {

    if (A == null) return 0;
    incstack = new LinkedList<>();
    TreeNode currNodeInc = A;
    incstack.addFirst(currNodeInc);
    while (currNodeInc.left != null) {
      currNodeInc = currNodeInc.left;
      incstack.addFirst(currNodeInc);
    }

    decstack = new LinkedList<>();
    TreeNode currNodeDec = A;
    decstack.addFirst(currNodeDec);
    while (currNodeDec.right != null) {
      currNodeDec = currNodeDec.right;
      decstack.addFirst(currNodeDec);
    }

    int incNextVal = getNextInInc();
    int decNextVal = getNextInDec();
    while (incNextVal != Integer.MIN_VALUE && decNextVal != Integer.MIN_VALUE && (incNextVal != decNextVal) && (incNextVal + decNextVal != B)) {
      if (incNextVal + decNextVal < B) {
        incNextVal = getNextInInc();
      } else {
        decNextVal = getNextInDec();
      }
    }
    if ((incNextVal + decNextVal == B) && (incNextVal != decNextVal)) {
      return 1;
    }
    else return 0;
  }

  public static int getNextInInc() {
    if(!incstack.isEmpty()){
      TreeNode node = incstack.removeFirst();
      if(node.right != null){
        TreeNode currNode = node.right;
        incstack.addFirst(currNode);
        while(currNode.left != null){
          currNode = currNode.left;
          incstack.addFirst(currNode);
        }
      }
      return node.val;
    }
    return Integer.MIN_VALUE;
  }

  public static int getNextInDec() {
    if(!decstack.isEmpty()){
      TreeNode node = decstack.removeFirst();
      if(node.left != null){
        TreeNode currNode = node.left;
        decstack.addFirst(currNode);
        while(currNode.right != null){
          currNode = currNode.right;
          decstack.addFirst(currNode);
        }
      }
      return node.val;
    }
    return Integer.MIN_VALUE;
  }

  public static void main(String[] args) {
    TreeNode a = new TreeNode(7);
    TreeNode b = new TreeNode(10);
    TreeNode c = new TreeNode(9);
    TreeNode d = new TreeNode(20);

    a.right = b;
    b.left = c;
    b.right = d;


    System.out.println(t2Sum(a, 40));
  }
}
