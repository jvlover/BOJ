import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] players = new int[N];
        boolean[] cards = new boolean[1000001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) cards[players[i] = Integer.parseInt(st.nextToken())] = true;
        int[] scores = new int[1000001];
        for (int p : players) {
            for (int i = p*2; i <= 1000000; i += p) {
                if (cards[i]) {
                    ++scores[p];
                    --scores[i];
                }
            }
        }
        for (int p : players) sb.append(scores[p]).append(' ');
        System.out.print(sb);
    }
}