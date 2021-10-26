
public class SumTree {

  class Node {
    int data;
    Node left, right;

    Node(int item) {
      data = item;
      left = right = null;
    }
  }

  static class Result {
    Result(boolean isCST, double s) {
      this.isChildASumTree = isCST;
      this.sum = s;
    }

    boolean isChildASumTree;
    double sum;
  }

  boolean isSumTree(Node root) {
    if (root == null) return true;
    if (root.left == null && root.right == null) return true;
    Result leftSum = getSum(root.left);
    Result rightSum = getSum(root.right);
    if (leftSum.isChildASumTree == true && rightSum.isChildASumTree) {
      if ((leftSum.sum + rightSum.sum) == root.data) return true;
    }
    return false;
  }

  Result getSum(Node root) {
    if (root == null) return new Result(true, 0);
    if (root.left == null && root.right == null) return new Result(true, root.data);
    Result leftSum = getSum(root.left);
    Result rightSum = getSum(root.right);
    if (leftSum.isChildASumTree == true && rightSum.isChildASumTree) {
      if ((leftSum.sum + rightSum.sum) == root.data) return new Result(true, leftSum.sum + rightSum.sum + root.data);
    }
    return new Result(false, -1);
  }
}
