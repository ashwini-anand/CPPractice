import java.util.HashMap;

public class NumOfSubtreeWithSumX {

  class Node {
    int data;
    Node left, right;

    Node(int d) {
      data = d;
      left = right = null;
    }
  }

  static class CountAndSum {
    int count;
    int sum;
  }

  public static void main(String[] args) {
    int arr[] = {1,2,3,4};
    printAllSUbsets(arr);
  }

  public static void printAllSUbsets(int[] arr){
    for(int i=0 ; i< (1 << arr.length);i++){
      for(int j=0;j<arr.length;j++){
        boolean jPartofSubset = (i & (1 <<j)) == 0 ? false: true;
        if(jPartofSubset){
          System.out.print(arr[j]+",");
        }
      }
      System.out.println();
    }
  }
  int countSubtreesWithSumX(Node root, int x) {
    CountAndSum cs = getRes(root,x);
    return  cs.count;
  }

  CountAndSum getRes(Node nd, int x){
    if(nd == null){
      CountAndSum cs = new CountAndSum();
      cs.count =0;
      cs.sum =0;
      return cs;
    }
    CountAndSum csl = getRes(nd.left,x);
    CountAndSum csr = getRes(nd.right,x);
    int resCount = csl.count + csr.count;
    int resSum = csl.sum + csr.sum + nd.data;
    if(resSum == x) {
      resCount++;
    }
    CountAndSum cs = new CountAndSum();
    cs.count=resCount;
    cs.sum = resSum;
    return cs;
  }
}
