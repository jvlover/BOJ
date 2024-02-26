import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) pq.offer(i);
        int answer = 0;
        while (pq.peek() < K && pq.size() > 1) {
            pq.offer(pq.poll()+pq.poll()*2);
            ++answer;
        }
        if (pq.peek() < K) answer = -1;
        return answer;
    }
}