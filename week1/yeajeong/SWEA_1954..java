import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.out.println("start");
		// TC
		// 3
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test_case = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		System.out.println(test_case);
		for (int tc = 0; tc < test_case; tc++) {

			int N = Integer.parseInt(br.readLine());
			sb.append("#" + (tc + 1) + "\n");
			int[][] snail = new int[N][N];
			int value = 1;

			int top = 0;
			int bottom = N - 1;
			int left = 0;
			int right = N - 1;

			for (int layer = 0; layer < (N + 1) / 2; layer++) {
				top = layer;
				bottom = N - 1 - layer;
				left = layer;
				right = N - 1 - layer;

				// 왼 ->우
				for (int c = left; c <= right; c++) {
					snail[top][c] = value++;
				}

				// 상 -> 하
				for (int r = top + 1; r <= bottom; r++) {
					snail[r][right] = value++;
				}

				// 왼 <- 우
				for (int c = right - 1; c >= left; c--) {
					snail[bottom][c] = value++;
				}

				// 하->상
				for (int r = bottom - 1; r > top; r--) {
					snail[r][left] = value++;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					sb.append(snail[i][j] + " ");
				}
				sb.append("\n");
			}

		}

		System.out.println(sb);
	}

}
