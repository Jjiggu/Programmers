import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] == o2[col - 1]) 
                return o2[0] - o1[0];
            return o1[col - 1] - o2[col - 1];
        });
        
        ArrayList<Integer> tmp = new ArrayList<>();
        for (int i = row_begin - 1; i <= row_end - 1; i++) {
            int nowNum = 0;
            for (int num : data[i]) {
                nowNum += num % (i + 1);
            }
            tmp.add(nowNum);
        }
    
        int answer = tmp.get(0);
        for (int i = 1; i < tmp.size(); i++) {
            answer = answer ^ tmp.get(i);
        }        
        return answer;
    }
}