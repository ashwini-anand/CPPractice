import java.util.LinkedList;

public class LLReverseinGroup {
  class Node {
    int data;
    Node next;

    Node(int key) {
      data = key;
      next = null;
    }
  }

  static class RevResult {
    Node head;
    Node end;
    Node next;

    RevResult(Node h, Node e, Node n) {
      head = h;
      end = e;
      next = n;
    }
  }

  public static Node reverse(Node node, int k) {
    RevResult rr = reverseList3(node, k);
    Node y = null;
    if (rr.next != null) {
      y = reverse(rr.next, k);
    }
    rr.end.next = y;
    return rr.head;
  }

  public static RevResult reverseList(Node curr, int k) {
    Node end = curr;
    Node prev = null;
    int count = 0;
    while (curr != null && count < k) {
      count++;
      Node next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
    }
    RevResult rr = new RevResult(prev, end, curr);
    return rr;
  }

  public static RevResult reverseList2(Node curr, int k) {
    Node end = curr;
    int count = 0;
    if(curr == null) return new RevResult(null, null, null);
    LinkedList<Node> stack = new LinkedList<>();
    while (curr != null && count < k) {
      count++;
      stack.addFirst(curr);
      curr = curr.next;
    }
    Node prev = stack.removeFirst();
    Node head = prev;
    while(!stack.isEmpty()){
      Node nd = stack.removeFirst();
      prev.next = nd;
      prev = nd;
    }
    prev.next = null;
    RevResult rr = new RevResult(head, prev, curr);
    return rr;
  }

  //reverse list recursively
  public static Node reverseListRec(Node curr, int k) {
    if(curr.next== null || k==1) {
      return curr;
    }
    Node next = curr.next;
    Node rest = reverseListRec(curr.next, k-1);
    next.next = curr;
    curr.next = null;
    return rest;
  }

  public static RevResult reverseList3(Node curr, int k) {
    if(curr.next== null || k==1) {
      return new RevResult(curr, curr, curr.next);
    }
    Node next = curr.next;
    RevResult rv = reverseList3(curr.next, k-1);
    next.next = curr;
    curr.next = null;
    return new RevResult(rv.head, curr, rv.next);
  }

  public static void printLL(Node curr) {
    while (curr != null) {
      System.out.print(curr.data + " ");
      curr = curr.next;
    }
    System.out.println();
    System.out.println("done printing\n\n");
  }

  public static void main(String[] args) {
    Node nd1 = input1();
    printLL(nd1);

    Node res = reverse(nd1, 3);
    //RevResult rr = reverseList3(nd1, 6);


    //System.out.println(rr.head.data);

    printLL(res);

  }

  public static Node input2() {
    LLReverseinGroup llrvg = new LLReverseinGroup();
    Node nd1 = llrvg.new Node(8);
    Node nd2 = llrvg.new Node(5);

    nd1.next = nd2;
    return nd1;
  }

  public static Node input1() {
    LLReverseinGroup llrvg = new LLReverseinGroup();
    Node nd1 = llrvg.new Node(1);
    Node nd2 = llrvg.new Node(2);
    Node nd3 = llrvg.new Node(3);
    Node nd4 = llrvg.new Node(4);
    Node nd5 = llrvg.new Node(5);
    Node nd6 = llrvg.new Node(6);

    nd1.next = nd2;
    nd2.next = nd3;
    nd3.next = nd4;
    nd4.next = nd5;
    nd5.next = nd6;
    return nd1;
  }
}
