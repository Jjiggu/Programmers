import java.util.*;

class Solution {
    
    private static final int MAX = 100;
    Map<Integer, Integer>[][] timeMap = new HashMap[MAX + 1][MAX + 1];
    
    public int solution(int[][] points, int[][] routes) {
        initTimeMap();
        
        for (int[] route : routes) simulateRobot(points, route);
        
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
    
    private void simulateRobot(int[][] points, int[] route) {
        int time = 0;
        int startPoint = route[0] - 1;
        int x = points[startPoint][0];
        int y = points[startPoint][1];
        mark(x, y, time);
        
        for (int i = 0; i < route.length - 1; i++) {
            int from = route[i] - 1;
            int to = route[i + 1] - 1;
            int tx = points[to][0];
            int ty = points[to][1];
            
            while (x != tx) {
                x += Integer.compare(tx, x); 
                time++;
                mark(x, y, time);
            }
            
            while (y != ty) {
                y += Integer.compare(ty, y); 
                time++;
                mark(x, y, time);
            }
        }
    }
    
    private void mark(int x, int y, int time) {
        Map<Integer, Integer> map = timeMap[x][y];
        map.put(time, map.getOrDefault(time, 0) + 1);
    }
    
    private void initTimeMap() {
        for (int r = 0; r <= MAX; r++) {
            for (int c = 0; c <= MAX; c++) {
                timeMap[r][c] = new HashMap<>();
            }
        }
    }
}