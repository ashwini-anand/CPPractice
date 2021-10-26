import java.util.HashSet;

public class NodesAtKDist {

  static class Node {
    int data;
    Node left, right;

    Node(int d) {
      data = d;
      left = right = null;
    }
  }

  public static void main(String[] args) {
    Node root = getTree2();
    printkdistanceNode(root, root.right, 1);
  }

  static Node getTree1(){
    Node root = new Node(20);
    root.left = new Node(7);
    root.right = new Node(24);
    root.left.left = new Node(4);
    root.left.right = new Node(3);
    root.left.right.left = new Node(1);
    return root;
  }

  static Node getTree2(){
    Node root = new Node(15);
    root.left = new Node(8);
    root.right = new Node(17);
    root.right.left = new Node(16);
    return root;
  }

  public static int printkdistanceNode(Node root, Node target , int k)
  {
    HashSet<Node> hs = new HashSet<>();
    int dist = printkdistanceNode2(root, target, k, hs);
    //travelAndPrint(root, hs);
    return dist;
  }

  static void travelAndPrint(Node root, HashSet<Node> hs){
    if(root!=null){
      travelAndPrint(root.left, hs);
      travelAndPrint(root.right, hs);
      if(hs.contains(root)) System.out.print(root.data+" ");
    }
  }

  public static int printkdistanceNode2(Node root, Node target, int k, HashSet<Node> hs){

    if(root == null) return -1;
    if(root == target){
      printAllKDown(target,k, hs);
      return 1;
    }

    int dl = printkdistanceNode2(root.left, target, k, hs);
    if(dl > 0){
      if(dl == k){
        hs.add(root);
        System.out.print(root.data+" ");
      }else if(dl > k){

      }else{
        printAllKDown(root.right, k-dl-1, hs);
      }
      return dl+1;
    }

    int dr = printkdistanceNode2(root.right, target, k, hs);
    if(dr >0){
      if(dr == k){
        hs.add(root);
        System.out.print(root.data+" ");
      }else if(dr >k){

      }else{
        printAllKDown(root.left, k-dr-1, hs);
      }
      return dr+1;
    }

    return dr;

  }

  static void printAllKDown(Node node, int k, HashSet<Node> hs){
    if(node == null) return;
    if( k == 0){
      hs.add(node);
      System.out.print(node.data+" ");
      return;
    }else{
      printAllKDown(node.left, k-1, hs);
      printAllKDown(node.right, k-1, hs);
    }
  }
}
