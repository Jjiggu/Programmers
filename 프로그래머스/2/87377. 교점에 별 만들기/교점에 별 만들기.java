import java.util.*;

class Solution {

    Set<List<Long>> set = new HashSet<>();
    long minX, maxX, minY, maxY;

    public String[] solution(int[][] line) {

        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                int[] a = line[i];
                int[] b = line[j];
                findIntersection(a[0], a[1], a[2], b[0], b[1], b[2]);
            }
        }

        findLen();

        int width = (int)(maxX - minX + 1);
        int height = (int)(maxY - minY + 1);

        String[][] arr = new String[height][width];
        for (int i = 0; i < height; i++) Arrays.fill(arr[i], ".");

        for (List<Long> pos : set) {
            long x = pos.get(0);
            long y = pos.get(1);

            int row = (int)(maxY - y);
            int col = (int)(x - minX);

            arr[row][col] = "*";
        }

        String[] answer = new String[height];
        for (int i = 0; i < height; i++) {
            answer[i] = String.join("", arr[i]);
        }

        return answer;
    }

    private void findLen() {
        minX = Long.MAX_VALUE; maxX = Long.MIN_VALUE;
        minY = Long.MAX_VALUE; maxY = Long.MIN_VALUE;

        for (List<Long> pos : set) {
            long x = pos.get(0);
            long y = pos.get(1);

            minX = Math.min(minX, x);
            maxX = Math.max(maxX, x);
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y);
        }
    }

    private void findIntersection(int A, int B, int E, int C, int D, int F) {

        long demon = 1L * A * D - 1L * B * C;
        if (demon == 0) return;

        long xNum = 1L * B * F - 1L * E * D;
        long yNum = 1L * E * C - 1L * A * F;

        if (xNum % demon != 0 || yNum % demon != 0) return;

        long x = xNum / demon;
        long y = yNum / demon;

        set.add(Arrays.asList(x, y));
    }
}
