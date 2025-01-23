import java.util.*;

public class Solution {
    public int solution(int n) {
        // 한 번에 k 칸 앞으로 점프 -> k만큼의 건전지 소모
        // 현재까지 온 거리 * 2 순간이동 가능 -> 건전지 소모 없음
        String binaryNum = Integer.toBinaryString(n);
        
        int result = Integer.bitCount(n);
        
        return result;
    }
}