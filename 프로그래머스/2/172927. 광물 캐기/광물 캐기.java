import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int[][] tired = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
        String[] pickTypes = {"diamond", "iron", "stone"};
        
        Map<String, Integer> mineralIdx = new HashMap<>();
        int maxPick = 0;
        
        for (int i = 0; i < picks.length; i++) {
            mineralIdx.put(pickTypes[i], i);  // 인덱스 매핑
            maxPick += picks[i] * 5;  // 캘 수 있는 최대 광물 수
        }
        
        int mineralCnt = Math.min(maxPick, minerals.length);  // 실제로 캘 광물의 수
        List<int[]> costList = new ArrayList<>();
        for (int i = 0; i < mineralCnt; i+=5) {
            int[] costs = new int[3];  // 곡괭이당 피로도 전부 계산
            for (int j = i; j < i + 5 && j < mineralCnt; j++) {
                for (int k = 0; k < 3; k++) {
                    costs[k] += tired[k][mineralIdx.get(minerals[j])];
                }
            }
            costList.add(costs);
        }
        
        costList.sort((o1, o2) -> o2[2] - o1[2]);  // 돌 기준 정렬
        
        int answer = 0;
        for (int[] cost : costList) {
            int minCost = Integer.MAX_VALUE;
            int idx = -1;
            for (int i = 0; i < cost.length; i++) {
                if (picks[i] > 0 && cost[i] < minCost) {  // 피로도 가장 적게드는 곡괭이 사용
                    minCost = cost[i];
                    idx = i;
                }
            }
            picks[idx]--;
            answer += minCost;
            
            if (idx == -1) break;
        }
        
        return answer;
    }
}
