import java.util.*;

class Solution {
    static int n, r;
    static int maxWin = 0;
    static int[][] dice;
    static List<List<Integer>> combs = new ArrayList<>();
    static List<List<Integer>> result = new ArrayList<>();
    
    public int[] solution(int[][] dice) {
        n = dice.length;
        r = dice.length / 2;
        dice = dice;
        comb(n, r, 0, new ArrayList<>(), combs);
        
        for (List<Integer> aIdx : combs) {
            int[][] diceA = new int[r][6];
            int[][] diceB = new int[r][6];
            int ai = 0;
            int bi = 0;
            for (int i = 0; i < n; i++) {
                if (aIdx.contains(i)) diceA[ai++] = dice[i];
                else diceB[bi++] = dice[i];
            }
            List<Integer> sumA = new ArrayList<>();
            List<Integer> sumB = new ArrayList<>();
            getSum(diceA, 0, 0, sumA);
            getSum(diceB, 0, 0, sumB);
            
            int win = cntWin(sumA, sumB);
            if (win > maxWin) {
                maxWin = win;
                result.clear();
                result.add(new ArrayList<>(aIdx));
            } else if (win == maxWin) {
                result.add(new ArrayList<>(aIdx));
            }
        }
        
        result.sort((o1, o2) -> {
            for (int i = 0; i < o1.size(); i++) {
                if (!o1.get(i).equals(o2.get(i))) return o1.get(i) - o2.get(i);
            }
            return 0;
        });
        
        int[] answer = result.get(0).stream().mapToInt(i -> i + 1).toArray();
        return answer;
    }
    
    public void comb(int n, int r, int start, List<Integer> comb, List<List<Integer>> combs) {
        if (comb.size() == r) {
            combs.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i < n; i++) {
            comb.add(i);
            comb(n, r, i + 1, comb, combs);
            comb.remove(comb.size() - 1);
        }
    }
    
    public void getSum(int[][] dice, int idx, int sum, List<Integer> sumList) {
        if (idx == dice.length) {
            sumList.add(sum);
            return;
        }
        for (int face : dice[idx]) {
            getSum(dice, idx + 1, sum + face, sumList);
        }
    }
    
    public int cntWin(List<Integer> sumA, List<Integer> sumB) {
        Collections.sort(sumA);
        Collections.sort(sumB);
        
        int win = 0;
        int j = 0;
        for (int a : sumA) {
            while(j < sumB.size() && sumB.get(j) < a) j++;
            win += j;
        }
        return win;
    }
}