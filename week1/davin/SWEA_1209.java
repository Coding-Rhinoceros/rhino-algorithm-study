import java.util.*;
import java.io.*;

public class SWEA_1209 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= 10; i++) {
			int t = Integer.parseInt(br.readLine());
			int[][] nums = new int[100][100];
			for (int j = 0; j < 100; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 100; k++) {
					nums[j][k] = Integer.parseInt(st.nextToken());
				}
			}

			int[] row = new int[100];
			int[] column = new int[100];
			int diagonal1 = 0;
			int diagonal2 = 0;

			//행
			for (int j = 0; j < 100; j++) {
				for (int k = 0; k < 100; k++) {
					row[j] += nums[j][k];
				}
			}
			
			int rowMax=0;
			for (int j = 0; j < 100; j++) {
				rowMax = Math.max(rowMax, row[j]);
			}
			
			//열
			for (int j = 0; j < 100; j++) {
				for (int k = 0; k < 100; k++) {
					column[j] += nums[k][j];
				}
			}
			
			int columnMax=0;
			for (int j = 0; j < 100; j++) {
				columnMax = Math.max(columnMax, column[j]);
			}
			
			//우하향 대각선
			for (int j = 0; j < 100; j++) {
				diagonal1 += nums[j][j];
			}
			
			// 우상향 대각선
			for (int j = 0; j < 100; j++) {
				diagonal2 += nums[j][99-j];
			}
			
			int ansMax = Math.max(columnMax, Math.max(rowMax, Math.max(diagonal1, diagonal2))) ;
			
			sb.append("#").append(t).append(" ").append(ansMax).append("\n");
		}
		
		System.out.println(sb);
	}

}
