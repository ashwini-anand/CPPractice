import java.util.ArrayList;

public class FibTailRec {

  private int calcFib(int n) {
    if (n == 0) return 0;
    if (n == 1) return 1;
    if (n == 2) return 2;
    int rres = calcFib(n - 1) + calcFib(n - 2);
    return rres;
  }

  private int fact(int n) {
    if (n == 0) return 1;
    if (n == 1) return 1;
    if (n == 2) return 2;
    int res = n * fact(n - 1);
    return res;
  }

  private int factTail(int n, int acc) {
    if (n == 1) return acc;
    return factTail(n - 1, n * acc);
  }

  private int factTail2(int curr, int acc, int n) {
    if (curr == n) return acc * n;
    return factTail2(curr + 1, acc * curr, n);
  }

  int calcFibTail(int curr, int a, int b, int n) {
    if (curr == n) return a + b;
    return calcFibTail(curr + 1, b, a + b, n);
  }

  public static void main(String[] args) {
    FibTailRec fb =new FibTailRec();
    System.out.println();
    System.out.println("printint facts");
    System.out.println(fb.fact(5));
    System.out.println(fb.factTail2(1,1,5));
    System.out.println("printing fibs");
    System.out.println(fb.calcFib(5));
    System.out.println(fb.calcFibTail(1,0,1,5));
    fb.func1();
  }

  class ABC{
    private void f2(){
      System.out.println();
    }
    protected int f1(){
      return 1;
    }
  }

  class BCD extends ABC{
    @Override
    public int f1(){
      return 1;
    }
  }

  void func1(){
    BCD  bcd = new FibTailRec.BCD();
    String s1 ="bacd";
    s1.length();
    ArrayList<Integer> alist = new ArrayList<>();
    if(alist == null){
      alist = new ArrayList<>();
    }
    alist.add(1);
    bcd.f1();
    String str = "23280666176668";
  }
}
