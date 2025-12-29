import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        List<String[]> fileList = new ArrayList<>();
        
        for (String file : files) {
            String[] part = splitFile(file);
            fileList.add(part);
        }
        
        fileList.sort(Comparator
                      .comparing((String[] arr) -> arr[0].toLowerCase())
                      .thenComparing(arr -> Integer.parseInt(arr[1]))
                     );
        
        ArrayList<String> answer = new ArrayList<>();
        
        for (String[] s : fileList) {
            StringBuilder sb = new StringBuilder();
            sb.append(s[0]).append(s[1]).append(s[2]);
            answer.add(sb.toString());
        }
        
        return answer.toArray(new String[0]);
    }
    
    private String[] splitFile(String file) {
        int startDigit = -1;
        for (int i = 0; i < file.length(); i++) {
            if (Character.isDigit(file.charAt(i))) {
                startDigit = i;
                break;
            }
        }
        
        int endDigit = startDigit;
        while (endDigit < file.length() && Character.isDigit(file.charAt(endDigit))) endDigit++;
        
        String prefix = file.substring(0, startDigit);
        String number = file.substring(startDigit, endDigit);
        String suffix = file.substring(endDigit);
        
        return new String[]{prefix, number, suffix};
    }
}