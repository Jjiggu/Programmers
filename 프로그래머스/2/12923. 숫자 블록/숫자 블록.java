class Solution {
    public int[] solution(long begin, long end) {
        int len = (int)(end - begin + 1);
        int[] answer = new int[len];

        for (int idx = 0; idx < len; idx++) {
            long num = begin + idx;

            if (num == 1) {
                answer[idx] = 0;
            } else {
                answer[idx] = getBlock(num);
            }
        }
        return answer;
    }

    private int getBlock(long num) {
        int limit = 10_000_000;
        int res = 1;
        for (int i = 2; i <= limit && i * i <= num; i++) {
            if (num % i == 0) {
                int pair = (int)(num / i);
                if (pair <= limit && pair != num) {
                    return pair;
                } else if (i != num) {
                    res = i;
                }
            }
        }
        return res;
    }
}
