import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        char[] M = br.readLine().toCharArray();
        int N = Integer.parseInt(br.readLine());
        double max = -1;
        String ans = "";
        while (N-->0) {
            st = new StringTokenizer(br.readLine());
            char[] W = st.nextToken().toCharArray();
            double G = Double.parseDouble(st.nextToken());
            int mIdx = 0, wIdx = 0;
            while (mIdx < M.length && wIdx < W.length) {
                if (M[mIdx] == W[wIdx]) ++mIdx;
                ++wIdx;
            }
            if (mIdx == M.length && max < G/(W.length-M.length)) {
                max = G/(W.length-M.length);
                ans = new String(W);
            }
        }
        System.out.print(ans.isEmpty() ? "No Jam" : ans);
    }
}