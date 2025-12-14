class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length;        // arr1 행
        int m = arr1[0].length;     // arr1 열 = arr2 행
        int p = arr2[0].length;     // arr2 열

        int[][] answer = new int[n][p];

        for (int i = 0; i < n; i++) {         // 행
            for (int j = 0; j < p; j++) {     // 열
                int sum = 0;
                for (int k = 0; k < m; k++) { // 중간 축
                    sum += arr1[i][k] * arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }

        return answer;
    }
}