import java.util.*;

class Solution {

    public int solution(int n, int m, int[][] timetable) {
        // 1. 구간합으로 "동시에 있는 최대 인원수" 구하기
        // 영업시간: 10:00(600) ~ 22:00(1320)
        int[] diff = new int[722]; // 600 ~ 1321 분까지 커버 (1320+1-600 = 721)

        for (int i = 0; i < m; i++) {
            int start = timetable[i][0] - 600;
            int end = timetable[i][1] - 600;

            diff[start]++;                 // 입실 시점
            if (end + 1 < diff.length) {   // 퇴실 다음 분에 -1
                diff[end + 1]--;
            }
        }

        int cur = 0;
        int maxPeople = 0;
        // 실제 시간 범위: 0 ~ 720 (600~1320)
        for (int i = 0; i <= 720; i++) {
            cur += diff[i];
            if (cur > maxPeople) {
                maxPeople = cur;
            }
        }

        // 겹치는 사람이 없거나 1명뿐이면 최소 거리는 0
        if (maxPeople <= 1) return 0;

        // 2. n×n 격자에 maxPeople명을 "최소 거리 d 이상"으로 배치할 수 있는지 확인
        //    최대 거리는 양 끝 대각선: 2*(n-1)
        for (int d = 2 * (n - 1); d >= 1; d--) {
            if (canArrangeWithDistance(n, maxPeople, d)) {
                return d;
            }
        }

        // 이론상 여기까지 올 일은 거의 없지만, 안전하게 0 리턴
        return 0;
    }

    // 거리 d 이상을 유지하면서 n×n에 people명을 배치할 수 있는지 브루트포스
    private boolean canArrangeWithDistance(int n, int people, int minDist) {
        // 시작 위치를 (i, j)로 가정하고 전부 시도
        for (int sr = 0; sr < n; sr++) {
            for (int sc = 0; sc < n; sc++) {

                List<int[]> placed = new ArrayList<>();
                placed.add(new int[]{sr, sc}); // 첫 번째 사람 배치

                // 이후 위치들을 (sr, sc) 이후 좌표부터 쭉 훑으면서 배치
                for (int r = sr; r < n; r++) {
                    for (int c = 0; c < n; c++) {
                        // 첫 줄에서는 시작점 이전 좌표는 스킵
                        if (r == sr && c <= sc) continue;

                        if (canPlaceHere(r, c, minDist, placed)) {
                            placed.add(new int[]{r, c});
                            if (placed.size() == people) {
                                return true; // 이 거리로도 people명 배치 가능
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    // (r, c)에 새로 배치했을 때, 기존 배치들과 모두 거리 minDist 이상인지 확인
    private boolean canPlaceHere(int r, int c, int minDist, List<int[]> placed) {
        for (int[] p : placed) {
            int dist = manhattan(p[0], p[1], r, c);
            if (dist < minDist) return false;
        }
        return true;
    }

    // 이 문제에서의 거리는 상하좌우 1, 대각선 2 → 맨해튼 거리
    private int manhattan(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}
