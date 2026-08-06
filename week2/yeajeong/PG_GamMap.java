import java.util.*;

class Solution {
    /*
     * 목표지점에 도착하는 최단거리, BFS 기본문제 같다.
     * 처음 캐릭터의 좌표랑, RETURN값만 잘 주면 될 것 같다.
     * 
     * 1.큐생성,
     * 2.시작좌표 넣기
     * 3. count좌표로 이동시마다 판별
     * 4. 리턴시 값 -1 주기
     */

    public int solution(int[][] maps) {
        int answer = 0;
        int N = maps.length;
        int M = maps[0].length;
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1, };

        Queue<int[]> q = new ArrayDeque<int[]>();
        int[][] vis = new int[N][M];

        q.offer(new int[] { 0, 0 });
        vis[0][0] = 1;

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cr = current[0];
            int cc = current[1];

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                // 범위 초과 및 벽만나면 break;
                if (nr < 0 || nr >= N || nc < 0 || nc >= M || maps[nr][nc] == 0)
                    continue;
                if (vis[nr][nc] > 0)
                    continue;
                vis[nr][nc] = vis[cr][cc] + 1;
                q.offer(new int[] { nr, nc });
            }

        } // while

        return vis[N - 1][M - 1] == 0 ? -1 : vis[N - 1][M - 1];
    }
}