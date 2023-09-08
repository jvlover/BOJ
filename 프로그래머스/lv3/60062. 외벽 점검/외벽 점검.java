class Solution {
    int n, answer;
    boolean exit;
    boolean[] visit;
    int[] weak, linearWeak, dist;
    public int solution(int n, int[] weak, int[] dist) {
        this.n = n;
        this.dist = dist;
        this.weak = weak;
        linearWeak = new int[weak.length*2-1];
        for (int i = 0; i < weak.length; ++i) {
            linearWeak[i] = weak[i];
        }
        for (int i = 0; i < weak.length-1; ++i) {
            linearWeak[i+weak.length] = weak[i] + n;
        }
        this.visit = new boolean[dist.length];
        answer = Integer.MAX_VALUE;
        exit = false;
        for (int i = 1; i <= dist.length; ++i) {
            permutation(0, i, new int[i]);
        }
        return answer==Integer.MAX_VALUE?-1:answer;
    }
    public void permutation(int cnt, int pick, int[] res) {
        if (exit) return;
        if (cnt == pick) {
            for (int i = 0; i < weak.length; ++i) {
                boolean flag = true;
                int curLocation = i;
                int friendIdx = 0;
                for (int j = i+1; j < i+weak.length; ++j) {
                    if (linearWeak[j]-linearWeak[curLocation] > res[friendIdx]) {
                        curLocation = j;
                        if (++friendIdx == res.length) {
                            flag = false;
                            break;
                        }
                    }
                }
                if (flag) {
                    answer = res.length;
                    exit = true;
                    return;
                }
            }
            return;
        }
        for (int i = 0; i < dist.length; ++i) {
            if (visit[i]) continue;
            visit[i] = true;
            res[cnt] = dist[i];
            permutation(cnt+1, pick, res);
            visit[i] = false;
        }
    }
}