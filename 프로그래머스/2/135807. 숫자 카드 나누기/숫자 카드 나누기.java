class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int numA = findGcd(arrayA);
        int numB = findGcd(arrayB);

        // numA가 arrayB의 모든 원소를 나누지 않는지 확인
        boolean isNumAValid = true;
        for (int num : arrayB) {
            if (num % numA == 0) {
                isNumAValid = false;
                break;
            }
        }

        // numB가 arrayA의 모든 원소를 나누지 않는지 확인
        boolean isNumBValid = true;
        for (int num : arrayA) {
            if (num % numB == 0) {
                isNumBValid = false;
                break;
            }
        }

        // 조건을 만족하는 최대값 반환
        int resultA = isNumAValid ? numA : 0;
        int resultB = isNumBValid ? numB : 0;

        return Math.max(resultA, resultB);
    }

    // 유클리드 호제법을 이용한 GCD 계산
    public static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }

    // 배열의 GCD를 구하는 메서드
    public static int findGcd(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
    }
}
