public class PrintSubset {

  void printSubset(String input, String resStr, int idx){
    if(idx == input.length()){
      System.out.println(resStr);
      return;
    }
    String resStr1 = resStr + input.charAt(idx);
    printSubset(input, resStr1, idx+1);
    printSubset(input, resStr, idx+1);
  }

  public static void main(String[] args) {
    PrintSubset  ps = new PrintSubset();
    ps.printSubset("aaa", "", 0);
  }
}
