import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.ScheduledExecutorService;

public class Main {
    static int result = 0;
    static int N;
    static int[][] eggList;
    static boolean[] isBroken;


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        eggList = new int[2][N];
        isBroken = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            eggList[0][i] = Integer.parseInt(st.nextToken()); // 내구도
            eggList[1][i] = Integer.parseInt(st.nextToken()); // 무게
        }

        back(0);

        System.out.print(result);
    }

    public static void back(int start) {
        if (start == N) {
            int brokenCount = 0;

            for (int i = 0; i < N; i++) {
                if (isBroken[i]) brokenCount++;
            }

            result = Math.max(result, brokenCount);
            return;
        }

        boolean anyEggBroken = false;

        for (int i = 0; i < N; i++) {
            if (i != start && !isBroken[start] && !isBroken[i]) {
                anyEggBroken = true;

                eggList[0][start] -= eggList[1][i]; // 손에 들고 있는 계란 내구도 최신화
                eggList[0][i] -= eggList[1][start]; // 친 계란 내구도 최신화

                // 계란이 깨졌으면 상태 갱신
                if (eggList[0][start] <= 0) isBroken[start] = true;
                if (eggList[0][i] <= 0) isBroken[i] = true;

//                if (eggList[0][start] < 0) {
//                    isBroken[start] = true;
//                    cnt++;
//                    isEggBroken = true;
//                    back(start + 1, cnt);
//                    break;
//                }
//                if (eggList[0][i] < 0) {
//                    isBroken[i] = true;
//                    cnt++;
//                }

                back(start + 1);


                // 계란이 깨졌으면 상태 갱신
                if (eggList[0][start] <= 0) isBroken[start] = false;
                if (eggList[0][i] <= 0) isBroken[i] = false;

                eggList[0][start] += eggList[1][i]; // 손에 들고 있는 계란 내구도 최신화
                eggList[0][i] += eggList[1][start]; // 친 계란 내구도 최신화

//                if (eggList[0][start] > 0) {
//                    isBroken[start] = false;
//                    cnt--;
//                }
//                if (eggList[0][i] > 0) {
//                    isBroken[i] = false;
//                    cnt--;
//                }
            }
            }
        if (!anyEggBroken) {
            back(start + 1);
        }
    }
}
