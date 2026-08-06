
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;



public class Solution {
	static int[][] dr = { {}, { -1, 1, 0, 0 }, { -1, 1 }, { 0, 0 }, { -1, 0 }, { 1, 0 }, { 1, 0 }, { -1, 0 } };
	static int[][] dc = { {}, { 0, 0, -1, 1 }, { 0, 0 }, { -1, 1 }, { 0, 1 }, { 0, 1 }, { 0, -1 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			sb.append("#" + tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int startR = Integer.parseInt(st.nextToken());
			int startC = Integer.parseInt(st.nextToken());
			int timeLimit = Integer.parseInt(st.nextToken());
			int[][] vis = new int[N][M];
			int[][] map = new int[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			Queue<int[]> q = new ArrayDeque<int[]>();
			q.offer(new int[] { startR, startC, 1 });
			vis[startR][startC] = 1;

			while (!q.isEmpty()) {
				int[] c = q.poll();
				int cr = c[0];
				int cc = c[1];
				int ct = c[2];

				int nr = cr;
				int nc = cc;
				int type = map[cr][cc];


				for (int d = 0; d < dr[type].length; d++) {
					nr = cr + dr[type][d];
					nc = cc + dc[type][d];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M)
						continue;
					if (map[nr][nc] == 0 || vis[nr][nc] == 1 || ct + 1 > timeLimit)
						continue;

					int nextType = map[nr][nc];

					if (!isGo(nextType, dr[type][d],dc[type][d]))
						continue;
					// BFS이므로 처음 방문한 시간이 가장 빠른 시간이다.
					// 큐에 중복 삽입되지 않도록 넣는 순간 방문 처리한다.
					q.offer(new int[] { nr, nc, ct + 1 });
					vis[nr][nc] = 1;
				}

			} // end while

			int total = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					total += vis[i][j];
				}
			}

			sb.append(total).append("\n");

		}
		System.out.println(sb);

	}

	public static boolean isGo(int type1, int needR, int needC) {

		for (int i = 0; i < dr[type1].length; i++) {
			int r = dr[type1][i];
			int c = dc[type1][i];
			if (r == -needR && c == -needC)
				return true;

		}

		return false;
	}
}
package codingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;



public class Solution {
	static int[][] dr = { {}, { -1, 1, 0, 0 }, { -1, 1 }, { 0, 0 }, { -1, 0 }, { 1, 0 }, { 1, 0 }, { -1, 0 } };
	static int[][] dc = { {}, { 0, 0, -1, 1 }, { 0, 0 }, { -1, 1 }, { 0, 1 }, { 0, 1 }, { 0, -1 }, { 0, -1 } };

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			sb.append("#" + tc).append(" ");
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int startR = Integer.parseInt(st.nextToken());
			int startC = Integer.parseInt(st.nextToken());
			int timeLimit = Integer.parseInt(st.nextToken());
			int[][] vis = new int[N][M];
			int[][] map = new int[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			Queue<int[]> q = new ArrayDeque<int[]>();
			q.offer(new int[] { startR, startC, 1 });
			vis[startR][startC] = 1;

			while (!q.isEmpty()) {
				int[] c = q.poll();
				int cr = c[0];
				int cc = c[1];
				int ct = c[2];

				int nr = cr;
				int nc = cc;
				int type = map[cr][cc];


				for (int d = 0; d < dr[type].length; d++) {
					nr = cr + dr[type][d];
					nc = cc + dc[type][d];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M)
						continue;
					if (map[nr][nc] == 0 || vis[nr][nc] == 1 || ct + 1 > timeLimit)
						continue;

					int nextType = map[nr][nc];

					if (!isGo(nextType, dr[type][d],dc[type][d]))
						continue;
					// BFS이므로 처음 방문한 시간이 가장 빠른 시간이다.
					// 큐에 중복 삽입되지 않도록 넣는 순간 방문 처리한다.
					q.offer(new int[] { nr, nc, ct + 1 });
					vis[nr][nc] = 1;
				}

			} // end while

			int total = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					total += vis[i][j];
				}
			}

			sb.append(total).append("\n");

		}
		System.out.println(sb);

	}

	public static boolean isGo(int type1, int needR, int needC) {

		for (int i = 0; i < dr[type1].length; i++) {
			int r = dr[type1][i];
			int c = dc[type1][i];
			if (r == -needR && c == -needC)
				return true;

		}

		return false;
	}
}
