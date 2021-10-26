import java.util.ArrayList;
import java.util.Collections;

public class RecoverBST {

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

  static int prevValue = Integer.MIN_VALUE;
  static int firstValue = Integer.MIN_VALUE;
  static int midValue = Integer.MIN_VALUE;
  static int lastValue = Integer.MIN_VALUE;

  static void inorder(TreeNode node) {
    if (node != null) {
      inorder(node.left);
      int currVal = node.val;
      if (firstValue == Integer.MIN_VALUE) {
        if (currVal < prevValue) {
          firstValue = prevValue;
          midValue = currVal;
        }
      } else {
        if (currVal < prevValue) {
          lastValue = currVal;
        }
      }
      prevValue = currVal;
      inorder(node.right);
    }
  }

  public static ArrayList<Integer> recoverTree(TreeNode A) {
    prevValue = Integer.MIN_VALUE;
    firstValue = Integer.MIN_VALUE;
    midValue = Integer.MIN_VALUE;
    lastValue = Integer.MIN_VALUE;
    inorder(A);
    int res1 = firstValue;
    int res2 = lastValue;
    if(lastValue == Integer.MIN_VALUE) res2 = midValue;
    ArrayList<Integer> resList = new ArrayList<>();
    resList.add(res1);
    resList.add(res2);
    Collections.sort(resList);
    return  resList;
  }

  public static void main(String[] args) {
    TreeNode a = new TreeNode(5);
    TreeNode b = new TreeNode(3);
    TreeNode c = new TreeNode(7);
    TreeNode d = new TreeNode(2);
    TreeNode e = new TreeNode(4);
    TreeNode f = new TreeNode(6);
    TreeNode g = new TreeNode(8);

    a.left = b;
    a.right = c;
    b.left = d;
    b.right = e;
    c.left = f;
    c.right = g;

    ArrayList<Integer> res = recoverTree(a);
    System.out.println(res.get(0)+" "+res.get(1));
  }
}
