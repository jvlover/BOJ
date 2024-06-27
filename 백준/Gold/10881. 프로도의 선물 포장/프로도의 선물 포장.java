import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] w = new int[6], h = new int[6];
        while (N-->0) {
            for (int i = 0; i < 3; ++i) {
                st = new StringTokenizer(br.readLine());
                h[i+3] = w[i] = Integer.parseInt(st.nextToken());
                w[i+3] = h[i] = Integer.parseInt(st.nextToken());
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 6; ++i) {
                for (int j = 0; j < 6; ++j) {
                    for (int k = 0; k < 6; ++k) {
                        if (i%3 != j%3 && j%3 != k%3 && k%3 != i%3) {
                            int width1 = w[i]+w[j]+w[k], height1 = Math.max(h[i], Math.max(h[j], h[k]));
                            int width2 = Math.max(w[i]+w[j], w[k]), height2 = Math.max(h[i],h[j])+h[k];
                            min = Math.min(min, Math.min(width1*height1, width2*height2));
                        }
                    }
                }
            }
            sb.append(min).append('\n');
        }
        System.out.print(sb);
    }
}