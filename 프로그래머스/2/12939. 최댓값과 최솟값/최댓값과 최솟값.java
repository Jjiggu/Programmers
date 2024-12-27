import java.util.*;

class Solution {
    public String solution(String s) {       
        String[] nums = s.split(" ");
        int[] result = new int[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            result[i] = Integer.parseInt(nums[i]);
        }
        
        int minNum = 1000000;
        int maxNum = -1000000;
        
        for (int num : result) {
            minNum = Math.min(minNum, num);
            maxNum = Math.max(maxNum, num);
        }
        
        return minNum + " " + maxNum;
    }
}