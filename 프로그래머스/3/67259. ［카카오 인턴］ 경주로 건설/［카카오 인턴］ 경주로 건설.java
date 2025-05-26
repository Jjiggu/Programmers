import java.util.*;

class Solution {
    class Node {
        int x;
        int y;
        int dir;
        int cost;
        
        Node(int x, int y, int cost, int dir) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }
    }
    static int[] dx = {-1, 1, 0, 0}; 
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] board) {
        int n = board.length;
        int[][][] cost = new int[n][n][4];
        
        for (int[][] layer : cost) {
            for (int[] row : layer) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }
        
        return bfs(board, cost, n);
    }
    
    
    private int bfs(int[][] board, int[][][] cost, int n) {
        Deque<Node> q = new ArrayDeque<>();
        
        if (board[0][1] == 0) {
            q.add(new Node(0, 1, 100, 3));
            cost[0][1][0] = 100;
        }
        
        if (board[1][0] == 0) {
            q.add(new Node(1, 0, 100, 1));
            cost[1][0][3] = 100;
        }
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= n || board[nx][ny] == 1) continue;
                int newCost = cur.dir == i ? cur.cost + 100 : cur.cost + 600;
                
                if (newCost < cost[nx][ny][i]) {
                    cost[nx][ny][i] = newCost;
                    q.add(new Node(nx, ny, newCost, i));
                }
            }
        }
        
        return Arrays.stream(cost[n - 1][n - 1]).min().getAsInt();
    }
}
