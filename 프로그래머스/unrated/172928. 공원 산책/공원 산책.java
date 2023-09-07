import java.util.*;
class Solution {
    public int[] solution(String[] park, String[] routes) {
        int curR = -1, curC = -1;
        int N = park.length, M = park[0].length();
        boolean[][] map = new boolean[N][M];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                char ch = park[i].charAt(j);
                if (ch == 'S') {
                    curR = i;
                    curC = j;
                    ch = 'O';
                }
                map[i][j] = ch == 'O';
            }
        }
        StringTokenizer st;
        int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        outer: for (String str : routes) {
            st = new StringTokenizer(str);
            String dirStr = st.nextToken();
            int dist = Integer.parseInt(st.nextToken());
            int dir = -1;
            switch (dirStr) {
                case "N":
                    dir = 0;
                    break;
                case "S":
                    dir = 1;
                    break;
                case "W":
                    dir = 2;
                    break;
                case "E":
                    dir = 3;
                    break;
            }
            int nr = curR, nc = curC;
            for (int i = 1; i <= dist; ++i) {
                nr += delta[dir][0];
                nc += delta[dir][1];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M || !map[nr][nc]) continue outer;
            }
            curR = nr;
            curC = nc;
        }
        int[] answer = {curR, curC};
        return answer;
    }
}