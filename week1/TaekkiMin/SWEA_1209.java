import java.util.*;
import java.io.*;

public class SWEA_1209 {
	public static void main(String args[]) throws Exception {
	     
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력
        StringBuilder sb = new StringBuilder(); // 출력
 
        // 배열 값 입력
        for(int tc = 1; tc <= 10; tc++) {
             int test_case = Integer.parseInt(br.readLine()); // 테스트 케이스
             
            int[][] array = new int[100][100];
            for(int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++) {
                    array[i][j] = Integer.parseInt(st.nextToken());
                }
            }       
             
            int max_sum = 0;
             
            // 행의 합
            for(int row = 0; row < 100; row++) {
                int rowSum = 0;
                for(int col = 0; col < 100; col++) {
                    rowSum += array[row][col];
                }
                max_sum = Math.max(max_sum, rowSum);
            }
             
            // 열의 합
            for(int col = 0; col < 100; col++) {
                int colSum = 0;
                for(int row = 0; row < 100; row++) {
                    colSum += array[row][col];
                }
                max_sum = Math.max(max_sum, colSum);
            }
             
            // 대각선
            int diagnol1 = 0;
            int diagnol2 = 0;
            for(int row = 0; row < 100; row++) {
                for(int col = 0; col < 100; col++) {
                    // 좌측 상단 -> 우측 하단
                    if(row == col) diagnol1 += array[row][col];
                     
                    if(row + col == 99) diagnol2 += array[row][col];
                }
                max_sum = Math.max(max_sum, diagnol1);
                max_sum = Math.max(max_sum, diagnol2);
            }
             
            sb.append("#").append(test_case).append(" ").append(max_sum).append("\n");
        }
         
        System.out.print(sb);
    }
}
