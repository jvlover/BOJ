import java.util.*;

class Solution {
    int n;
    List<Integer>[] graph;
    public int solution(int n, int[][] wires) {
        this.n = n;
        this.graph = new ArrayList[n+1];
        int answer = Integer.MAX_VALUE;
        
        for (int i = 1; i <= n; ++i) graph[i] = new ArrayList<>();
        
        for (int i = 0; i < wires.length; ++i) {
            graph[wires[i][0]].add(wires[i][1]);
            graph[wires[i][1]].add(wires[i][0]);
        }
        
        for (int i = 0; i < wires.length; ++i) {
            int a = bfs(wires[i][0], wires[i][1]);
            int b = bfs(wires[i][1], wires[i][0]);
            answer = Math.min(answer, Math.abs(a-b));
        }
        
        return answer;
    }
    int bfs(int v1, int v2) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visit = new boolean[n+1];
        
        q.offer(v1);
        visit[v1] = true;
        
        int cnt = 0;
        
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph[now]) {
                if (next == v2 || visit[next]) continue;
                q.offer(next);
                visit[next] = true;
            }
            ++cnt;
        }
        
        return cnt;
    }
}