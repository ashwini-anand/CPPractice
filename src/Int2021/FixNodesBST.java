package Int2021;

public class FixNodesBST {

  static class Node {
    int data;
    Node left;
    Node right;

    public Node(int d){
      this.data = d;
    }
    public void setChild(Node l, Node r){
      this.left = l;
      this.right = r;
    }
  }

  static class ResultBox {
    Node first = null;
    Node second = null;

    public void setFirst(Node n) {
      this.first = n;
    }

    public void setSecond(Node n) {
      this.second = n;
    }

    void print(){
      System.out.println("first "+first.data+", second "+second.data);
    }
  }

  static class PrevBox{
    Node prev;
  }

  //Function to fix a given BST where two nodes are swapped.
  public Node correctBST(Node root) {
    ResultBox rb = new ResultBox();
    PrevBox prevBox = new PrevBox();
    getRes(root, prevBox, rb);
    rb.print();
    int t = rb.first.data;
    rb.first.data = rb.second.data;
    rb.second.data = t;
    return root;
  }

  public void getRes(Node nd, PrevBox prevBox, ResultBox rb) {
    if (nd == null) return;
    getRes(nd.left, prevBox, rb);
    int p = -1;
    if(prevBox.prev != null) p = prevBox.prev.data;
    //System.out.println("prev "+p+", current "+nd.data);
    if (prevBox.prev != null) {
      if (prevBox.prev.data > nd.data) {
        if (rb.first != null) {
          rb.second = nd;
        } else {
          rb.first = prevBox.prev;
          rb.second = nd;
        }
      }
    }
    prevBox.prev = nd;
    getRes(nd.right, prevBox, rb);
  }

  public static void main(String[] args) {
    Node n1 = new Node(10);
    Node n2 = new Node(5);
    Node n3 = new Node(8);
    Node n4 = new Node(2);
    Node n5 = new Node(20);
    n1.setChild(n2, n3);
    n2.setChild(n4, n5);
    FixNodesBST fbst = new FixNodesBST();
    fbst.correctBST(n1);
  }
}
