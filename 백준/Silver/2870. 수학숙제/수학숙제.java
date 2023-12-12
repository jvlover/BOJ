import java.io.*;
import java.math.*;
import java.util.*;
public class Main {
    static PriorityQueue<BigInteger> pq;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>();
        while (N-->0) parse(br.readLine().toCharArray());
        while (!pq.isEmpty()) sb.append(pq.poll()).append('\n');
        System.out.print(sb);
    }
    static void parse(char[] line) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < line.length; ++i) {
            if ('0' <= line[i] && line[i] <= '9') {
                sb.append(line[i]);
                if (i == line.length-1) pq.offer(new BigInteger(sb.toString()));
            } else if (sb.length() > 0) {
                pq.offer(new BigInteger(sb.toString()));
                sb = new StringBuilder();
            }
        }
    }
}