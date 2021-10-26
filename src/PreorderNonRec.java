import java.util.ArrayList;
import java.util.LinkedList;


class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
    left = null;
    right = null;
  }
}

public class PreorderNonRec {

  public ArrayList<Integer> preorderTraversal(TreeNode A) {
    ArrayList<Integer> arrl = new ArrayList<>();

    LinkedList<TreeNode> stack = new LinkedList<>();
    TreeNode node = A;
    while (true) {
      if (node != null) {
        stack.addFirst(node);
        arrl.add(node.val);
        node = node.left;
      } else {
        if (stack.size() > 0) {
          node = stack.removeFirst().right;
        } else {
          break;
        }
      }
    }
    return arrl;
  }

}
