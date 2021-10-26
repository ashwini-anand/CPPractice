import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GenerateAllParanthesis {

  public static void main(String[] args) {
    GenerateAllParanthesis gap = new GenerateAllParanthesis();
    List<String> res = gap.AllParenthesis(3);
    for(String str: res){
      System.out.println(str);
    }
  }
  public List<String> AllParenthesis(int n)
  {
    ArrayList<String> paranList;
    paranList = new ArrayList<>();
    int countOp =0;
    int countClose = 0;
    generateAllParanthesis(2*n, "", paranList, countOp, countClose,  2*n);
    return paranList;
  }

  public void generateAllParanthesis(int n, String str, ArrayList<String> paranList, int countOp, int countClose, int initialN){
    if(n == 0){
      if(isValidParanthesis(str)) {
        paranList.add(str);
        return;
      }
      else return;
    }
    if(countOp > initialN/2 || countClose > initialN/2) {
      return;
    }
    String str1 = str+")";
    String str2 = str+"(";
    generateAllParanthesis(n-1, str1, paranList, countOp, countClose+1, initialN);
    generateAllParanthesis(n-1, str2, paranList, countOp+1, countClose, initialN);
  }

  public boolean isValidParanthesis(String paranthesis){
    LinkedList<Character> paranStack = new LinkedList<>();
    for(Character c: paranthesis.toCharArray()){
      if(c == '(') paranStack.addFirst(c);
      else{
        if(paranStack.isEmpty() || paranStack.getFirst() != '(') return false;
        else paranStack.removeFirst();
      }
    }
    return paranStack.isEmpty();
  }
}
