import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        return Arrays.stream(numbers)
            .map(n -> (n & 1) == 0 ? n + 1 : n + (Long.lowestOneBit(~n) >> 1))  // 짝수는 +1, 홀수는 가장 낮은 0비트 위치 계산
            .toArray();  // 결과 배열로 반환
    }
}