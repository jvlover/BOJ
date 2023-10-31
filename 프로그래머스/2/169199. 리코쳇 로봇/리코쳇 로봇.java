import java.util.*;

class Solution {
    int N, M;
    String[] board;
    boolean[][] visit;
    int[][] delta = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    
    public int solution(String[] board) {
        this.board = board;
        
        N = board.length;
        M = board[0].length();
        visit = new boolean[N][M];
        
        int startR = -1, startC = -1;
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < M; ++j) {
                if (board[i].charAt(j) == 'R') {
                    startR = i;
                    startC = j;
                }
            }
        }
        
        int answer = bfs(startR, startC);
        return answer;
    }
    
    int bfs(int startR, int startC) {
        Queue<Node> q = new LinkedList<>();
        visit[startR][startC] = true;
        q.offer(new Node(startR, startC, 0));
        
        while (!q.isEmpty()) {
            Node now = q.poll();
            
            if (board[now.r].charAt(now.c) == 'G') {
                return now.cnt;
            }
            
            for (int i = 0; i < 4; ++i) {
                int nr = now.r;
                int nc = now.c;
                
                while (nr >= 0 && nc >= 0 && nr < N && nc < M && board[nr].charAt(nc) != 'D') {
                    nr += delta[i][0];
                    nc += delta[i][1];
                }
                nr -= delta[i][0];
                nc -= delta[i][1];
                
                if (!visit[nr][nc] && (nr != now.r || nc != now.c)) {
                    visit[nr][nc] = true;
                    q.offer(new Node(nr, nc, now.cnt+1));
                }
            }
            
        }
        return -1;
    }
}

class Node {
    int r, c, cnt;
    Node(int r, int c, int cnt) {
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }
}