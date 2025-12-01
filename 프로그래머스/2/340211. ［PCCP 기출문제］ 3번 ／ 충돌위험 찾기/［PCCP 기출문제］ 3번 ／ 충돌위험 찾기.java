import java.util.*;

class Solution {
    
    private static final int MAX = 100;
    Map<Integer, Integer>[][] timeMap = new HashMap[MAX + 1][MAX + 1];
    
    public int solution(int[][] points, int[][] routes) {
        initTimeMap();
        
        for (int[] route : routes) {
            simulateOneRobot(points, route);
        }
        
        int answer = 0;
        for (int r = 1; r <= MAX; r++) {
            for (int c = 1; c <= MAX; c++) {
                for (int cnt : timeMap[r][c].values()) {
                    if (cnt >= 2) answer++;
                }
            }
        }
        
        return answer;
    }
    
    private void simulateOneRobot(int[][] points, int[] route) {
        int t = 0;
        int startIdx = route[0] - 1;
        int x = points[startIdx][0];
        int y = points[startIdx][1];
        recordVisit(x, y, t);
        
        for (int i = 0; i < route.length - 1; i++) {
            int from = route[i] - 1;
            int to = route[i + 1] - 1;
            int tx = points[to][0];
            int ty = points[to][1];
            
            while (x != tx) {
                x += Integer.compare(tx, x);
                t++;
                recordVisit(x, y, t);
            }
            
            while (y != ty) {
                y += Integer.compare(ty, y);
                t++;
                recordVisit(x, y, t);
            }
        }
    }
    
    private void recordVisit(int r, int c, int t) {
        Map<Integer, Integer> m = timeMap[r][c];
        m.put(t, m.getOrDefault(t, 0) + 1);
    }
    
    private void initTimeMap() {
        for (int r = 1; r <= MAX; r++) {
            for (int c = 1; c <= MAX; c++) {
                timeMap[r][c] = new HashMap<>();
            }
        }
    }
}