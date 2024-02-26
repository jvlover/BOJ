class Solution {
    int max;
    boolean[] visit;
    int[][] dungeons;
    public int solution(int k, int[][] dungeons) {
        max = -1;
        visit = new boolean[dungeons.length];
        this.dungeons = dungeons;
        
        dfs(0, k);
        
        return max;
    }
    void dfs(int idx, int k) {
        max = Math.max(max, idx);
        
        for (int i = 0; i < dungeons.length; ++i) {
            if (visit[i] || dungeons[i][0] > k) continue;
            
            visit[i] = true;
            dfs(idx+1, k-dungeons[i][1]);
            visit[i] = false;
        }
    }
}