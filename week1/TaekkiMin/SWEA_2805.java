// 2805. 농작물 수확히기
// 가운데 행을 기준
// * 첫 번째 행: 가운데 1칸
// * 두 번째 행: 가운데 기준 좌우로 1칸씩 넓어져서 3칸
// * 가운데 행: 전체 N칸
// * 그다음부터는 다시 2칸씩 줄어듦
import java.io.*;
import java.util.*;

public class SWEA_2805 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());

			// 배열에 값 입력
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < N; j++) {
					arr[i][j] = line.charAt(j) - '0';
				}
			}

			int sum = 0;
			int middle = N / 2;
			for (int r = 0; r < N; r++) {
				// 1, 3, 5, 7, 5, 3, 1
				int startCol;
				int endCol;
				
				// 가운데를 기준으로 시작점과 끝점 구하기
				if (r < middle) { // 가운데 행 이전
					startCol = middle - r;
					endCol = middle + r;
				} 
				
				else if(r > middle) { // 후반 행일 경우
					startCol = middle - (N - r - 1);
					endCol = middle + (N - r - 1);
				} 
				
				else { // 가운데 행 이후
					startCol = 0;
					endCol = N - 1;
				}
				
				// 구한 시작점과 끝점으로 합 구하기
				for(int c = startCol; c <= endCol; c++) {
					sum += arr[r][c];
				}
			}
			
			// 테스트케이스별 출력
			sb.append("#").append(tc).append(" ").append(sum).append("\n");
		}

		System.out.print(sb);

	}

}
