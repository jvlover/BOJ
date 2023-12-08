import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int J = Integer.parseInt(br.readLine());
        int dist = 0, left = 1, right = left+M-1;
        while (J-->0) {
            int loc = Integer.parseInt(br.readLine());
            if (loc < left) {
                int gap = left-loc;
                dist += gap;
                left -= gap;
                right -= gap;
            } else if (loc > right) {
                int gap = loc-right;
                dist += gap;
                left += gap;
                right += gap;
            }
        }
        System.out.print(dist);
    }
}