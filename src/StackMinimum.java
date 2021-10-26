import java.util.Stack;

public class StackMinimum {
  int minEle;
  Stack<Integer> s = new Stack<Integer>();

  /*returns min element from stack*/
  int getMin() {
    if (s.isEmpty()) return -1;
    else return minEle;
  }

  /*returns poped element from stack*/
  int pop() {
    if (s.isEmpty()) return -1;
    int top = s.pop();
    if (top < minEle) {
      int curr = minEle;
      minEle = 2 * minEle - top;
      return curr;
    }
    return top;
  }

  /*push element x into the stack*/
  void push(int x) {
    if (s.isEmpty()) {
      minEle = x;
    }
    if (x < minEle) {
      int t = 2 * x - minEle;
      minEle = x;
      s.push(t);
    } else {
      s.push(x);
    }
  }
}
