import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1, o2) -> o1[1]-o2[1]);
        int cnt = 0, now = 0;
        for (int[] target : targets) {
            if (now <= target[0]) {
                ++cnt;
                now = target[1];
            }
        }
        return cnt;
    }
}