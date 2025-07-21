import java.util.*;

class Solution {
    int N;
    int[] dx = {0, 1, -1, 0, 0};
    int[] dy = {0, 0, 0, 1, -1};
    
    public int solution(int[][] clockHands) {
        N = clockHands.length;
        int minMoves = Integer.MAX_VALUE;
        int maxComb = (int) Math.pow(4, N);
        
        for (int comb = 0; comb < maxComb; comb++) {
            int[][] b = new int[N][N];
            for (int i = 0; i < N; i++) {
                System.arraycopy(clockHands[i], 0, b[i], 0, N);
            }
            
            int moves = 0;
            int tmp = comb;
            for (int c = 0; c < N; c++) {
                int t = tmp & 3;
                tmp >>>= 2;
                if (t > 0) {
                    moves += t;
                    rotate(b, 0, c, t);
                }
            }
            if (moves >= minMoves) continue;
            
            boolean ok = true;
            for (int r = 1; r < N && ok; r++) {
                for (int c = 0; c < N; c++) {
                    int need = (4 - b[r-1][c]) % 4;
                    if (need > 0) {
                        moves += need;
                        if (moves >= minMoves) { ok = false; break; }
                        rotate(b, r, c, need);
                    }
                }
            }
            if (!ok) continue;
            
            for (int c = 0; c < N; c++) {
                if (b[N-1][c] != 0) { ok = false; break; }
            }
            if (ok) minMoves = moves;
        }
        return minMoves == Integer.MAX_VALUE ? -1 : minMoves;
    }
    
    private void rotate(int[][] b, int r, int c, int t) {
        for (int i = 0; i < 5; i++) {
            int nr = r + dx[i], nc = c + dy[i];
            if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
                b[nr][nc] = (b[nr][nc] + t) % 4;
            }
        }
    }
}