import java.util.*;

class Solution {
    static ArrayList<Integer> result;
    static int[][] map;

    public int[] solution(int rows, int columns, int[][] queries) {
        result = new ArrayList<>();
        map = new int[rows][columns];

        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = num++;
            }
        }

        for (int[] current : queries) {
            simulation(current);
        }

        int[] arr = new int[queries.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = result.get(i);
        }

        return arr;
    }

    static void simulation(int[] current) {
        int startX = current[0] - 1;
        int startY = current[1] - 1;
        int endX = current[2] - 1;
        int endY = current[3] - 1;

        int temp = map[startX][startY];
        int min = temp;

        for (int i = startX + 1; i <= endX; i++) {
            map[i - 1][startY] = map[i][startY];
            min = Math.min(min, map[i][startY]);
        }

        for (int i = startY + 1; i <= endY; i++) {
            map[endX][i - 1] = map[endX][i];
            min = Math.min(min, map[endX][i]);
        }

        for (int i = endX - 1; i >= startX; i--) {
            map[i + 1][endY] = map[i][endY];
            min = Math.min(min, map[i][endY]);
        }

        for (int i = endY - 1; i > startY; i--) {
            map[startX][i + 1] = map[startX][i];
            min = Math.min(min, map[startX][i]);
        }

        map[startX][startY + 1] = temp;

        result.add(min);
    }
}