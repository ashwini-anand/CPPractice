public class TreeMaxPathSum {
  static class Node {
    int data;
    Node left;
    Node right;

    Node(int x) {
      data = x;
      left = null;
      right = null;
    }
  }

  static int maxSum;
  int maxPathSum(Node root)
  {
    maxSum = Integer.MIN_VALUE;
    if(root == null) return 0;
    pathSum(root);
    return maxSum;
  }

  int pathSum(Node root){
    if(root == null) return 0;
    int leftSum = pathSum(root.left);
    int rightSum = pathSum(root.right);
    int sum = leftSum + root.data + rightSum;
    if( root.left != null && root.right != null && sum > maxSum) maxSum = sum;
    if(root.right == null) return leftSum+root.data;
    else if(root.left == null) return rightSum+root.data;
    else if(leftSum > rightSum) return leftSum+root.data;
    else return  rightSum+ root.data;
  }
}
