class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int keyLen = key.length;
        int lockLen = lock.length;
        int mapLen = lockLen + 2 * (keyLen - 1);
        
        int[][] map = new int[mapLen][mapLen];
        for (int i = 0; i < lockLen; i++) {
            for (int j = 0; j < lockLen; j++) {
                map[i + keyLen - 1][j + keyLen - 1] = lock[i][j];
            }
        }
        
        for (int rot = 0; rot < 4; rot++) {
            key = rotate(key);
            
            for (int x = 0; x <= mapLen - keyLen; x++) {
                for (int y = 0; y <= mapLen - keyLen; y++) {
                    for (int i = 0; i < keyLen; i++) {
                        for (int j = 0; j < keyLen; j++) {
                            map[x + i][y + j] += key[i][j];
                        }
                    }
                    
                    if (checkLock(map, keyLen - 1, lockLen)) return true;
                    
                    for (int i = 0; i < keyLen; i++) {
                        for (int j = 0; j < keyLen; j++) {
                            map[x + i][y + j] -= key[i][j];
                        }
                    }
                }
            }
        }
        
        return false;
    }
    
    private int[][] rotate(int[][] key) {
        int n = key.length;
        int[][] rotated = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[n - 1 - j][i] = key[i][j];
            }
        }
        return rotated;
    }
    
    private boolean checkLock(int[][] map, int offset, int lockLen) {
        for (int i = 0; i < lockLen; i++) {
            for (int j = 0; j < lockLen; j++) {
                if (map[i + offset][j + offset] != 1) return false;
            }
        }
        
        return true;
    }
}