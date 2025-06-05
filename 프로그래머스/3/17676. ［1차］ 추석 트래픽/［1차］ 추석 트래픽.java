class Solution {
    public int solution(String[] lines) {
        int n = lines.length;
        int[] starts = new int[n];
        int[] ends = new int[n];

        for (int i = 0; i < n; i++) {
            String[] parts = lines[i].split(" ");
            String[] hms = parts[1].split(":");
            int hour = Integer.parseInt(hms[0]);
            int minute = Integer.parseInt(hms[1]);
            double second = Double.parseDouble(hms[2]);
            int endTime = (int) ((hour * 3600 + minute * 60 + second) * 1000);

            double duration = Double.parseDouble(parts[2].replace("s", ""));
            int startTime = (int) (endTime - duration * 1000 + 1);

            starts[i] = startTime;
            ends[i] = endTime;
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int intervalStart = ends[i];
            int intervalEnd = intervalStart + 1000 - 1; 

            int count = 0;
            for (int j = 0; j < n; j++) {
                if (starts[j] <= intervalEnd && ends[j] >= intervalStart) {
                    count++;
                }
            }
            answer = Math.max(answer, count);
        }
        
        return answer;
    }
}
