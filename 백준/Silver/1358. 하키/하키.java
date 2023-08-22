import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int R = H/2;
        int cnt = 0;
        double dist;
        while (P-->0) {
            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken()) - X;
            int p2 = Integer.parseInt(st.nextToken()) - Y;
            if (p1 >= 0 && p1 <= W && p2 >= 0 && p2 <= H) {
                ++cnt;
                continue;
            }
            double temp = Math.pow(Math.abs(p2 - R), 2);
            dist = Math.pow(Math.abs(p1), 2) + temp;
            if (R * R >= dist) {
                ++cnt;
                continue;
            }
            dist = Math.pow(Math.abs(p1 - W), 2) + temp;
            if (R * R >= dist) {
                ++cnt;
            }
        }
        System.out.print(cnt);
    }
}