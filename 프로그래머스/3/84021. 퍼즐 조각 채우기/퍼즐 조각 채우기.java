import java.util.*;

class Solution {
    
    static int N;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] game_board, int[][] table) {
        N = game_board.length;
        
        List<List<int[]>> rawPieces = extract(table, 1);
        List<List<int[]>> rawHoles  = extract(game_board, 0);
        
        List<List<int[]>> pieces = new ArrayList<>();
        for (List<int[]> comp : rawPieces) pieces.add(normalize(comp));

        List<List<int[]>> holes = new ArrayList<>();
        for (List<int[]> comp : rawHoles) holes.add(normalize(comp));
        
        boolean[] used = new boolean[pieces.size()];
        int answer = 0;
        
        for (List<int[]> hole : holes) {
            int holeSize = hole.size();

            for (int i = 0; i < pieces.size(); i++) {
                if (used[i]) continue;
                List<int[]> piece = pieces.get(i);
                if (piece.size() != holeSize) continue;

                // 4회 회전 비교
                List<int[]> rotated = piece;
                boolean fit = false;
                for (int r = 0; r < 4; r++) {
                    if (r > 0) rotated = rotate(rotated);
                    if (same(hole, rotated)) {
                        fit = true;
                        break;
                    }
                }

                if (fit) {
                    used[i] = true;
                    answer += holeSize;
                    break;
                }
            }
        }
        
        return answer;
    }
    
    private List<int[]> bfs(int[][] board, int sr, int sc, int target) {
        List<int[]> cells = new ArrayList<>();
        Deque<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[]{sr, sc});
        visited[sr][sc] = true;
        cells.add(new int[]{sr, sc});
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (visited[nr][nc]) continue;
                if (board[nr][nc] != target) continue;
                visited[nr][nc] = true;
                q.offer(new int[]{nr, nc});
                cells.add(new int[]{nr, nc});
            }
        }
        
        return cells;
    }
    
    private List<List<int[]>> extract(int[][] board, int target) {
        visited = new boolean[N][N];
        List<List<int[]>> res = new ArrayList<>();
        
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                if (!visited[r][c] && board[r][c] == target) {
                    List<int[]> comp = bfs(board, r, c, target);
                    res.add(comp);
                }
            }
        }
        return res;
    }
    
    private List<int[]> normalize(List<int[]> cells) {
        int minR = Integer.MAX_VALUE;
        int minC = Integer.MAX_VALUE;
        for (int[] p : cells) {
            minR = Math.min(minR, p[0]);
            minC = Math.min(minC, p[1]);
        }
        List<int[]> norm = new ArrayList<>();
        for (int[] p : cells) {
            norm.add(new int[]{p[0] - minR, p[1] - minC});
        }
        norm.sort((a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        return norm;
    }
    
    private List<int[]> rotate(List<int[]> shape) {
        int maxR = 0, maxC = 0;
        for (int[] p : shape) {
            maxR = Math.max(maxR, p[0]);
            maxC = Math.max(maxC, p[1]);
        }
        
        int height = maxR + 1;
        List<int[]> rotated = new ArrayList<>();
        for (int[] p : shape) {
            int r = p[0], c = p[1];
            // (r,c) -> (c, height - 1 - r)
            rotated.add(new int[]{c, height - 1 - r});
        }
        return normalize(rotated);
    }
    
    private boolean same(List<int[]> a, List<int[]> b) {
        if (a.size() != b.size()) return false;
        for (int i = 0; i < a.size(); i++) {
            int[] p = a.get(i);
            int[] q = b.get(i);
            if (p[0] != q[0] || p[1] != q[1]) return false;
        }
        return true;
    }
}