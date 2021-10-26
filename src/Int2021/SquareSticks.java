package Int2021;

public class SquareSticks {
  public int solution(int A, int B) {
    int small = Math.min(A,B);
    int large = Math.max(A,B);
    int start = large/2 +1;
    int end = small/2 - 1;
    if(small <= 2) end =1;
    if(large <= 2) start =1;
    System.out.println(small+" "+large);
    System.out.println(start+" "+end);
    for(int i=start; i>=end; i--){
      if(isSquarePossible(small, large, i)){
        return i;
      }
    }
    return 0;
  }

  boolean isSquarePossible(int p1, int p2, int len){
    int count =0;
    if(len == 7){
      System.out.println(p1+" "+p2);
    }
    while(p1 >0){
      p1 = p1-len;
      if(p1 > 0) count++;
      if(count >= 4) break;
    }

    if(count >= 4) return true;

    while(p2 >0){
      p2 = p2-len;
      if(p2 > 0) count++;
      if(count >= 4) break;
    }

    if(count >= 4) return true;
    else return false;
  }

  public static void main(String[] args) {
    SquareSticks ss = new SquareSticks();
    int res = ss.solution(10,21);
    System.out.println(res);
  }
}
