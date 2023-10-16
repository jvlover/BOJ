import java.io.*;
import java.util.*;
public class Main {
    static class Node {
        long x, y;
        Node(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Node[] arr = new Node[N+1];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Node(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken()));
        }
        arr[N] = arr[0];
        long sum = 0;
        for (int i = 0; i < N; ++i) sum += arr[i].x*arr[i+1].y - arr[i+1].x*arr[i].y;
        System.out.printf("%.1f", Math.abs(sum)/2.0);
    }
}