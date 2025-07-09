import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int[][] fatigue = {
            {1, 1, 1},   // 다이아 곡괭이
            {5, 1, 1},   // 철 곡괭이
            {25, 5, 1}   // 돌 곡괭이
        };

        Map<String, Integer> mineralIdx = Map.of(
            "diamond", 0,
            "iron", 1,
            "stone", 2
        );

        int totalPicks = picks[0] + picks[1] + picks[2];
        int chunkCount = Math.min((minerals.length + 4) / 5, totalPicks);

        // 각 chunk마다 다이아/철/돌로 캤을 때의 피로도를 저장
        List<int[]> chunks = new ArrayList<>();

        for (int i = 0; i < chunkCount; i++) {
            int[] costs = new int[3]; // [다이아, 철, 돌] 곡괭이로의 피로도
            for (int j = i * 5; j < i * 5 + 5 && j < minerals.length; j++) {
                int mIdx = mineralIdx.get(minerals[j]);
                for (int k = 0; k < 3; k++) {
                    costs[k] += fatigue[k][mIdx];
                }
            }
            chunks.add(costs);
        }

        // 돌 곡괭이 피로도 기준으로 내림차순 정렬
        chunks.sort((a, b) -> b[2] - a[2]);

        int answer = 0;
        int chunkIdx = 0;

        // 다이아, 철, 돌 순서로 chunk에 곡괭이 배정
        for (int pickType = 0; pickType < 3; pickType++) {
            while (picks[pickType] > 0 && chunkIdx < chunks.size()) {
                answer += chunks.get(chunkIdx)[pickType];
                picks[pickType]--;
                chunkIdx++;
            }
        }

        return answer;
    }
}
