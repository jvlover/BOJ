import java.util.*;
class Solution {
    int N, M;
    int[][] maps, delta = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int solution(int[][] maps) {
        this.maps = maps;
        this.N = maps.length;
        this.M = maps[0].length;
        return bfs();
    }
    int bfs() {
        Queue<int[]> q = new LinkedList<>();
        int[][] visit = new int[N][M];
        q.offer(new int[] {0, 0});
        visit[0][0] = 1;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == N-1 && now[1] == M-1) return visit[N-1][M-1];
            for (int i = 0; i < 4; ++i) {
                int nr = now[0]+delta[i][0];
                int nc = now[1]+delta[i][1];
                if (!isInRange(nr, nc) || maps[nr][nc] == 0 || visit[nr][nc] != 0) continue;
                q.offer(new int[] {nr, nc});
                visit[nr][nc] = visit[now[0]][now[1]]+1;
            }
        }
        return -1;
    }
    boolean isInRange(int r, int c) {
        return r >= 0 && c >= 0 && r < N && c < M;
    }
}