import java.util.*;

class Solution {
    
    class State {
        
        public int rx, ry, bx, by, t; // 빨간색 (x,y), 파란색 (x,y), 턴
        public boolean[][][] visited; // 방문 배열
        
        public State(int rx, int ry, int bx, int by, int t, boolean[][][] visited) {
            this.rx = rx; this.ry = ry; 
            this.bx = bx; this.by = by;
            this.t = t;
            
            // 현재 위치 방문 처리
            this.visited = visited;
            this.visited[0][rx][ry] = true;
            this.visited[1][bx][by] = true;
        }
        
    }
    
    private int rix, riy, bix, biy; // 시작 위치
    private int rdx, rdy, bdx, bdy; // 목표 위치
    private boolean[][][][] mem = new boolean[4][4][4][4]; // 현재 State에 방문한적이 있는지 mem[rx][ry][bx][by]
    private int[] dx = {-1,1,0,0};
    private int[] dy = {0,0,-1,1};
    
    public int solution(int[][] maze) {
        init(maze); // 시작 위치와 도착 위치 찾기
        
        Queue<State> q = new LinkedList<>();
        q.offer(new State(rix, riy, bix, biy, 0, new boolean[2][4][4])); // 초기 State
        mem[rix][riy][bix][biy] = true; // 초기 State 방문 처리
        
        while (!q.isEmpty()) {
            State cur = q.peek();
            q.poll();
            
            if (isGameClear(cur)) return cur.t; // 목표 위치에 전부 도달했으면 현재 State의 턴 반환
            
            for (int i=0; i<4; i++) {
                boolean redClear = isRedClear(cur); // 빨간 수레의 클리어 여부
                int nrx = cur.rx;
                int nry = cur.ry;
                
                // 아직 클리어하지 못했으면 이동
                if (!redClear) {
                    nrx += dx[i];
                    nry += dy[i];
                }
                
                if (!isValid(nrx, nry, maze)) continue; // 이동하려는 위치가 퍼즐 밖이거나 벽인 경우
                if (!redClear && cur.visited[0][nrx][nry]) continue; // 이미 방문한 위치인 경우 (목표 위치 제외) 
                
                for (int j=0; j<4; j++) {
                    boolean blueClear = isBlueClear(cur); // 파란 수레의 클리어 여부
                    int nbx = cur.bx;
                    int nby = cur.by;
                    
                    if (!blueClear) {
                        nbx += dx[j];
                        nby += dy[j];
                    }
                    
                    if (!isValid(nbx, nby, maze)) continue;
                    if (!blueClear && cur.visited[1][nbx][nby]) continue;
                    if (isSame(nrx, nry, nbx, nby) || isSwapped(nrx, nry, nbx, nby, cur)) continue; // 두 수레가 같은 위치이거나 서로 자리를 바꾼 경우
                    if (mem[nrx][nry][nbx][nby]) continue; // 이미 방문한 State인 경우
                    
                    boolean[][][] newVisited = copyVisited(cur.visited); // 방문 배열 깊은 복사
                    mem[nrx][nry][nbx][nby] = true; // 현재 State 방문 처리
                    q.offer(new State(nrx, nry, nbx, nby, cur.t+1, newVisited));
                }
            }
            
        }
        
        return 0;
    }
    
    public void init(int[][] maze) {
        for (int i=0; i<maze.length; i++) {
            for (int j=0; j<maze[i].length; j++) {
                switch (maze[i][j]) {
                    case 1 : rix = i; riy = j; break;
                    case 2 : bix = i; biy = j; break;
                    case 3 : rdx = i; rdy = j; break;
                    case 4 : bdx = i; bdy = j; break;
                }
            }
        }
    }
    
    public boolean[][][] copyVisited(boolean[][][] a) {
        boolean[][][] b = new boolean[a.length][a[0].length][a[0][0].length];
        for (int i=0; i<a.length; i++) {
            for (int j=0; j<a[i].length; j++) {
                for (int k=0; k<a[i][j].length; k++) {
                    b[i][j][k] = a[i][j][k];
                }
            }
        }
        return b;
    }
    
    public boolean isValid(int x, int y, int[][] maze) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] != 5;
    }
    
    public boolean isSame(int rx, int ry, int bx, int by) {
        return rx == bx && ry == by;
    }
    
    public boolean isSwapped(int nrx, int nry, int nbx, int nby, State bef) {
        return nrx == bef.bx && nry == bef.by && nbx == bef.rx && nby == bef.ry;
    }
    
    public boolean isRedClear(State st) {
        return st.rx == rdx && st.ry == rdy;
    }
    
    public boolean isBlueClear(State st) {
        return st.bx == bdx && st.by == bdy;
    }
    
    public boolean isGameClear(State st) {
        return st.rx == rdx && st.ry == rdy && st.bx == bdx && st.by == bdy;
    }
}