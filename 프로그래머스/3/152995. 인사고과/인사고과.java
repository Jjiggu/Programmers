import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int n = scores.length;
        
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scores[i][0];
            arr[i][1] = scores[i][1];
            arr[i][2] = i;
        }
        
        Arrays.sort(arr, (o1, o2) -> {
            if (o2[0] != o1[0]) return o2[0] - o1[0];
            else return o1[1] - o2[1];
        });
        
        int maxReputation = -1;
        List<int[]> survival = new ArrayList<>();
        
        for (int[] a : arr) {
            int reputation = a[1];
            
            if (reputation < maxReputation) continue;
        
            maxReputation = Math.max(maxReputation, reputation);
            survival.add(a);
        }
        
        boolean wonhoSurvived = false;
        for (int[] s : survival) {
            if (s[2] == 0) wonhoSurvived = true;
        }
        if (!wonhoSurvived) return -1;
        
        survival.sort((o1, o2) -> (o2[0] + o2[1]) - (o1[0] + o1[1]));
        
        
        int prev = -1;
        int rank = 0;
        int actualRank = 0;
        
        for (int i = 0; i < survival.size(); i++) {
            int score = survival.get(i)[0] + survival.get(i)[1];
            
            if (score != prev) {
                actualRank = rank + 1;
                prev = score;
            }
            
            if (survival.get(i)[2] == 0) return actualRank;
            
            rank++;
        }
        
        return -1;
    }
}
