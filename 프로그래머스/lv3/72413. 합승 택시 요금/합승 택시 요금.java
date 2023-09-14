class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] map = new int[n+1][n+1];
        for (int i = 1; i <= n; ++i)
            for (int j = 1; j <= n; ++j)
                if (i != j) map[i][j] = 100000000;
        for (int i = 0; i < fares.length; ++i)
            map[fares[i][0]][fares[i][1]] = map[fares[i][1]][fares[i][0]] = fares[i][2];
        for (int mid = 1; mid <= n; ++mid)
            for (int start = 1; start <= n; ++start)
                for (int end = 1; end <= n; ++end)
                    map[start][end] = Math.min(map[start][end], map[start][mid]+map[mid][end]);
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= n; ++i)
            answer = Math.min(answer, map[s][i] + map[i][a] + map[i][b]);
        return answer;
    }
}