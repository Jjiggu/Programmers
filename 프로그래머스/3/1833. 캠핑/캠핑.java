import java.util.*;

/** Programmers 1833 캠핑 — O(N^2 log N) */
class Solution {
    static class P {
        int x, y;
        P(int x, int y) { this.x = x; this.y = y; }
    }

    public int solution(int n, int[][] data) {
        P[] a = new P[n];
        for (int i = 0; i < n; i++) a[i] = new P(data[i][0], data[i][1]);

        // 1) x 오름차순, x가 같으면 y 오름차순
        Arrays.sort(a, (p1, p2) -> (p1.x != p2.x) ? Integer.compare(p1.x, p2.x)
                                                  : Integer.compare(p1.y, p2.y));

        long ans = 0;

        // 2) 왼쪽 경계 i 고정
        for (int i = 0; i < n; i++) {
            // i와 같은 x는 '왼쪽 경계'이므로 내부 집합에 포함하면 안 됨
            int j = i + 1;
            while (j < n && a[j].x == a[i].x) j++;

            // 내부 y값을 보관할 정렬집합
            TreeSet<Integer> insideY = new TreeSet<>();

            // 3) x가 증가하는 방향으로 ‘같은 x 묶음(block)’씩 처리
            while (j < n) {
                int xVal = a[j].x;

                // 같은 x를 가진 인덱스 구간 [j, k)
                int k = j + 1;
                while (k < n && a[k].x == xVal) k++;

                // (1) 현재 x 블록을 오른쪽 경계로 하는 모든 쌍(i, t) 검사
                for (int t = j; t < k; t++) {
                    // 넓이 0인 경우는 제외 (y 동일)
                    if (a[t].y == a[i].y) continue;

                    int lo = Math.min(a[i].y, a[t].y);
                    int hi = Math.max(a[i].y, a[t].y);

                    // 내부에 y가 있는지: (lo, hi) 열린구간에 원소가 존재?
                    Integer cand = insideY.higher(lo); // lo보다 큰 첫 y
                    if (cand == null || cand >= hi) {
                        // 내부가 비어있으면 유효한 텐트
                        ans++;
                    }
                }

                // (2) 이제야 현재 x 블록의 y들을 내부 집합에 추가
                //     -> 다음 x들에 대해선 '사이에 있는 점'이 됨
                for (int t = j; t < k; t++) {
                    insideY.add(a[t].y);
                }

                j = k;
            }
        }

        // 문제는 int 반환이지만, 안전하게 형변환 (n<=5000이면 int 범위 내)
        return (int) ans;
    }
}
