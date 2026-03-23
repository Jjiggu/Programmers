import java.util.*;

class Solution {
    
    static class Group {
        int dia;
        int iron;
        int stone;
        
        public Group(int dia, int iron, int stone) {
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
        }
    }
    
    public int solution(int[] picks, String[] minerals) {
        int maxMinerals = getMaxMinerals(picks);
        List<Group> mineralList = cntMinerals(minerals, maxMinerals);
        
        mineralList.sort((o1, o2) -> {
            if (o1.dia != o2.dia) return o2.dia - o1.dia;
            if (o1.iron != o2.iron) return o2.iron - o1.iron;
            return o2.stone - o1.stone;
        });
        
        
        return mining(mineralList, picks);
    }
    
    private int mining(List<Group> mineralList, int[] picks) {
        int answer = 0;
        
        for (Group g : mineralList) {
            if (picks[0] > 0) {
                picks[0]--;
                answer += calcTired(g, 0);
            } else if (picks[1] > 0) {
                picks[1]--;
                answer += calcTired(g, 1);
            } else if (picks[2] > 0) {
                picks[2]--;
                answer += calcTired(g, 2);
            } 
        }
        
        return answer;
    }
    
    private int calcTired(Group g, int type) {
        int dia = g.dia;
        int iron = g.iron;
        int stone = g.stone;
        
        if (type == 0) return dia + iron + stone;
        else if (type == 1) return 5 * dia + iron + stone;
        else return 25 * dia + 5 * iron + stone;
    }
    
    private List<Group> cntMinerals(String[] minerals, int maxMinerals) {
        List<Group> list = new ArrayList<>();
        int limit = Math.min(minerals.length, maxMinerals);
        
        for (int i = 0; i < limit; i+=5) {
            int diaCnt = 0;
            int ironCnt = 0;
            int stoneCnt = 0;
            
            for (int j = i; j < i + 5 && j < limit; j++) {
                String mine = minerals[j];
            
                if (mine.equals("diamond")) diaCnt++;
                else if (mine.equals("iron")) ironCnt++;
                else stoneCnt++;   
            }
            list.add(new Group(diaCnt, ironCnt, stoneCnt));
        }
        
        return list;
    }
    
    private int getMaxMinerals(int[] picks) {
        return (picks[0] + picks[1] + picks[2]) * 5;
    }
}