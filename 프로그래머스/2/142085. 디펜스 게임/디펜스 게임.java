import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int left = 0, right = enemy.length;
        List<Integer> enemyList = Arrays.stream(enemy)
                                        .boxed()
                                        .collect(Collectors.toList());
        while (left <= right) {
            int mid = (left+right)/2;
            
            List<Integer> list = enemyList.stream()
                                        .limit(mid)
                                        .sorted(Collections.reverseOrder())
                                        .collect(Collectors.toList());
            
            int temp = 0;
            boolean flag = true;
            
            for (int i = k; i < mid; ++i) {
                temp += list.get(i);
                if (temp > n) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) {
                left = mid+1;
                answer = mid;
            } else {
                right = mid-1;
            }
        }
        return answer;
    }
}