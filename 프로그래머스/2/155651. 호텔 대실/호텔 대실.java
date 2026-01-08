import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int MAX_TIME = 1451;
        int[] prefixSum = new int[MAX_TIME];
        
        for (String[] time : book_time) {
            int start = timeToInt(time[0]);
            int end = timeToInt(time[1]) + 10;
            prefixSum[start] += 1;
            prefixSum[end] -= 1;
        }
        
        int answer = 0;
        for (int i = 1; i < MAX_TIME; i++) {
            prefixSum[i] += prefixSum[i - 1];
            answer = Math.max(answer, prefixSum[i]);
        }
        
        return answer;
    }
    
    private int timeToInt(String time) {
        String[] timeArr = time.split(":");
        return Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
    }
}