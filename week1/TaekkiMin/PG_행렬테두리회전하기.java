// overwrite되어 복구불가 방지를 위해 임의의 값을 하나 지정하여 따로 변수에 저장
// 오른쪽, 왼쪽, 위, 아래로 회전, 4가지로 나눠 for문 진행
import java.io.*;
import java.util.*;

public class PG_행렬테두리회전하기 {

	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		int answerIdx = 0;

		// 행렬 만들기
		int num = 1;
		int[][] matrix = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				matrix[i][j] = num;

				num++;
			}
		}

		for (int[] query : queries) {

			// 배열 인덱스로 접근해야 함으로 1을 빼야함
			int x1 = query[0] - 1;
			int x2 = query[2] - 1;
			int y1 = query[1] - 1;
			int y2 = query[3] - 1;

			// 회전해서 생긴 overwrite로 인한 복구 불가 방지 차원에서
			// 하나 값만 따로 빼서 변수에 저장
			int firstNum = matrix[x1][y2];
			int min = firstNum; // 최솟값

			// 오른쪽으로 회전(상단)
			for (int c = y2 - 1; c >= y1; c--) {
				min = Math.min(min, matrix[x1][c]);

				matrix[x1][c + 1] = matrix[x1][c];
			}

			// 위로 회전(좌측)
			for (int r = x1 + 1; r <= x2; r++) {
				min = Math.min(min, matrix[r][y1]);

				matrix[r - 1][y1] = matrix[r][y1];
			}

			// 왼쪽으로 회전(하단)
			for (int c = y1 + 1; c <= y2; c++) {
				min = Math.min(min, matrix[x2][c]);

				matrix[x2][c - 1] = matrix[x2][c];
			}

			// 아래로 회전(우측)
			for (int r = x2 - 1; r >= x1; r--) {
				min = Math.min(min, matrix[r][y2]);

				matrix[r + 1][y2] = matrix[r][y2];
			}

			matrix[x1 + 1][y2] = firstNum; // 저장해 둔 값을 마지막 남은 칸에 저장
			answer[answerIdx] = min;
			answerIdx++; // 다음 query를 위해 이동
		}

		return answer;
	}

}
