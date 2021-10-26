//Accepted: https://leetcode.com/problems/all-elements-in-two-binary-search-trees/submissions/
package Int2021;

import java.util.*;

public class MergeBST {

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }

  public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
    LinkedList<TreeNode> s1 = new LinkedList<>();
    LinkedList<TreeNode> s2 = new LinkedList<>();
    LinkedList<Integer> res = new LinkedList<>();

    TreeNode curr1 = root1;
    TreeNode curr2 = root2;
    while (curr1 != null) {
      s1.addFirst(curr1);
      curr1 = curr1.left;
    }
    while (curr2 != null) {
      s2.addFirst(curr2);
      curr2 = curr2.left;
    }

    if (!s1.isEmpty()) curr1 = s1.removeFirst();
    if (!s2.isEmpty()) curr2 = s2.removeFirst();
    while (curr1 != null || curr2 != null) {
      if (curr2 == null || (curr1 != null && curr1.val < curr2.val)) {
        res.add(curr1.val);
        curr1 = getNext(s1, curr1);
      } else {
        res.add(curr2.val);
        curr2 = getNext(s2, curr2);
      }
    }
    return res;
  }

  public TreeNode getNext(LinkedList<TreeNode> stack, TreeNode node) {
    TreeNode tr = node.right;
    while (tr != null) {
      stack.addFirst(tr);
      tr = tr.left;
    }
    node = null;
    if (!stack.isEmpty()) {
      node = stack.removeFirst();
    }
    return node;
  }
}
