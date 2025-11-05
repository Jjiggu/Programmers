import java.util.*;

class Solution {
    
    class Node {
        int x;
        int y;
        int dist;
        
        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    int n, m;
    
    public int solution(String[] maps) {
        int[][] map = convertMap(maps);
        this.n = map.length;
        this.m = map[0].length;
        
        int[] start = findStart(map);
        Node lever = leverOperated(start, map);
        
        return lever.x == -1 ? -1 : bfs(lever, map);
    }
    
    private int bfs(Node start, int[][] map) {
        Deque<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        
        q.add(new Node(start.x, start.y, start.dist));
        visited[start.x][start.y] = true;
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int dist = cur.dist;
            
            if (map[x][y] == 5) return dist;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                
                if (!visited[nx][ny] && map[nx][ny] != 24) {
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny, dist + 1));   
                }
            }
        }
        
        return -1;
    }
    
    private Node leverOperated(int[] start, int[][] map) {
        Deque<Node> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        
        q.add(new Node(start[0], start[1], 0));
        visited[start[0]][start[1]] = true;
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            int dist = cur.dist;
            
            if (map[x][y] == 12) return cur;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                
                if (!visited[nx][ny] && map[nx][ny] != 24) {
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny, dist + 1));   
                }
            }
        }
        
        return new Node(-1, -1, -1);
    }
    
    private int[] findStart(int[][] map) {        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 19) return new int[]{i, j};
            }
        }
        return new int[]{-1, -1};
    }
    
    private int[][] convertMap(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        int[][] map = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            String row = maps[i];
            for (int j = 0; j < m; j++) {
                char c = row.charAt(j);
                map[i][j] = c - 'A' + 1; 
            }
        }
        return map;
    }
}