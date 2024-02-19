import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i : works) pq.offer(i);
        
        while (n != 0) {
            int work = pq.poll()-1;
            if (work < 0) return 0;
            --n;
            pq.offer(work);
        }
        
        long answer = 0;
        while (!pq.isEmpty()) answer += Math.pow(pq.poll(), 2);
        return answer;
    }
}