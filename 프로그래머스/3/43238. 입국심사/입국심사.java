import java.util.*;
class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long minTime = 1, maxTime = Long.MAX_VALUE-1;
        while (minTime <= maxTime) {
            long mid = (minTime + maxTime) / 2;
            long temp = 0;
            for (long time : times) {
                temp += mid / time;
                if (temp > n) break;
            }
            if (temp < n) minTime = mid+1;
            else maxTime = mid-1;
        }
        return minTime;
    }
}