import java.util.*;

class Solution {

    static ArrayList<Integer>[] graph;
    static int maxSheep = 0;

    public int solution(int[] info, int[][] edges) {
        int n = info.length;
        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
        }

        List<Integer> nextNodes = new ArrayList<>();
        nextNodes.add(0);

        dfs(0, 0, 0, nextNodes, info);

        return maxSheep;
    }

    public void dfs(int current, int sheep, int wolf, List<Integer> nextNodes, int[] info) {
        if (info[current] == 0) sheep++;
        else wolf++;

        if (wolf >= sheep) return;  // 조건 위배 시 종료

        maxSheep = Math.max(maxSheep, sheep);  // 최대값 갱신

        List<Integer> candidates = new ArrayList<>(nextNodes);
        candidates.remove(Integer.valueOf(current)); // 현재 노드 제거

        // 현재 노드에서 갈 수 있는 자식 노드 추가
        for (int next : graph[current]) {
            candidates.add(next);
        }

        for (int next : candidates) {
            dfs(next, sheep, wolf, candidates, info);
        }
    }
}
