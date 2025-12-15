import java.util.*;

class Solution {
    List<Integer> answer = new ArrayList<>();
    boolean[][] visited;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    int n, m;
    
    class Node {
        int x;
        int y;
        
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int[] solution(String[] maps) {
        this.n = maps.length;
        this.m = maps[0].length();
        Character[][] map = new Character[n][m];
        visited = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] != 'X') {
                    answer.add(bfs(i, j, map));
                }
            }
        }
        
        if (answer.size() == 0) return new int[]{-1};
        
        Collections.sort(answer);
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int bfs(int startX, int startY, Character[][] map) {
        Deque<Node> q = new ArrayDeque<>();

        q.add(new Node(startX, startY));
        visited[startX][startY] = true;
        int distSum = map[startX][startY] - '0';
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            int x = cur.x;
            int y = cur.y;
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] == 'X') continue;
                
                q.offer(new Node(nx, ny));
                visited[nx][ny] = true;
                distSum += map[nx][ny] - '0';
            }
        }
        
        return distSum;
    }
}