import java.util.*;

class Solution {
    public long solution(int[] weights) {
        Arrays.sort(weights);                 // 앞에서부터 누적 카운트
        Map<Integer, Long> seen = new HashMap<>();
        long answer = 0;

        for (int w : weights) {
            // 1) 같은 무게 (1:1)
            answer += seen.getOrDefault(w, 0L);

            // 2) 1:2 (상대가 w/2)
            if (w % 2 == 0) {
                answer += seen.getOrDefault(w / 2, 0L);
            }

            // 3) 2:3 (상대가 w*2/3)
            if (w % 3 == 0) {
                answer += seen.getOrDefault(w * 2 / 3, 0L);
            }

            // 4) 3:4 (상대가 w*3/4)
            if (w % 4 == 0) {
                answer += seen.getOrDefault(w * 3 / 4, 0L);
            }

            // 현재 무게 카운트 반영
            seen.put(w, seen.getOrDefault(w, 0L) + 1);
        }

        return answer;
    }
}
