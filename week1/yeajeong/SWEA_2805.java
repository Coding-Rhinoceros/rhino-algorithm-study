
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int test_case = Integer.parseInt(st.nextToken());

		for (int tc = 0; tc < test_case; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			sb.append("#" + (tc + 1)).append(" ");

			int[][] map = new int[N][N];

			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j) - '0';
				}
			}

			int base = N / 2;
			int subBase = 0;
			int total = 0;
			for (int i = 0; i < N; i++) {
				int start = base - subBase;
				int end = base + subBase;
				
				for (int j = start; j <= end; j++) {
					total += map[i][j];

				}

				// i로 컨트롤 하는 것보다, subBase를 만들어 변화에 대응
				if (i >= base) {
					subBase--;
				} else {
					subBase++;
				}

			}
			sb.append(total).append("\n");
		}

		System.out.println(sb);
	}
}
