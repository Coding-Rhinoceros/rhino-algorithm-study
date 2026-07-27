import java.util.*;
import java.io.*;

public class SWEA_1209 {

    static int[][] board;
    static int maxSum;

    public static void main(String[] args) throws IOException {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        for (int tc = 1; tc <= 10; tc++) {

            int testCaseNumber = Integer.parseInt(br.readLine());

            maxSum = Integer.MIN_VALUE;
            board = new int[100][100];

            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < 100; j++) {
                    board[i][j] =
                            Integer.parseInt(st.nextToken());
                }
            }

            sumRow();
            sumCol();
            sumDiagonal();

            System.out.println(
                    "#" + testCaseNumber + " " + maxSum
            );
        }
    }

    static void sumRow() {

        for (int i = 0; i < 100; i++) {
            int tempSum = 0;

            for (int j = 0; j < 100; j++) {
                tempSum += board[i][j];
            }

            maxSum = Math.max(maxSum, tempSum);
        }
    }

    static void sumCol() {

        for (int j = 0; j < 100; j++) {
            int tempSum = 0;

            for (int i = 0; i < 100; i++) {
                tempSum += board[i][j];
            }

            maxSum = Math.max(maxSum, tempSum);
        }
    }

    static void sumDiagonal() {

        int leftDiagonal = 0;
        int rightDiagonal = 0;

        for (int i = 0; i < 100; i++) {
            // 왼쪽 위 → 오른쪽 아래
            leftDiagonal += board[i][i];

            // 오른쪽 위 → 왼쪽 아래
            rightDiagonal += board[i][99 - i];
        }

        maxSum = Math.max(maxSum, leftDiagonal);
        maxSum = Math.max(maxSum, rightDiagonal);
    }
}