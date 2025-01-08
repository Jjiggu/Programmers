class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for (int i = 1; i <= yellow / 2 + 1; i++) {
            if (yellow % i == 0) {
                int x = i;
                int y = yellow / i;
                
                int circum = (2 * x + 2 * y + 4);

                if (circum == brown) {
                    answer[1] = x + 2;
                    answer[0] = y + 2;
                    break;
                }
            }
        }
        
        return answer;
    }
}