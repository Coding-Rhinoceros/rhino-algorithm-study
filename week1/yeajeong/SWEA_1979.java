

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {

		// todo 1. input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int test_case = Integer.parseInt(br.readLine());
	
		for (int tc = 0; tc < test_case; tc++) {
			int total = 0;
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] mm = new int[N][N];
			int[][] rowVisited = new int[N][N];
			int[][] colVisited = new int[N][N];

			sb.append("#" + (tc + 1) + " ");

			for (int i = 0; i < rowVisited[0].length; i++) {
				Arrays.fill(rowVisited[i], 0);
				Arrays.fill(colVisited[i], 0);

			}

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					mm[i][j] = Integer.parseInt(st.nextToken());
					if (mm[i][j] == 0) {
						rowVisited[i][j] = -1; // 검은칸은 -1로 초기화
						colVisited[i][j] = -1;
					}
				}
			}

			// todo 2: 전략. k는 2이상
			// 1. 가로로 탐색, 세로로 탐색,
			// visited 필수 행탐색했으면 +1, 열탐색시 +2
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {

					if (mm[i][j] == 1 && rowVisited[i][j] == 0) {
						int nc = j;

						int combo = 0;
						// 가로로 가라
						while (nc < N) {

							// 범위 초과시 break;

							// 행탐색 중 벽을만나면 break
							if (mm[i][nc] == 0)
								break;
							combo++;
							rowVisited[i][nc] += 1;
							nc += 1;

						} // end while
						if (combo == K) {
							total++;
						}

					}
					if (mm[i][j] == 1 && colVisited[i][j] == 0) {
						// 세로로 가라
						int combo = 0;
						int nr = i;
						while (nr < N) {

							if (nr >= N || mm[nr][j] == 0)
								break;
							combo++;
							colVisited[nr][j] += 1;
							nr += 1;
						} // end while
						if (combo == K)
							total++;
					}
				}
			}

	
			sb.append(total).append("\n");
		}

		System.out.println(sb);
	}
}
