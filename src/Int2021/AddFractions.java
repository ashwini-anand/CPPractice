package Int2021;

import java.util.regex.Pattern;

public class AddFractions {
  String[] addingFractions(String[] fractions) {
    String res[] = new String[fractions.length];
    for(int i=0; i< fractions.length; i++){
      String fracts[] = fractions[i].split("\\+");

      String fract1[] = fracts[0].split("/");
      String fract2[] = fracts[0].split("/");
      //System.out.println(fracts[0]);
      String currres = getRes(Integer.parseInt(fract1[0]), Integer.parseInt(fract1[1]), Integer.parseInt(fract2[0]), Integer.parseInt(fract2[1]));
      res[i] = currres;
    }
    return res;
  }

  String getRes(int n1, int d1, int n2, int d2){
    System.out.println(n1+" "+d1+" "+n2+" "+d2);
    int resDen = (d1*d2)/getGcd(d1,d2);
    int x1 = (n1*(resDen/d1));
    int x2 = (n2*(resDen/d2));
    int resNum = (n1*(resDen/d1)) + (n2*(resDen/d2));
    //System.out.println(resDen);
    //System.out.println(resNum);
    return reduce(resNum, resDen);
  }

  int getGcd(int n1, int n2){
    if(n1==0) return n2;
    return getGcd(n2%n1, n1);
  }

  String reduce(int n, int d){
    int gcd = getGcd(n,d);
    n = n/gcd;
    d = d/gcd;
    return n+"/"+d;
  }

  public static void main(String[] args) {
    AddFractions ad = new AddFractions();
    String res[] = ad.addingFractions(new String[]{"7/10+13/10"});
    System.out.println(res[0]);
  }
}
