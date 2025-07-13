import java.util.*;

class Solution {
    static class State {
        int rPos, bPos;
        int rMask, bMask;
        int dist;
        State(int rPos, int bPos, int rMask, int bMask, int dist) {
            this.rPos = rPos;
            this.bPos = bPos;
            this.rMask = rMask;
            this.bMask = bMask;
            this.dist = dist;
        }
    }
    
    public int solution(int[][] maze) {
        int n = maze.length, m = maze[0].length;
        int redStart=0, blueStart=0, redGoal=0, blueGoal=0;
        boolean[] wall = new boolean[n*m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int idx = i*m + j;
                switch (maze[i][j]) {
                    case 1: redStart = idx; break;
                    case 2: blueStart = idx; break;
                    case 3: redGoal  = idx; break;
                    case 4: blueGoal = idx; break;
                    case 5: wall[idx] = true; break;
                }
            }
        }
        
        int initRmask = 1 << redStart;
        int initBmask = 1 << blueStart;
        Queue<State> q = new ArrayDeque<>();
        Set<Long> seen = new HashSet<>();
        
        State init = new State(redStart, blueStart, initRmask, initBmask, 0);
        q.add(init);
        seen.add(encode(init));
        
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = {  0, 0, -1, 1 };
        
        while (!q.isEmpty()) {
            State s = q.poll();
            if (s.rPos == redGoal && s.bPos == blueGoal) {
                return s.dist;
            }
            
            // try all 4×4 moves
            for (int d1 = 0; d1 < 4; d1++) {
                int nrPos = s.rPos;
                if (s.rPos != redGoal) {
                    int rr = s.rPos / m + dr[d1];
                    int rc = s.rPos % m + dc[d1];
                    if (rr < 0 || rr >= n || rc < 0 || rc >= m) continue;
                    int ni = rr*m + rc;
                    if (wall[ni] || ((s.rMask >> ni) & 1) == 1) continue;
                    nrPos = ni;
                }
                
                for (int d2 = 0; d2 < 4; d2++) {
                    int nbPos = s.bPos;
                    if (s.bPos != blueGoal) {
                        int br = s.bPos / m + dr[d2];
                        int bc = s.bPos % m + dc[d2];
                        if (br < 0 || br >= n || bc < 0 || bc >= m) continue;
                        int ni = br*m + bc;
                        if (wall[ni] || ((s.bMask >> ni) & 1) == 1) continue;
                        nbPos = ni;
                    }
                    
                    // 동시에 같은 칸 이동 금지
                    if (nrPos == nbPos) continue;
                    // 자리 바꿔치기 금지
                    if (nrPos == s.bPos && nbPos == s.rPos) continue;
                    
                    int nrMask = s.rMask;
                    if (s.rPos != redGoal) nrMask |= 1 << nrPos;
                    int nbMask = s.bMask;
                    if (s.bPos != blueGoal) nbMask |= 1 << nbPos;
                    
                    State ns = new State(nrPos, nbPos, nrMask, nbMask, s.dist + 1);
                    long code = encode(ns);
                    if (seen.add(code)) {
                        q.add(ns);
                    }
                }
            }
        }
        
        return 0;
    }
    
    private long encode(State s) {
        // 4 bits for redPos, 4 bits for bluePos, 16 bits each for masks
        long code =  ((long)s.rPos << 36)
                   | ((long)s.bPos << 32)
                   | ((long)s.rMask << 16)
                   |  (long)s.bMask;
        return code;
    }
}
