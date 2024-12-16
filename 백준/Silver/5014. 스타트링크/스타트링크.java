import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static int F, S, G, U, D;
    static int result = 0;
    static int[] maps;
    static boolean[] visited;
    static Queue<Integer> q;
    static int[] moves;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        maps = new int[F + 1];
        visited = new boolean[F + 1];

        for (int i = 0; i < F + 1; i++) {
            maps[i] = i;
        }

        q = new LinkedList<>();

        q.add(S);
        visited[S] = true;
        result = bfs(q);

        if (result != -1) {
            System.out.println(result);
        } else {
            System.out.println("use the stairs");
        }
    }


    public static int bfs(Queue<Integer> q) {
        int cnt = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int current = q.poll();
                int x = current;

                if (x == G) {
                    return cnt;
                }

                moves = new int[]{U, - D};

                for (int move : moves) {
                    int nx = x + move;

                    if (nx >= 1 && nx < F + 1 && !visited[nx]) {
                        q.add(nx);
                        visited[nx] = true;
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
}
