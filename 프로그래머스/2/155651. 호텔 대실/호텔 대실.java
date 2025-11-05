import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int n = book_time.length;
        int[][] booking = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            booking[i][0] = timeToInt(book_time[i][0]);
            booking[i][1] = timeToInt(book_time[i][1]);
        }
        
        Arrays.sort(booking, (o1, o2) -> o1[0] - o2[0]);
        
        
        int[] timeTable = new int[60 * 24 + 11];
        
        for (int[] book : booking) {
            int start = book[0];
            int end = book[1] + 10;
            if (end >= timeTable.length) end = 60 * 24;
            timeTable[start] += 1;
            timeTable[end] -= 1;
        }
        
        for (int i = 1; i < timeTable.length; i++) {
            timeTable[i] += timeTable[i - 1];
        }
        
        return Arrays.stream(timeTable).max().getAsInt();
    }
    
    private int timeToInt(String time) {
        String[] timeArr = time.split(":");
        return Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
    }
}