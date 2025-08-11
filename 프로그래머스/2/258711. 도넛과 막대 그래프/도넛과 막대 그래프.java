import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        // 1) 노드 라벨 압축: id -> 0..K-1
        HashSet<Integer> ids = new HashSet<>();
        for (int[] e : edges) {
            ids.add(e[0]);
            ids.add(e[1]);
        }
        int K = ids.size();
        int[] idList = new int[K];
        int p = 0;
        for (int id : ids) idList[p++] = id;
        Arrays.sort(idList); // (정렬은 선택이지만 디버깅 편의용)

        HashMap<Integer, Integer> toIdx = new HashMap<>(K * 2);
        for (int i = 0; i < K; i++) toIdx.put(idList[i], i);

        // 2) 차수 집계
        int[] indeg = new int[K];
        int[] outdeg = new int[K];
        for (int[] e : edges) {
            int u = toIdx.get(e[0]);
            int v = toIdx.get(e[1]);
            outdeg[u]++;
            indeg[v]++;
        }

        // 3) 생성 정점(gen): indeg==0 && outdeg>=2 (유일)
        int genIdx = -1;
        for (int i = 0; i < K; i++) {
            if (indeg[i] == 0 && outdeg[i] >= 2) {
                genIdx = i;
                break; // 유일하다고 보장됨
            }
        }
        int genId = idList[genIdx];

        // 4) 분류: 막대(out==0), 8자(in>=2 && out>=2), 도넛는 나머지
        int bars = 0, eights = 0;
        for (int i = 0; i < K; i++) {
            if (i == genIdx) continue;
            if (outdeg[i] == 0) bars++;
            if (indeg[i] >= 2 && outdeg[i] >= 2) eights++;
        }
        int donuts = outdeg[genIdx] - bars - eights;

        // 반환: [생성 정점 라벨, 도넛 수, 막대 수, 8자 수]
        return new int[]{genId, donuts, bars, eights};
    }
}
