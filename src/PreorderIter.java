import java.util.ArrayList;
import java.util.LinkedList;

public class PreorderIter {

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

  ArrayList<Integer> preOrder(Node root)
  {
    ArrayList<Integer> res = new ArrayList<>();
    LinkedList<Node> stack = new LinkedList<>();
    if(root == null) return res;
    stack.addFirst(root);
    while(!stack.isEmpty()){
      Node nd = stack.removeFirst();
      res.add(nd.data);
      if(nd.right != null) stack.addFirst(nd.right);
      while(nd.left != null){
        nd = nd.left;
        res.add(nd.data);
        if(nd.right != null) stack.addFirst(nd.right);
      }
    }
    return res;
  }
}
