import java.util.*;

class Solution {
    
    class Node {
        int x;
        int y;
        int dir;
        int cost;
        
        Node(int x, int y, int dir, int cost) {
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.cost = cost;
        }
    }
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] board) {
        int n = board.length;
        return bfs(n, board);
    }
    
    private int bfs(int n, int[][] board) {
        
        int[][][] minCost = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(minCost[i][j], Integer.MAX_VALUE);
            }
        }
        
        Deque<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, -1, 0));
        
        int answer = Integer.MAX_VALUE;
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int dir = cur.dir;
            int cost = cur.cost;
            
            if (x == n - 1 && y == n - 1) {
                answer = Math.min(answer, cost);
                continue;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny] == 0) {
                    int newCost;
                    if (dir == -1 || dir == i) {
                        newCost = cost + 100;
                    } else {
                        newCost = cost + 600;
                    }
                    
                    if (minCost[nx][ny][i] >= newCost) {
                        minCost[nx][ny][i] = newCost;
                        q.offer(new Node(nx, ny, i, newCost));
                    }
                }
            }
        }
        return answer;
    }
}
