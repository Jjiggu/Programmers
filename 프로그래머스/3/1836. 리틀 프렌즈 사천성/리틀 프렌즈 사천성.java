import java.util.*;

class Solution {
    public int N, M;
    public int[][] map;
    public Point[] start = new Point[26];
    public int[] dx = {0, 1, 0, -1};
    public int[] dy = {1, 0, -1, 0};
    
    public class Point {
        int x, y, d, k;
        
        public Point(int x, int y, int d, int k) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.k = k;
        }
    }
    
    public String solution(int m, int n, String[] board) {
        int resCnt = 0;
        N = m;
        M = n;
        map = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                char card = board[i].charAt(j);
                if (card >= 'A' && card <= 'Z') {
                    if (start[card - 'A'] == null) {
                        resCnt++;
                        start[card - 'A'] = new Point(i, j, 0, 0);
                    }
                    map[i][j] = card - 'A';
                } else if (card == '.') {
                    map[i][j] = -1;  // 빈칸
                } else {
                    map[i][j] = -2;  // 벽
                }
            }
        }
        
        return bfs(board, resCnt);
    }
    
    public String bfs(String[] board, int resCnt) {
        Deque<Point> q = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();
        
        while(true) {
            boolean flag = true;
            
            for (int i = 0; i < 26; i++) {
                if (!flag) break;
                if (start[i] == null) continue;
                q.clear();
                boolean[][][] check = new boolean[N][M][4];
                
                for (int d = 0; d < 4; d++) {
                    int x = start[i].x + dx[d];
                    int y = start[i].y + dy[d];
                    if (x < 0 || y < 0 || x >= N || y >= M || (map[x][y] != -1 && map[x][y] != i)) continue;
                    check[x][y][d] = true;
                    q.add(new Point(x, y, d, 0));
                }
                
                while(!q.isEmpty()) {
                    Point cur = q.poll();
                    
                    if (map[cur.x][cur.y] == i) {
                        map[start[i].x][start[i].y] = -1;
                        map[cur.x][cur.y] = -1;
                        start[i] = null;
                        result.append((char)(i + 'A'));
                        flag = false;
                        break;
                    }
                    
                    for (int dd = -1; dd <= 1; dd++) {
                        if (cur.k == 1 && (dd == -1 || dd == 1)) continue;
                        int d = calDir(cur.d, dd);
                        int x = cur.x + dx[d];
                        int y = cur.y + dy[d];
                        if (x < 0 || y < 0 || x >= N || y >= M || (map[x][y] != -1 && map[x][y] != i)) continue;
                        if (check[x][y][d]) continue;
                        check[x][y][d] = true;
                        if (cur.k == 1) q.add(new Point(x, y, d, 1));
                        else q.add(new Point(x, y, d, cur.d == d ? 0 : 1));
                    }
                }
            }
            if (flag) break;
        }
        if (result.length() != resCnt) return "IMPOSSIBLE";
        else return result.toString();
    }
    
    public int calDir(int d, int diff) {
        int res = d + diff;
        if (res == 4) return 0;
        else if (res == -1) return 3;
        else return res;
    }
}