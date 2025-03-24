class Solution {
    public int solution(int[] stones, int k) {
        int left = 1;
        int right = 200000000; // 최대 2억
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canCross(stones, k, mid)) {
                answer = mid;
                left = mid + 1; // 더 많이 건널 수 있는지 탐색
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    private boolean canCross(int[] stones, int k, int mid) {
        int skip = 0;

        for (int stone : stones) {
            if (stone < mid) {
                skip++;
                if (skip >= k) return false;
            } else {
                skip = 0;
            }
        }

        return true;
    }
}
