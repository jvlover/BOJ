import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer>[] roster = new PriorityQueue[12];
        for (int i = 1; i <= 11; ++i) roster[i] = new PriorityQueue<>(Collections.reverseOrder());
        while (N-->0) {
            st = new StringTokenizer(br.readLine());
            roster[Integer.parseInt(st.nextToken())].offer(Integer.parseInt(st.nextToken()));
        }
        while (K-->0)
            for (int i = 1; i <= 11; ++i)
                if (!roster[i].isEmpty()) roster[i].offer(Math.max(roster[i].poll()-1, 0));
        int sum = 0;
        for (int i = 1; i <= 11; ++i) {
            if (roster[i].isEmpty()) continue;
            sum += roster[i].poll();
        }
        System.out.print(sum);
    }
}