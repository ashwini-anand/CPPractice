import java.util.LinkedList;

public class BSTIterator {

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

  LinkedList<TreeNode> stack;

  public BSTIterator(TreeNode root) {
    stack = new LinkedList<>();
    if(root != null){
      TreeNode currNode = root;
      stack.addFirst(currNode);
      while(currNode.left != null){
        currNode = currNode.left;
        stack.addFirst(currNode);
      }
    }
  }

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    return !stack.isEmpty();
  }

  /** @return the next smallest number */
  public int next() {
    TreeNode node = stack.removeFirst();
    if(node.right != null){
      TreeNode currNode = node.right;
      stack.addFirst(currNode);
      while(currNode.left != null){
        currNode = currNode.left;
        stack.addFirst(currNode);
      }
    }
    return node.val;
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

    BSTIterator bsti = new BSTIterator(a);

    while (bsti.hasNext()) System.out.print(bsti.next()+" ");
  }
}
