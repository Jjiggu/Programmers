class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        
        for (int i = 0; i < balls.length; i++) {
            answer[i] = calcDist(m, n, startX, startY, balls[i]);
        }
        
        return answer;
    }
    
    private int calcDist(int m, int n, int startX, int startY, int[] ball) {
        int bx = ball[0];
        int by = ball[1];
        long sx = startX;
        long sy = startY;
        long min = Long.MAX_VALUE;
        
        // 아래 바닥 반사 (bx, -by)
        if (!(startX == bx && startY > by)) {
            min = Math.min(min, squaredDust(sx, sy, bx, -by)); 
        }
        
        // 위 천장 반사 (bx, 2*n - by)
        if (!(startX == bx && startY < by)) {
            min = Math.min(min, squaredDust(sx, sy, bx, 2L * n - by));
        }
        
        // 왼쪽 벽 반사 (-bx, by)
        if (!(startY == by && startX > bx)) {
            min = Math.min(min, squaredDust(sx, sy, -bx, by));
        }
        
        // 오른쪽 벽 반사 
        if (!(startY == by && startX < bx)) {
            min = Math.min(min, squaredDust(sx, sy, 2L * m - bx, by));
        } 
        
        return (int)min;
    }
    
    private long squaredDust(long x1, long y1, long x2, long y2) {
        long dx = x1 - x2;
        long dy = y1 - y2;
        
        return dx * dx + dy * dy;
    }
}