class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++) {
            // String binary1 = Integer.toBinaryString(arr1[i]);
            // String binary2 = Integer.toBinaryString(arr2[i]);
            String binary1 = String.format("%" + n + "s", Integer.toBinaryString(arr1[i])).replace(' ', '0');
            String binary2 = String.format("%" + n + "s", Integer.toBinaryString(arr2[i])).replace(' ', '0');
            StringBuilder sb = new StringBuilder();
            
            for (int k = 0; k < binary1.length(); k++) {
                if (binary1.charAt(k) == '1' || binary2.charAt(k) == '1') {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}