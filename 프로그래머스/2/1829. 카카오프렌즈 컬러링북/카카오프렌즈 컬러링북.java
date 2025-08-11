import java.util.*;

class Solution {
    private int m, n;
    private int[][] pic;
    private boolean[][] visited;
    private final int[] dx = {-1, 1, 0, 0};
    private final int[] dy = {0, 0, -1, 1};

    public int[] solution(int m, int n, int[][] picture) {
        this.m = m;
        this.n = n;
        this.pic = picture;
        visited = new boolean[m][n];

        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && pic[i][j] != 0) {
                    int size = bfs(i, j);
                    numberOfArea++;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, size);
                }
            }
        }

        return new int[]{numberOfArea, maxSizeOfOneArea};
    }

    private int bfs(int startX, int startY) {
        int color = pic[startX][startY];
        Deque<int[]> q = new ArrayDeque<>();
        visited[startX][startY] = true;
        q.add(new int[]{startX, startY});

        int size = 0;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            size++;

            for (int dir = 0; dir < 4; dir++) {
                int nx = cur[0] + dx[dir];
                int ny = cur[1] + dy[dir];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (!visited[nx][ny] && pic[nx][ny] == color) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        return size;
    }
}
