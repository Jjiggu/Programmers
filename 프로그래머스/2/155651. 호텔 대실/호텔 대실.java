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
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 0; i < n; i++) {
            int start = booking[i][0];
            int end = booking[i][1];

            if (!pq.isEmpty() && pq.peek() <= start) pq.poll(); 
            pq.offer(end + 10);
        }

        return pq.size();
    }
    
    private int timeToInt(String time) {
        String[] timeArr = time.split(":");
        return Integer.parseInt(timeArr[0]) * 60 + Integer.parseInt(timeArr[1]);
    }
}