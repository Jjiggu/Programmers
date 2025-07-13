class Solution {
    public long solution(int w, int h) {
        long gcdNum = gcd(w, h);
        long invalid = (long)w + (long)h - gcdNum;
        return (long)w * h - invalid;
    }

    public long gcd(long a, long b) {
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
