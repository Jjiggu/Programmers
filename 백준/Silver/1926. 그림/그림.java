import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int N, M;
    static int area, cnt, result;
    static int[][] maps;
    static boolean[][] visited;
    static Queue<int[]> q;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maps = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int x = Integer.parseInt(st.nextToken());
                maps[i][j] = x;
            }
        }

        q = new LinkedList<>();
        result = 0;
        cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i][j] == 1 && !visited[i][j]) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                    area = bfs(q);
                    cnt++;
                    result = Math.max(area, result);
                }
            }
        }


        if (cnt == 0) {
            System.out.println(cnt);
            System.out.println(0);
        } else {
            System.out.println(cnt);
            System.out.println(result);
        }
    }


    public static int bfs(Queue<int[]> q) {
        area = 1;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && !visited[nx][ny] && maps[nx][ny] == 1) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    area++;
                }
            }
        }
        return area;
    }
}
