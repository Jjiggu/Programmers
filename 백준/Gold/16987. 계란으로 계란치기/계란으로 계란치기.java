import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int result = 0;  // 최대 깨진 계란의 개수를 추적
    static int N;
    static int[][] eggList;  // 0: 내구도, 1: 무게
    static boolean[] isBroken;  // 계란이 깨졌는지 여부를 추적

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        eggList = new int[2][N];  // 0: 내구도, 1: 무게
        isBroken = new boolean[N];  // 각 계란이 깨졌는지 여부

        // 계란의 내구도와 무게 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            eggList[0][i] = Integer.parseInt(st.nextToken());  // 내구도
            eggList[1][i] = Integer.parseInt(st.nextToken());  // 무게
        }

        back(0);  // 첫 번째 계란부터 탐색 시작

        System.out.println(result);  // 최대 깨진 계란 개수 출력
    }

    // 백트래킹을 이용한 계란치기
    public static void back(int start) {
        // 모든 계란을 탐색한 경우
        if (start == N) {
            // 현재까지 깨진 계란 수를 계산하고 최대값 갱신
            int brokenCount = 0;
            for (int i = 0; i < N; i++) {
                if (isBroken[i]) brokenCount++;
            }
            result = Math.max(result, brokenCount);
            return;
        }

        boolean anyEggBroken = false;  // 이번 단계에서 깨진 계란이 있는지 체크

        // 다른 계란과 충돌 시도
        for (int i = 0; i < N; i++) {
            if (i != start && !isBroken[start] && !isBroken[i]) {  // 자기 자신과는 치지 않으며, 깨지지 않은 계란끼리만 충돌
                anyEggBroken = true;

                // 내구도 갱신: start 계란과 i 계란을 충돌
                eggList[0][start] -= eggList[1][i];  // 손에 든 계란 내구도 감소
                eggList[0][i] -= eggList[1][start];  // 친 계란 내구도 감소

                // 계란이 깨졌으면 상태 갱신
                if (eggList[0][start] <= 0) isBroken[start] = true;
                if (eggList[0][i] <= 0) isBroken[i] = true;

                // 재귀 호출 (다음 계란을 탐색)
                back(start + 1);

                // 상태 복구
                if (eggList[0][start] <= 0) isBroken[start] = false;
                if (eggList[0][i] <= 0) isBroken[i] = false;

                // 내구도 원복
                eggList[0][start] += eggList[1][i];  // 손에 든 계란 내구도 복구
                eggList[0][i] += eggList[1][start];  // 친 계란 내구도 복구
            }
        }

        // 이번 단계에서 어떤 계란도 깨지지 않았으면, 그 계란을 건너뛰고 탐색
        if (!anyEggBroken) {
            back(start + 1);
        }
    }
}
