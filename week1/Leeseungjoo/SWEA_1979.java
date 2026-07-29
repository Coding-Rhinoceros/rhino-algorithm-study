import java.io.*;
import java.util.*;

public class SWEA_1979 {

    public static void main(String[] args) throws IOException {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] board = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;

            // 가로 검사
            for (int i = 0; i < N; i++) {

                int count = 0;

                for (int j = 0; j < N; j++) {

                    if (board[i][j] == 1) {
                        count++;
                    } else {
                        if (count == K) {
                            answer++;
                        }

                        count = 0;
                    }
                }

                // 행 끝까지 1이 이어진 경우
                if (count == K) {
                    answer++;
                }
            }

            // 세로 검사
            for (int j = 0; j < N; j++) {

                int count = 0;

                for (int i = 0; i < N; i++) {

                    if (board[i][j] == 1) {
                        count++;
                    } else {
                        if (count == K) {
                            answer++;
                        }

                        count = 0;
                    }
                }

                // 열 끝까지 1이 이어진 경우
                if (count == K) {
                    answer++;
                }
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}