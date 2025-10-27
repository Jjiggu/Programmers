import java.util.*;

class Solution {
    
    int n, half;
    int[][] dice;
    boolean[] sel;  // 선택 여부 (A가 고른 주사위)
    long bestWin = -1;  // 최대 승 
    int[] bestPick;  // 결과 
    
    public int[] solution(int[][] dice) {
        this.dice = dice;
        this.n = dice.length;
        this.half = n / 2;
        this.sel = new boolean[n];
        this.bestPick = new int[half];
        
        pick(0, 0);
        
        return bestPick;
    }
    
    private void pick(int idx, int picked) {
        if (picked == half) {
            evaluate();
            return;
        }
        if (idx == n) return;
        
        sel[idx] = true;
        pick(idx + 1, picked + 1);  // 고르는 경우
        
        sel[idx] = false;
        pick(idx + 1, picked);  // 고르지 않는 경우 
    }
    
    
    private void evaluate() {
        long[] distA = buildDist(true);
        long[] distB = buildDist(false);
        
        long[] prefB = new long[distB.length];
        long acc = 0;
        for (int s = 0; s < distB.length; s++) {
            acc += distB[s];
            prefB[s] = acc;
        }
        
        long wins = 0;
        int maxB = distB.length - 1;
        for (int s = 0; s < distA.length; s++) {
            long aCnt = distA[s];
            if (aCnt == 0) continue;
            if (maxB >= 0) { // 방어
                int idx = Math.min(s - 1, maxB);
                long less = (idx >= 0) ? prefB[idx] : 0;
                wins += aCnt * less;
            }
        }
        
        if (wins > bestWin || (wins == bestWin && lexicographicallyBetter())) {
            bestWin = wins;
            int[] pick = new int[half];
            int k = 0;
            for (int i = 0; i < n; i++) if (sel[i]) pick[k++] = i + 1;
            bestPick = pick;
        }
    }
    
    
    /**
    ** flag == true -> A가 고른 주사위, false -> B 
    ** 선택된 주사위들의 합이 s가 되는 경우의 수를 센 dist[s] 생성
    **/
    private long[] buildDist(boolean flag) {
        // dist[sum] = 경우의 수 
        long[] dist = new long[1];
        dist[0] = 1;  // 합 0을 만드는 경우 1개 (아무것도 굴리지 않음)
        
        for (int i = 0; i < n; i++) {
            if (sel[i] != flag) continue;
            
            int maxFace = 0;
            for (int f : dice[i]) maxFace = Math.max(maxFace, f);
            
            long[] next = new long[dist.length + maxFace];
            for (int s = 0; s < dist.length; s++) {
                long cnt = dist[s];
                if (cnt == 0) continue;
                for (int face : dice[i]) {
                    next[s + face] += cnt;
                }
            }
            dist = next;
        }
        return dist;
    }
    
    private boolean lexicographicallyBetter() {
        int[] cur = new int[half];
        int k = 0;
        for (int i = 0; i < n; i++) if (sel[i]) cur[k++] = i + 1;
        for (int i = 0; i < half; i++) {
            if (cur[i] != bestPick[i]) return cur[i] < bestPick[i];
        }
        return false;
    }
}