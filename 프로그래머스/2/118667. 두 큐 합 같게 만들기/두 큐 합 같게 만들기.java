import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        long sum1 = 0, sum2 = 0;
        for (int x : queue1) sum1 += x;
        for (int x : queue2) sum2 += x;
        long total = sum1 + sum2;
        if ((total & 1) == 1) return -1;
        long target = total / 2;

        // 1) 두 큐를 한 배열로
        int[] arr = new int[2 * n];
        for (int i = 0; i < n; i++) {
            arr[i]     = queue1[i];
            arr[i + n] = queue2[i];
        }

        // 2) 슬라이딩 윈도우
        int l = 0, r = n;
        long sum = sum1;
        int ops = 0;
        int maxOps = 3 * n;  // 안전한 upper bound

        while (ops <= maxOps) {
            if (sum == target) {
                return ops;
            }
            if (sum < target) {
                if (r >= 2 * n) break;
                sum += arr[r++];
            } else {
                if (l >= 2 * n) break;
                sum -= arr[l++];
            }
            ops++;
        }

        return -1;
    }
}