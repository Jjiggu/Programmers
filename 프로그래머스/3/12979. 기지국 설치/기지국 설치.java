class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int left = 1;
        
        for(int i = 0; i < stations.length; i++) {
            if(left < stations[i] - w) {
                answer += countStationsNeeded(left, stations[i] - w - 1, w);   
            }
            
            left = stations[i] + w + 1;
        }
        
        if(stations[stations.length - 1] + w < n) {
            answer += countStationsNeeded(stations[stations.length - 1] + w + 1, n, w);
        }

        return answer;
    }
    
    
    public int countStationsNeeded(int left, int right, int w) {
        int res = (right - left + 1) / (2 * w + 1);
        
        if((right - left + 1) % (2 * w + 1) > 0) res++;
        
        return res;
    }
}