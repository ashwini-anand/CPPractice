public class ConstructTreeFromPreOrder {
  class Node {
    int data;
    Node left, right;

    Node(int d) {
      data = d;
      left = right = null;
    }
  }

  Node constructTree(int n, int pre[], char preLN[]) {
    if (n == 0) return null;
    if (n == 1) return new Node(pre[0]);
    else {
      Node rt = new Node(pre[0]);
      rt.left = new Node(pre[1]);
      int rightPtr = makeTree(rt.left, 1, pre, preLN);
      rt.right = new Node(pre[rightPtr + 1]);
      makeTree(rt.right, rightPtr + 1, pre, preLN);
      return rt;
    }

  }

  int makeTree(Node rt, int currPtr, int[] pre, char[] preLN) {
    if (preLN[currPtr] == 'L') return currPtr;
    rt.left = new Node(pre[currPtr + 1]);
    int nextPtr = makeTree(rt.left, currPtr + 1, pre, preLN);
    rt.right = new Node(pre[nextPtr + 1]);
    int endPtr = makeTree(rt.right, nextPtr + 1, pre, preLN);
    return endPtr;
  }
}
