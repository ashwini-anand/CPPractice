import java.util.*;
import java.lang.*;
import java.io.*;

class CountPalindrome {
  public static void main (String[] args) {
    Scanner in = new Scanner(System.in);
    int t = in.nextInt();

    while(t-- >0){
      int n = in.nextInt();
      String str = in.next();
      int count =0;
      for(int i=0; i<n; i++){
        for(int j=i+1; j<n; j++){
          if(isPalin(i,j,str)){
            count++;
          }
        }
      }
      System.out.println(count);
    }
  }

  static boolean isPalin(int i, int j, String str){
    boolean isPalindrome = true;
    while(i <= j){
      if(str.charAt(i) != str.charAt(j)){
        isPalindrome = false;
        break;
      }else{
        i++;
        j--;
      }
    }
    return isPalindrome;
  }
}