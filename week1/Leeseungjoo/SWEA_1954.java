import java.util.*;
import java.io.*;

class SWEA_1954{
	
	static int[][] board;
	static int N;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			
			N = Integer.parseInt(br.readLine());
			
			board = new int[N][N];
			
			int num = 1;
			int changeDir = 0; //방향을 바꾼 횟수가 2번이면 리턴
			int x = 0;
			int y = 0;
			int idx = 0;
			board[x][y] = num++;
			
			while(changeDir < 2) {
				int nx = x + dx[idx];
				int ny = y + dy[idx];
				
				if(!inRange(nx,ny) || board[nx][ny] != 0) {
					idx = (idx+1) % 4; 
					changeDir++;
					continue;
				}
				board[nx][ny] = num++;
				
				x = nx;
				y = ny;
				changeDir = 0;
				
							
			}
			
			System.out.println("#" + tc);
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					sb.append(board[i][j]).append(" ");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			
		}
		
		
	}
	
	static boolean inRange(int x, int y) {
		return x>= 0 && x < N && y >= 0 && y < N;
	}
}