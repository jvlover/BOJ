import java.io.*;
import java.util.*;
public class Main {
    static class Meeting implements Comparable<Meeting> {
        int start, end;
        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end) return Integer.compare(this.start, o.start);
            return Integer.compare(this.end, o.end);
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Meeting> pq = new PriorityQueue<>();
        while (N-->0) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int cnt = 0, prev = 0;
        while (!pq.isEmpty()) {
            Meeting cur = pq.poll();
            if (prev <= cur.start) {
                ++cnt;
                prev = cur.end;
            }
        }
        System.out.print(cnt);
    }
}