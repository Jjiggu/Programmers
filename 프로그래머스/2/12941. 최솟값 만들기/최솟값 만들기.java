import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {   
        int result = 0;
        
        // 각 배열 오름차순, 내림차순 
        Arrays.sort(A);
        
        Integer[] tmp = Arrays.stream(B).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, Collections.reverseOrder());
        
        
        // 배열 돌면서 인덱스별로 계산
        for (int i = 0; i < A.length; i++) {
            int nowSum = A[i] * tmp[i];
            result += nowSum;
        }
        
        // 계산 값 return 
        return result;
    }
}