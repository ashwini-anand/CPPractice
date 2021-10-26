public class CountSubtreesWithSumX {
  class Node {
    int data;
    Node left, right;

    Node(int d) {
      data = d;
      left = right = null;
    }
  }

  int countSubtreesWithSumX(Node root, int x) {
    if (root == null) return 0;
    int[] leftSumAndCount = getSubtreeSum(root.left, x);
    int[] rightSumAndCount = getSubtreeSum(root.right, x);
    int totaltCount = leftSumAndCount[1]+rightSumAndCount[1];
    if (leftSumAndCount[0] + rightSumAndCount[0] + root.data == x) totaltCount++;
    return totaltCount;
  }

  int[] getSubtreeSum(Node nd, int x){
    if(nd == null) return new int[]{0,0};
    int[] leftSumAndCount = getSubtreeSum(nd.left, x);
    int[] rightSumAndCount = getSubtreeSum(nd.right, x);
    int subtreeSum = leftSumAndCount[0]+rightSumAndCount[0]+nd.data;
    int totaltCount = leftSumAndCount[1]+rightSumAndCount[1];
    if(subtreeSum == x) totaltCount++;
    return new int[]{subtreeSum, totaltCount};
  }

}
