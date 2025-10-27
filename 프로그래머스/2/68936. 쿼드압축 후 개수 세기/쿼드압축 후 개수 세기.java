class Solution {
    
    int zeroCnt = 0, oneCnt = 0;
    
    public int[] solution(int[][] arr) {
        compress(0, 0, arr.length, arr);
        
        return new int[]{zeroCnt, oneCnt};
    }
    
    private void compress(int x, int y, int size, int[][] arr) {
        if (isSame(x, y, size, arr)) {
            if (arr[x][y] == 0) zeroCnt++;
            else oneCnt++;
            return;
        }
        
        int half = size / 2;
        compress(x, y, half, arr);
        compress(x + half, y, half, arr);
        compress(x, y + half, half, arr);
        compress(x + half, y + half, half, arr);
    }
    
    private boolean isSame(int x, int y, int size, int[][] arr) {
        int first = arr[x][y];
        
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != first) return false;
            }
        }
        
        return true;
    }
}