class Solution {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        long answer = 0;
        int len = queries.length;
        
        long rowLo = x, rowHi = x;
        long colLo = y, colHi = y;
        
        
        for (int i = len - 1; i >= 0; i--) {
            int cmd = queries[i][0];
            int dx = queries[i][1];
            
            switch(cmd) {
                case 0:
                    if (colLo == 0) {
                        colHi = Math.min(m - 1, colHi + dx);
                    } else {
                        colLo += dx;
                        colHi += dx;
                        if (colLo > m - 1) return 0;
                        colHi = Math.min(m - 1, colHi);
                    }
                    break;
                case 1:
                    if (colHi == m - 1) {
                        colLo = Math.max(0, colLo - dx);
                    } else {
                        colLo -= dx;
                        colHi -= dx;
                        if (colHi < 0) return 0;
                        colLo = Math.max(colLo, 0);
                    }
                    break;
                case 2:
                    if (rowLo == 0) {
                        rowHi = Math.min(n - 1, rowHi + dx);
                    } else {
                        rowLo += dx;
                        rowHi += dx;
                        if (rowLo > n - 1) return 0;
                        rowHi = Math.min(n - 1, rowHi);
                    }
                    break;
                case 3:
                    if (rowHi == n - 1) {
                        rowLo = Math.max(0, rowLo - dx);
                    } else {
                        rowLo -= dx;
                        rowHi -= dx;
                        if (rowHi < 0) return 0;
                        rowLo = Math.max(rowLo, 0);
                    }
                    break;
            }
            
            if (rowLo > rowHi || colLo > colHi) return 0;
        }
        
        return (rowHi - rowLo + 1) * (colHi - colLo + 1);
    }
}
