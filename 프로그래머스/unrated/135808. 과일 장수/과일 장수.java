import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        Arrays.sort(score);
        int answer = 0;
        for (int i = score.length-m; i >= 0; i -= m) answer += m*score[i];
        return answer;
    }
}