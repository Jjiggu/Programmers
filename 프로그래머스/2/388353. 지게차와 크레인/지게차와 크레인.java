import java.util.*;

class Solution {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] storage, String[] requests) {
        int[][] storageMap = fillWithZero(storage);
        
        for (String request : requests) {
            char targetChar = request.charAt(0);
            int target = (int) targetChar;
            
            if (request.length() == 2) {
                crane(storageMap, target);
            } else {
                forkLift(storageMap, target);
            }
        }
        
        return countRemaining(storageMap);
    }
    
    private void crane(int[][] storageMap, int target) {
        int n = storageMap.length;
        int m = storageMap[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (storageMap[i][j] == target) {
                    storageMap[i][j] = 0;
                }
            }
        }
    }
    
    private void forkLift(int[][] storageMap, int target) {
        int n = storageMap.length;
        int m = storageMap[0].length;
        
        boolean[][] vis = new boolean[n][m];
        Deque<int[]> q = new ArrayDeque<>();
        
        q.add(new int[]{0, 0});
        vis[0][0] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + x;
                int ny = dy[i] + y;
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || vis[nx][ny]) continue;
                
                if (storageMap[nx][ny] == target) {
                    storageMap[nx][ny] = 0;
                    vis[nx][ny] = true;
                } else if (storageMap[nx][ny] == 0) {
                    vis[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        
        return;
    }
    
    private int[][] fillWithZero(String[] storage) {
        int n = storage.length;
        int m = storage[0].length();
        int[][] map = new int[n + 2][m + 2];
        
        for (int i = 0; i < n; i++) {
            String row = storage[i];
            for (int j = 0; j < m; j++) {
                map[i + 1][j + 1] = row.charAt(j); 
            }
        }
        
        return map;
    }
    
    private int countRemaining(int[][] storageMap) {
        int totalRows = storageMap.length;
        int totalCols = storageMap[0].length;
        int cnt = 0;
        for (int i = 1; i < totalRows - 1; i++) {
            for (int j = 1; j < totalCols - 1; j++) {
                if (storageMap[i][j] != 0) cnt++;
            }
        }
        return cnt;
    }
}