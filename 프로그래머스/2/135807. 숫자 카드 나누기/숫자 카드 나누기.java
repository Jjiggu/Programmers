class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int numA = findGcd(arrayA);
        int numB = findGcd(arrayB);
        
        boolean isNumAValid = true;
        boolean isNumBValid = true;
        
        for (int num : arrayA) {
            if (num % numB == 0) {
                isNumBValid = false;
                break;
            }
        }
        
        for (int num : arrayB) {
            if (num % numA == 0) {
                isNumAValid = false;
                break;
            }
        }
        
        int resultA = isNumAValid ? numA : 0;
        int resultB = isNumBValid ? numB : 0;
        
        return Math.max(resultA, resultB);
    }
    
    private int findGcd(int[] arr) {
        int result = arr[0];
        
        for (int i = 1; i < arr.length; i++) result = gcd(result, arr[i]);
        
        return result;
    }
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        
        return a;
    }
}