import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class HotelBooking {
  static class Times{
    int time;
    boolean isArrival;
    Times(int t, boolean isA){
      time = t;
      isArrival = isA;
    }
  }

  static class SortOnTime implements Comparator<Times>{

    @Override
    public int compare(Times o1, Times o2) {
      if(o1.time != o2.time ) return o1.time - o2.time;
      else{
        if(!o1.isArrival) return -1;
        else return 1;
      }
    }
  }
  public static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
    Times[] timeArray = new Times[arrive.size() + depart.size()];
    for(int i=0; i< arrive.size(); i++){
      int t = arrive.get(i);
      Times time = new Times(t,true);
      timeArray[i] = time;
    }

    for(int i=0; i<depart.size(); i++){
      int t = depart.get(i);
      Times time = new Times(t, false);
      timeArray[arrive.size()+i] = time;
    }

    SortOnTime sot = new SortOnTime();
    Arrays.sort(timeArray, sot);

    boolean possible = true;
    for(int i=0; i<timeArray.length; i++){
      if(K <0 ){
        possible = false;
        break;
      }
      Times time = timeArray[i];
      if(time.isArrival) K--;
      else K++;
    }

    if(K < 0 || !possible) return false;
    else return true;
  }

  public static void main(String[] args) {
    ArrayList<Integer> listA = new ArrayList<>(Arrays.asList( 1, 2, 3  ));
    ArrayList<Integer> listB = new ArrayList<>(Arrays.asList(2, 3, 4));
    boolean res = hotel(listA,listB,1);
    System.out.println(res);
  }
}
