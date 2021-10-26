import java.math.BigInteger;
import java.sql.SQLException;
import java.util.*;

public class ConstructLargestNumber {

  static class CustomSort implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
      String o1String = o1.toString();
      String o2String = o2.toString();

      int o1Index = 0;
      int o2Index = 0;

      while (o1Index < o1String.length() && o2Index < o2String.length()) {
        if (o1String.charAt(o1Index) > o2String.charAt(o2Index)) {
          return -1;
        } else if (o1String.charAt(o1Index) < o2String.charAt(o2Index)) {
          return 1;
        } else {
          o1Index++;
          o2Index++;
          continue;
        }
      }
      if (o1Index == o1String.length() && o2Index == o2String.length()) return 1;
      if (o1Index == o1String.length()) {
        return (o2String.charAt(o2Index) > o2String.charAt(o2Index - 1) ? 1 : -1);
      } else {
        return (o1String.charAt(o1Index) > o1String.charAt(o1Index - 1) ? -1 : 1);
      }
    }
  }

  static class CustomSort1 implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
      String o1String = o1.toString();
      String o2String = o2.toString();
      BigInteger o1o2 = new BigInteger(o1String + o2String);
      BigInteger o2o1 = new BigInteger(o2String + o1String);
      return -(o1o2.compareTo(o2o1));
    }
  }

  static class CustomSort2 implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
      String o1String = o1.toString();
      String o2String = o2.toString();
      return (o2String + o1String).compareTo(o1String + o2String);
    }
  }

  public void xyx() throws SQLException, ArithmeticException, ArrayIndexOutOfBoundsException {
    int x = 0;
    if (x == 0) {
      throw new ArithmeticException();
    }
    else {
      try {
        throw new SQLException();
      } catch (SQLException e) {
        e.printStackTrace();
      } catch (ArithmeticException e) {

      }
    }

//    if (x == 1) {
//      try {
//        System.out.println("");
//      } catch (SQLException e) {
//
//      }
//    }
  }

  public static String largestNumber(final List<Integer> A) {
    CustomSort2 cs = new CustomSort2();
    Collections.sort(A, cs);
    String res = "";
    for (int i = 0; i < A.size(); i++) {
      res = res + A.get(i);
    }
    if (res.startsWith("0")) return "0";
    return res;
  }

  public static void main(String[] args) {
    ArrayList<Integer> listA = new ArrayList<>(Arrays.asList(12, 121));
    System.out.println(largestNumber(listA));
  }
}
