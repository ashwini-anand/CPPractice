import java.util.*;

public class StringPermutation {
  static HashSet<String>resSet;
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();
    while(t-- > 0){
      resSet = new HashSet<>();
      String str = in.next();
      if(str.length() ==0) {
        System.out.println("");
        continue;
      }
      char[] carr = str.toCharArray();
      for(int i=0; i< carr.length; i++){
        swap(carr, 0,i);
        permute(carr, 1, carr.length);
        swap(carr,0,i);
      }
      String[] resArray = new String[resSet.size()];
      int ii=0;
      for(String ss: resSet){
        resArray[ii] = ss;
        ii++;
      }
      Arrays.sort(resArray);
      for(String r: resArray){
        System.out.print(r+" ");
      }
      System.out.println();
    }
  }

  public static void permute(char[] carr, int idx, int len){
    if(idx == len) {
      resSet.add(String.valueOf(carr));
    }
    for(int i=idx; i< carr.length; i++){
      swap(carr,i, idx);
      permute(carr, idx+1, len);
      swap(carr, i, idx);
    }
  }

  public static void swap(char[] carr, int idx1, int idx2){
    char tmp1 = carr[idx2];
    carr[idx2] = carr[idx1];
    carr[idx1] = tmp1;
  }

  void andnd(){
    ArrayList<ArrayList<Integer>> A;
    //A.get(0).get(0);
  }
}
