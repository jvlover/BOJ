class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visit = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; ++i) {
            if (visit[i]) continue;
            ++answer;
            dfs(n, computers, visit, i);
        }
        return answer;
    }
    void dfs(int n, int[][] computers, boolean[] visit, int idx) {
        visit[idx] = true;
        for (int i = 0; i < n; ++i) {
            if (visit[i] || computers[i][idx] == 0) continue;
            dfs(n, computers, visit, i);
        }
    }
}