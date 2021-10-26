//https://leetcode.com/problems/3sum-closest/
package Int2021;

import java.util.Arrays;

public class Closest3Sum {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int closestSum=Integer.MAX_VALUE;
    int diff = Integer.MAX_VALUE;
    boolean fullMatch = false;
    for(int i=0; i< nums.length; i++){
      int rem = target - nums[i];
      int l =i+1;
      int r = nums.length -1;
      while(l < r){
        int sum = nums[i] + nums[l] + nums[r];
        if(Math.abs(target - sum) < diff){
          diff = Math.abs(target - sum);
          closestSum = sum;
        }
        if(nums[l] + nums[r] > rem){
          r--;
        }else if(nums[l] + nums[r] < rem){
          l++;
        }else{
          fullMatch = true;
          break;
        }
      }
      if(fullMatch) break;
    }

    return closestSum;

  }
}
