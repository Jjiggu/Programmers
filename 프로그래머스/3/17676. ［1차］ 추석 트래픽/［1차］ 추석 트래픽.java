class Solution {
    public int solution(String[] lines) {
        int n = lines.length;
        int[] starts = new int[n];
        int[] ends = new int[n];
        
        int idx = 0;
        for (String line : lines) {
            String[] parts = line.split(" ");
            String[] hms = parts[1].split(":");
            int hour = Integer.parseInt(hms[0]);
            int min = Integer.parseInt(hms[1]);
            double sec = Double.parseDouble(hms[2]);
            int endTime = (int)((hour * 3600 + min * 60 + sec) * 1000);
            
            double duration = Double.parseDouble(parts[2].replace("s", ""));
            int startTime = (int)(endTime - duration * 1000 + 1);
            
            starts[idx] = startTime;
            ends[idx] = endTime;
            idx++;
        }
        
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int intervalStart = ends[i];
            int intervalEnd = intervalStart + 999;
            
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (starts[j] <= intervalEnd && ends[j] >= intervalStart) {
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        }
        
        return answer;
    }
}
