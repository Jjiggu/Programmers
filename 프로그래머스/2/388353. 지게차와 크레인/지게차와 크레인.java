import java.util.*;

class Solution {   
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] storage, String[] requests) {
        int[][] storageMap = fillWithZero(storage);
        
        for (String request : requests) {
            char target = request.charAt(0);
            
            if (request.length() == 1) {
                forkLift((int)target, 0, 0, storageMap);
            } else {
                crane((int)target, storageMap);
            }
        }
        
        return countAnswer(storageMap);
    }
    
    private void forkLift(int target, int startX, int startY, int[][] storageMap) {
        boolean[][] visited = new boolean[storageMap.length][storageMap[0].length];
        Deque<int[]> q = new ArrayDeque<>();
        
        q.add(new int[]{startX, startY});
        visited[startX][startY] = true;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= storageMap.length || ny >= storageMap[0].length || visited[nx][ny]) continue;
                
                if (storageMap[nx][ny] == target) {
                    storageMap[nx][ny] = 0;
                    visited[nx][ny] = true;
                } else if (storageMap[nx][ny] == 0) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }
    }
    
    private void crane(int target, int[][] storageMap) {
        for (int i = 0; i < storageMap.length; i++) {
            for (int j = 0; j < storageMap[0].length; j++) {
                if (storageMap[i][j] == target) storageMap[i][j] = 0;
            }
        }
    }
    
    private int countAnswer(int[][] storageMap) {
        int answer = 0;
        
        for (int i = 0; i < storageMap.length; i++) {
            for (int j = 0; j < storageMap[0].length; j++) {
                if (storageMap[i][j] != 0) answer++;
            }
        }
        
        return answer;
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
}