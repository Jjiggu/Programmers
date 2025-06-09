import java.util.*;

class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int[] dx = {1, 0, 0, -1};             // d, l, r, u
        int[] dy = {0, -1, 1, 0};
        String[] direction = {"d", "l", "r", "u"};
        
        int dist = Math.abs(x - r) + Math.abs(y - c);
        if (dist > k || (k - dist) % 2 != 0) return "impossible";
        
        StringBuilder sb = new StringBuilder();
        
        for (int step = 0; step < k; step++) {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
                
                int remainDist = Math.abs(nx - r) + Math.abs(ny - c);
                int remainStep = k - step - 1;
                
                if (remainDist <= remainStep && (remainStep - remainDist) % 2 == 0) {
                    sb.append(direction[i]);
                    x = nx;
                    y = ny;
                    break;
                }
            }
        }
        
        return sb.toString();
    }
}
