import java.util.*;

class Solution {
    
    static int[] dx = new int[]{-1, 1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = setMap(rectangle);
        boolean[][] visited = new boolean[101][101];
        
        int answer = bfs(characterX, characterY, itemX, itemY, map, visited);
        
        return answer / 2;
    }
    
    public int bfs(int characterX, int characterY, int itemX, int itemY, int[][] map, boolean[][] visited) {
        Deque<int[]> q = new ArrayDeque<>();
        visited[characterX * 2][characterY * 2] = true;
        q.add(new int[]{characterX * 2, characterY * 2});
        int[][] dist = new int[101][101];
        
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            
            if (x == itemX * 2 && y == itemY * 2) return dist[x][y];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        dist[nx][ny] = dist[x][y] + 1;
                        q.add(new int[]{nx, ny});
                    }
                }   
            }
        }
        
        return -1;
    }
    
    private int[][] setMap(int[][] rectangle) {
        int[][] map = new int[101][101];
        
        for (int[] rec : rectangle) {
            int leftX = rec[0] * 2;
            int leftY = rec[1] * 2;
            int rightX = rec[2] * 2;
            int rightY = rec[3] * 2;
            
            for (int i = leftX; i <= rightX; i++) {
                map[i][leftY] = 1;
                map[i][rightY] = 1;
            }
            
            for (int i = leftY; i <= rightY; i++) {
                map[leftX][i] = 1;
                map[rightX][i] = 1;
            }
        }
        
        for (int[] rec : rectangle) {
            int leftX = rec[0] * 2;
            int leftY = rec[1] * 2;
            int rightX = rec[2] * 2;
            int rightY = rec[3] * 2;
            
            for (int i = leftX + 1; i < rightX; i++) {
                for (int j = leftY + 1; j < rightY; j++) {
                map[i][j] = 0;
                }
            }
        }
            
        return map;
    }
}