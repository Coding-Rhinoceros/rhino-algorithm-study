package week1;

import java.util.*;
import java.io.*;

public class SWEA_1979 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken()); // 가로, 세로 길이
			int K = Integer.parseInt(st.nextToken()); // 단어 길이

			int answer = 0;

			// 퍼즐에 값 입력
			int[][] puzzle = new int[N][N];
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < N; c++) {
					puzzle[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N; i++) {
				int rowCount = 0;
				int colCount = 0;

				// 가로
				for (int j = 0; j < N; j++) {
					if (puzzle[i][j] == 1)
						rowCount++;
					else { // 다음 칸이 검은색일 경우
						if (rowCount == K) {
							answer++;
						}
						rowCount = 0;
					}
				}

				// 세로
				for (int k = 0; k < N; k++) {
					if (puzzle[k][i] == 1)
						colCount++;
					else { // 다음 칸이 검은색일 경우
						if (colCount == K) {
							answer++;
						}
						colCount = 0;
					}
				}

				if (rowCount == K)
					answer++;
				if (colCount == K)
					answer++;
			}

			sb.append("#").append(test_case).append(" ").append(answer).append("\n");
		}

		System.out.println(sb);
	}
}
