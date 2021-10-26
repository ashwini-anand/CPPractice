public class MirrorTree {

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

  void mirror(Node node) {
    if (node.left != null) mirror(node.left);
    if (node.right != null) mirror(node.right);
    Node left = node.left;
    Node right = node.right;
    node.left = right;
    node.right = left;
  }
}
