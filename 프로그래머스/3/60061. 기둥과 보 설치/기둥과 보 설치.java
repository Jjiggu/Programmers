class Solution {
    public int[][] solution(int n, int[][] build_frame) {
        
        int[][][] map = new int[n + 1][n + 1][2];
        int cnt = 0;
        
        for (int[] build : build_frame) {
            int x = build[0];
            int y = build[1];
            int a = build[2];
            int b = build[3];
        
            if (b == 1) {
                if (canPlaceBeam(x, y, a, n, map)) {
                    map[x][y][a] = 1;
                    cnt++;
                } 
            } else {
                if (canRemoveBeam(x, y, a, n, map)) {
                    map[x][y][a] = 0;
                    cnt--;
                }
            }
        }
        
        int[][] result = new int[cnt][3];
        int idx = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int a = 0; a < 2; a++) {
                    if (map[i][j][a] == 1) {
                        result[idx][0] = i;
                        result[idx][1] = j;
                        result[idx][2] = a;
                        idx++;
                    }
                }
            }
        }
        
        return result;
    }
    
    private boolean canPlaceBeam(int x, int y, int a, int n, int[][][] map) {
        if (a == 0) {
            return y == 0 || 
                  (y > 0 && map[x][y - 1][0] == 1) || 
                  (x > 0 && map[x - 1][y][1] == 1) || 
                  (map[x][y][1] == 1);
        } else {
            return (y > 0 && map[x][y - 1][0] == 1) || 
                   (y > 0 && x + 1 <= n && map[x + 1][y - 1][0] == 1) || 
                   (x > 0 && x + 1 <= n && map[x - 1][y][1] == 1 && map[x + 1][y][1] == 1);
        }
    }
    
    
    private boolean canRemoveBeam(int x, int y, int a, int n, int[][][] map) {
        map[x][y][a] = 0;
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k < 2; k++) {
                    if (map[i][j][k] == 1 && !canPlaceBeam(i, j, k, n, map)) {
                        map[x][y][a] = 1;
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}
