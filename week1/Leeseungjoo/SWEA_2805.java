import java.util.*;
import java.io.*;


public class SWEA_2805 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
	
		
		for(int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] board = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				String line = br.readLine();
				for(int j = 0; j < N; j++) {
					board[i][j] = line.charAt(j) - '0';
				}
			}
			
			int sum = 0;
			int s = N/2;
			int e = N/2;
			
			for(int i = 0; i  < N; i++) {
				if(i < N/2) {
					for(int a = s; a <e+1; a++) {
						sum+=board[i][a];
						
					}
					s--;
					e++;
				}else {
					
					for(int a = s; a <e+1; a++) {
						sum+=board[i][a];
						
					}
					s++;
					e--;
					
				}
			}
			
			System.out.println("#" + tc + " " + sum);
			
		}
		
	}

}
