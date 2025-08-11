class Solution {
    public long solution(int n, long l, long r) {
        long[] pow5 = new long[n + 1];
        long[] ones = new long[n + 1];

        pow5[0] = 1;
        ones[0] = 1;        // n=0일 때 비트열 "1" 하나
        for (int i = 1; i <= n; i++) {
            pow5[i] = pow5[i - 1] * 5L;
            ones[i] = ones[i - 1] * 4L; // 1은 다음 단계에서 4개의 1로 확장
        }

        return count(n, l, r, pow5, ones);
    }

    // 길이 5^n 비트열의 [l, r] 구간 내 1의 개수 (1-indexed)
    private long count(int n, long l, long r, long[] pow5, long[] ones) {
        if (l > r) return 0;
        if (n == 0) return 1; // 길이 1: "1" 하나

        long blockSize = pow5[n - 1]; // 하위 한 덩이의 길이(=5^{n-1})
        long ans = 0;

        // 5개 블록: 0..4 (인덱스)
        // 블록 타입: [1, 1, 0, 1, 1]
        for (int b = 0; b < 5; b++) {
            long start = b * blockSize + 1;
            long end   = (b + 1) * blockSize;

            long L = Math.max(l, start);
            long R = Math.min(r, end);
            if (L > R) continue; // 교집합 없음

            if (b == 2) {
                // 가운데 블록(전부 0)
                continue;
            }

            // 이 블록을 완전히 포함하면 바로 합산 가능
            if (L == start && R == end) {
                ans += ones[n - 1];
            } else {
                // 부분만 겹치면 하위로 재귀
                long nl = L - start + 1;
                long nr = R - start + 1;
                ans += count(n - 1, nl, nr, pow5, ones);
            }
        }
        return ans;
    }
}
