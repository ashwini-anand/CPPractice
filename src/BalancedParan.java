import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class BalancedParan {
  public static void main (String[] args) {
    Scanner in = new Scanner(System.in);
    int t= in.nextInt();
    HashMap<Character, Character> hmap = new HashMap<>();
    hmap.put('(', ')');
    hmap.put('{', '}');
    hmap.put('[', ']');
    while(t-- >0){
      String exp = in.next();
      LinkedList<Character> stack = new LinkedList<>();
      boolean isBalanced= true;
      for(int i=0; i< exp.length(); i++){
        char c = exp.charAt(i);
        if(c == '{' || c == '(' || c== '[') stack.addFirst(c);
        else{
          if(stack.size() == 0) {
            //System.out.println("hhere1");
            isBalanced = false;
            break;
          }
          char top = stack.removeFirst();
          //System.out.println(top);
          if(c != hmap.get(top)) {
            //System.out.println("hhere2");
            isBalanced = false;
            break;
          }
        }
        //System.out.println("c= "+c+" stack="+stack);
      }
     // System.out.println("isbanalance= "+isBalanced+"  stack="+stack);
      if(!isBalanced || stack.size()!=0) System.out.println("not balanced");
      else System.out.println("balanced");
    }
  }
}
