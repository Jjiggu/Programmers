import java.util.*;

class Solution {
    public String solution(String s) {      
        String[] arr = s.split(" ");
        int[] nums = new int[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        
        Arrays.sort(nums);
        
        return nums[0] + " " + nums[nums.length - 1];
    }
}