import java.util.*;

publis class PGS_게임맵최단거리 {
    // 상, 하, 좌, 우
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] maps) {
        int row = maps.length;
        int col = maps[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        
        int[][] distance = new int[row][col]; // 현재 위치까지의 거리
        for(int i = 0; i < row; i++) { // 모든 칸에 1로 초기화
            Arrays.fill(distance[i], 1);
        }
        
        boolean[][] visited = new boolean[row][col]; // 방문 처리
        
        // 시작 위치를 큐에 저장한 후 방문 처리
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        
        while(!queue.isEmpty()) {
            // 현재 위치 가져오기
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            
            for(int dir = 0; dir < 4; dir++) {
                // 상하좌우로 이동
                int nr = r + dr[dir];
                int nc = c + dc[dir];
                
                // 맵의 범위 안이고 벽이 아니고 방문하지 않은 칸이라면, 방문 처리
                if(nr < 0 || nr >= row || nc < 0 || nc >= col
                  || maps[nr][nc] == 0 || visited[nr][nc]) {
                    continue;
                }
                
                queue.offer(new int[]{nr, nc});
                visited[nr][nc] = true;
                distance[nr][nc] += distance[r][c]; // 이전 거리와 합쳐서 추가
            }
        }
        
        if(distance[row-1][col-1] == 1) {
            return -1;
        } else {
            return distance[row-1][col-1];
        }
    }
}