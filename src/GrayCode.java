import java.util.ArrayList;

public class GrayCode {
  public static void main(String[] args) {
    GrayCode gc = new GrayCode();
    ArrayList<String> res = gc.graycode(3);
    for(int i=0; i < res.size(); i++){
      System.out.print(res.get(i)+" ");
    }
    System.out.println();
  }
  public ArrayList<String> graycode(int n) {
    ArrayList<String> straight = new ArrayList<>();
    ArrayList<String> reverse = new ArrayList<>();
    ArrayList<String> iterationResult = new ArrayList<>();
    straight.add("0"); straight.add("1");
    reverse = reverse(straight);
    if(n==0){
      return new ArrayList<>();
    }
    if(n == 1){
      return straight;
    }
    while(n >1){
      iterationResult.clear();
      iterationResult.addAll(createNewEntries(straight, "0"));
      iterationResult.addAll(createNewEntries(reverse, "1"));
      straight = new ArrayList<String>(iterationResult);
      reverse = reverse(straight);
      n--;
    }

    return iterationResult;
  }

  public ArrayList<String> createNewEntries(ArrayList<String> arrl, String prependString){
    ArrayList<String> newEntries = new ArrayList<>();
    for(int i=0; i< arrl.size(); i++){
      String entry = prependString + arrl.get(i);
      newEntries.add(entry);
    }
    return newEntries;
  }

  public ArrayList<String> reverse(ArrayList<String> arrl){
    ArrayList<String> reverse = new ArrayList<>();
    for(int i = arrl.size() -1 ; i >=0; i--){
      reverse.add(arrl.get(i));
    }
    return reverse;
  }
}
