class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix = new int[rows][columns];

        // 오 하 좌 상
        int[] dr = { 0, 1, 0, -1 };
        int[] dc = { 1, 0, -1, 0 };

        int t = 1;
        // 초기화
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = t++;
            }
        }

        int SIZE = queries.length;
        int count = 0;
        int cr = 0;
        int cc = 0;

        while (count <= SIZE - 1) {
            int[] current = queries[count];
            cr = current[0] - 1;
            cc = current[1] - 1;
            int d = 0;

            int min = Integer.MAX_VALUE;
            int nr = cr;
            int nc = cc;

            // 초기값 설정
            int temp = matrix[cr][cc];
            int k = 0;
            // 범위넘으면 방향전환
            while (k < 2 * ((current[2] - current[0]) + (current[3] - current[1]))) {

                // 다음방향갱신
                nr = cr + dr[d];
                nc = cc + dc[d];
                // 범위가 넘으면
                if (nr < (current[0] - 1) || nr > (current[2] - 1) || nc < (current[1] - 1) || nc > (current[3] - 1)) {
                    // 새로 초기화
                    d = (d + 1) % 4;

                    // 다음방향갱신
                    nr = cr + dr[d];
                    nc = cc + dc[d];

                }

                // 어찌됐든 배정
                int next = matrix[nr][nc];// +1칸은 다음턴에 다다음칸으로 이동
                matrix[nr][nc] = temp; // 현재 내 칸은 다음칸으로이동
                temp = next;
                // 최소값찾기
                min = Math.min(min, temp);

                cr = nr;
                cc = nc;
                k++;
            }
            answer[count] = min;
            count++;
        }

        return answer;
    }
}