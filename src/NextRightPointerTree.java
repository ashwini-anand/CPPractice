import java.util.LinkedList;

public class NextRightPointerTree {

  static class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
      val = x;
      left = null;
      right = null;
      next = null;
    }
  }

  static class QueueEntry {
    TreeLinkNode node;
    int level = -1;
    QueueEntry(TreeLinkNode nd, int l){
      node = nd;
      level = l;
    }
  }
  public static void connect(TreeLinkNode root) {
    if(root != null){
      connectNodes(root);
    }
  }

  static LinkedList<QueueEntry> queue;
  public static void connectNodes(TreeLinkNode root) {
    queue = new LinkedList<>();
    queue.addFirst(new QueueEntry(root, 0));
    while(!queue.isEmpty()){
      QueueEntry qe = queue.removeLast();
      int currLevel = qe.level;
      if(!queue.isEmpty()){
        QueueEntry nextQe = queue.peekLast();
        if(nextQe.level == qe.level) qe.node.next = nextQe.node;
        else qe.node.next = null;
      }else {
        qe.node.next = null;
      }
      if(qe.node.left != null) queue.addFirst(new QueueEntry(qe.node.left, currLevel+1));
      if(qe.node.right != null) queue.addFirst(new QueueEntry(qe.node.right, currLevel+1));
    }
  }
}
