import java.util.*;
import java.io.*; 

class SWEA_1954 {
	    public static void main(String args[]) throws IOException {
		
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
        StringBuilder sb = new StringBuilder(); // 출력
         
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 입력
         
        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
             
            int[] dr = {0, 1, 0, -1}; // 우 하 좌 상 순
            int[] dc = {1, 0, -1, 0};
             
            int[][] snail = new int[N][N];
            int row = 0;
            int col = 0;
            int dist = 0;
            for(int i = 1; i <= N*N; i++) {
                snail[row][col] = i;
                 
                // 행과 열 값 이동
                row += dr[dist];
                col += dc[dist];
                 
                // 범위 값을 넘어버리거나 이미 숫자가 채워질 경우
                if(row < 0 || row >= N || col < 0 || col >= N || snail[row][col] != 0) {
                    // 기존 이동 취소
                    row -= dr[dist];
                    col -= dc[dist];
                         
                    dist = (dist + 1) % 4; // 방향 전환
                     
                    // 방향 전환 후 이동
                    row += dr[dist];
                    col += dc[dist];
                }
            }
             
            // 출력
            sb.append("#").append(tc).append("\n");
            for(int r = 0; r < N; r++) {
                for(int c = 0; c < N; c++) {
                    sb.append(snail[r][c]).append(" ");
                }
                sb.append("\n");
            }
        }
         
        System.out.print(sb);
    }
}