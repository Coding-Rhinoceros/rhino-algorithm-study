import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Week1_TwoSum {
	public static void main(String args[]) throws Exception {
		// 100개의 배열을 선언하고 다 더하기
		// 누적개념을 좀써서, 마지막배열엔 최종값만 들어 가게 하기

		// 입력받기
		int SIZE = 100;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();



		for (int tc = 0; tc < 10; tc++) {
			Integer.parseInt(br.readLine());
			int[][] inputMap = new int[100][100];

			for (int i = 0; i < SIZE; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < SIZE; j++) {
					inputMap[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int resultSum = 0;
			int resultRowSum = 0;
			int rowSum = 0;
			// 행
			for (int i = 0; i < SIZE; i++) {
				rowSum = 0;
				for (int j = 0; j < SIZE; j++) {
					rowSum += inputMap[i][j];
				}
				resultRowSum = Math.max(rowSum, resultRowSum);
			}

			// 열
			int resultColSum = 0;
			int colSum = 0;
			for (int i = 0; i < SIZE; i++) {
				colSum = 0;
				for (int j = 0; j < SIZE; j++) {
					colSum += inputMap[j][i];
				}
				resultColSum = Math.max(colSum, resultColSum);
			}

			resultSum = Math.max(resultColSum, resultRowSum);
			// 좌대각
			int crossSum = 0;
			for (int i = 0; i < SIZE; i++) {
				crossSum += inputMap[i][i];
			}
			resultSum = Math.max(resultSum, crossSum);

			// 우대각
			int crossSum2 = 0;
			for (int i = SIZE - 1; i >= 0; i--) {
				crossSum2 += inputMap[i][99 - i];
			}

			resultSum = Math.max(resultSum, crossSum2);

			sb.append("#").append(tc + 1).append(" ").append(resultSum).append("\n");

		}
		System.out.println(sb);
	}
}
