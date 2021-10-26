import java.util.LinkedList;
import java.util.List;

public class Threepalindromes {

  static LinkedList<String> result;

  public static List<String> threePalindromicSubstrings(String word) {
    // Write your code here
    result = new LinkedList<>();
    for (int i = 0; i < word.length(); i++) {
      String subStr = word.substring(0, i + 1);
      if (isPalindrome(subStr)) {
        getPalindromeRes(word, i + 1);
        if (result.size() == 2) {
          result.addFirst(subStr);
          break;
        }
      }
    }
    if (result.size() == 3) {
      return result;
    }
    LinkedList<String> impossibleResult = new LinkedList<>();
    impossibleResult.add("Impossible");
    return impossibleResult;
  }

  public static void getPalindromeRes(String word, int start) {
    for (int i = start; i < word.length(); i++) {
      String subStr = word.substring(start, i + 1);
      String subStr2 = word.substring(i + 1, word.length());
      if (isPalindrome(subStr) && isPalindrome(subStr2)) {
        result.addFirst(subStr2);
        result.addFirst(subStr);
        break;
      }
    }
  }

  public static boolean isPalindrome(String subWord) {
    int i = 0;
    int j = subWord.length() - 1;
    boolean isPalin = true;
    while (i <= j) {
      if (subWord.charAt(i) != subWord.charAt(j)) {
        isPalin = false;
        break;
      }
      i++;
      j--;
    }
    return isPalin;
  }

  public static void main(String[] args) {
    List<String> res = threePalindromicSubstrings("madamciviclevel");
    for (String str : res) {
      System.out.println(str);
    }
  }

  public static void printList(List<String> l) {
    for (String str : l) {
      System.out.println(str);
    }
  }
}
