import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int result;
    static int N, M;
    static int x, y, a, b;
    static boolean[][] lights;
    static boolean[][] visited;
    static ArrayList<Room>[][] room;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Queue<Room> q;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lights = new boolean[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        room = new ArrayList[N + 1][N + 1];

        q = new LinkedList<>();


        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < N + 1; j++) {
                room[i][j] = new ArrayList<>();
            }
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            room[x][y].add(new Room(a, b));
        }

        result = 1;
        q = new LinkedList<>();

        q.add(new Room(1, 1));
        visited[1][1] = true;
        lights[1][1] = true;

        bfs();

        System.out.println(result);
    }


    public static void bfs() {
        while (!q.isEmpty()) {
            Room tmp = q.poll();

            if (!room[tmp.x][tmp.y].isEmpty()) {
                visited = new boolean[N + 1][N + 1];
                visited[tmp.x][tmp.y] = true;

                for (Room room1 : room[tmp.x][tmp.y]) {
                    if (!lights[room1.x][room1.y]) {
                        lights[room1.x][room1.y] = true;
                        result++;
                    }
                }
                room[tmp.x][tmp.y].clear();
            }


            for (int i = 0; i < 4; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];


                if (nx > 0 && ny > 0 && nx <= N && ny <= N) {
                    if (lights[nx][ny] && !visited[nx][ny]) {
                        q.add(new Room(nx, ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}

class Room {
    int x;
    int y;

    Room (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

