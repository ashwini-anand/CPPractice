import java.util.*;

public class MinimumPlatforms {
  static class Timing {
    int trainTime;
    boolean isArrival;

    public Timing(int trainTime, boolean isArrival) {
      this.trainTime = trainTime;
      this.isArrival = isArrival;
    }
  }

  static class TimeSort implements Comparator<Timing> {

    @Override
    public int compare(Timing o1, Timing o2) {
      return o1.trainTime - o2.trainTime;
    }
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();


    while (t-- > 0) {
      int n = in.nextInt();
      Timing[] arrival = new Timing[n];
      Timing[] departure = new Timing[n];

      for (int i = 0; i < n; i++) {
        int arr = in.nextInt();
        arrival[i] = new Timing(arr, true);
      }

      for (int i = 0; i < n; i++) {
        int dep = in.nextInt();
        departure[i] = new Timing(dep, false);
      }

      int res = getRes(arrival, departure);
      System.out.println(res);
    }
  }

  static int getRes(Timing[] arrival, Timing[] departure) {
    int combLen = arrival.length + departure.length;
    Timing[] combi = new Timing[combLen];
    System.arraycopy(arrival, 0, combi, 0, arrival.length);
    System.arraycopy(departure, 0, combi, arrival.length, departure.length);

    Arrays.sort(combi, new TimeSort());

    int count = 0;
    int res = 0;
    for (int i = 0; i < combLen; i++) {
      if (combi[i].isArrival) {
        count++;
        if (count > res) res = count;
      } else {
        count--;
      }
    }

    return res;
  }
}
