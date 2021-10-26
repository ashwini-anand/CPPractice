import java.util.ArrayList;
import java.util.LinkedList;

public class InorderIter {
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

  ArrayList<Integer> inOrder(Node root) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    LinkedList<Node> stack = new LinkedList<>();
    Node leftNode = null;
    if (root == null) return result;

    stack.addFirst(root);
    leftNode = root.left;

    while (!stack.isEmpty()) {

      while (leftNode != null) {
        stack.addFirst(leftNode);
        leftNode = leftNode.left;
      }

      Node top = stack.removeFirst();
      result.add(top.data);
      Node rightNode = top.right;
      if (rightNode != null) {
        stack.addFirst(rightNode);
        leftNode = rightNode.left;
      }
    }

    return result;
  }

  void somePracticeStuff(){
    int a = 2;
    int b= 6;
    int c = a & b;
    System.out.println(c);
  }
}
