class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while (storey > 0) {
            int lastDigit = storey % 10;
            int next = (storey / 10) % 10;
            
            if (lastDigit > 5) {
                answer += (10 - lastDigit);
                storey += 10;
            } else if (lastDigit < 5) {
                answer += lastDigit;
            } else {
                if (next >= 5) {
                    answer += 5;
                    storey += 10;
                } else {
                    answer += 5;
                }
            }
            storey /= 10;
        }
        
        return answer;
    }
}
