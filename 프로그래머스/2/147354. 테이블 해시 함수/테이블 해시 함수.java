import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (o1, o2) -> {
            if (o1[col - 1] == o2[col - 1]) 
                return o2[0] - o1[0];
            return o1[col - 1] - o2[col - 1];
        });
        
        ArrayList<Integer> modData = new ArrayList<>();
        for (int i = row_begin; i <= row_end; i++) {
            int dataNum = 0;
            for (int num : data[i - 1]) {
                dataNum += num % i;
            }
            modData.add(dataNum);
        }
    
        int answer = modData.get(0);
        for (int i = 1; i < modData.size(); i++) {
            answer = answer ^ modData.get(i);
        }        
        return answer;
    }
}