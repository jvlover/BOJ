class Solution {
    int answer = 0;
    boolean[] visit = new boolean[8];
    char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    public int solution(int n, String[] data) {
        dfs(data, 0, "");
        return answer;
    }
    void dfs(String[] data, int depth, String str) {
        if (depth == 8) {
            if (isPossible(data, str)) ++answer;
            return;
        }
        for (int i = 0; i < 8; ++i) {
            if (visit[i]) continue;
            visit[i] = true;
            dfs(data, depth+1, str+friends[i]);
            visit[i] = false;
        }
    }
    boolean isPossible(String[] data, String str) {
        for (String s : data) {
            int dist = Math.abs(str.indexOf(s.charAt(0))-str.indexOf(s.charAt(2)))-1;
            int num = s.charAt(4)-'0';
            switch (s.charAt(3)) {
                case '=':
                    if (dist != num) return false;
                    break;
                case '<':
                    if (dist >= num) return false;
                    break;
                case '>':
                    if (dist <= num) return false;
                    break;
            }
        }
        return true;
    }
}