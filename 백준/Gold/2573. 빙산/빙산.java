import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
    static int N, M, area, time;
    static int[][] maps;
    static boolean[][] visited;
    static int[][] melts;
    static Queue<int[]> q;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maps = new int[N + 1][M + 1];
        melts = new int[N + 1][M + 1];
        time = 0;


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        while(true) {
            visited = new boolean[N + 1][M + 1];
            q = new LinkedList<>();
            area = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (maps[i][j] > 0 && !visited[i][j]) {
                        q.add(new int[]{i, j});
                        bfs(q);
                        area++;
                    }
                }
            }


            if (area >= 2) {
                System.out.println(time);
                return;
            } else if (area == 0) {
                System.out.print(0);
                return;
            }

            meltIce();

            time++;
        }
    }


    public static void bfs(Queue<int []> q) {
        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    if (maps[nx][ny] > 0 && !visited[nx][ny]) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }


    public static void meltIce() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int cnt = 0;
                if (maps[i][j] > 0) {
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];

                        if (maps[ni][nj] == 0) {
                            cnt++;
                        }
                    }
                }
                melts[i][j] = cnt;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i][j] - melts[i][j] <= 0) {
                    maps[i][j] = 0;
                } else {
                    maps[i][j] -= melts[i][j];
                }
            }
        }
    }

}
