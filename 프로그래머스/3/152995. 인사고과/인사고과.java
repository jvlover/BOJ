import java.util.*;
class Solution {
    public int solution(int[][] scores) {
        
        int n = scores.length;
        int wanhoAtti = scores[0][0], wanhoEval = scores[0][1];
        
        Arrays.sort(scores, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1]-o2[1];
                return o2[0]-o1[0];
            }
        });
        
        int max = scores[0][1];
        
        for (int i = 1; i < n; ++i) {
            if (scores[i][1] < max) {
                if (scores[i][0] == wanhoAtti && scores[i][1] == wanhoEval) return -1;
                scores[i][0] = scores[i][1] = -1;
            } else {
                max = scores[i][1];
            }
        }
        
        Arrays.sort(scores, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0]+o2[1]-o1[0]-o1[1];
            }
        });
        
        int ans = 1;
        
        for (int i = 0; i < n; ++i) {
            if (scores[i][0]+scores[i][1] > wanhoAtti+wanhoEval) ++ans;
            else return ans;
        }
        
        return ans;
    }
}