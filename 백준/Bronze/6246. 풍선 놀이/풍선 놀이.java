import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), Q = Integer.parseInt(st.nextToken());
        boolean[] visit = new boolean[N];
        while (Q-->0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken())-1, gap = Integer.parseInt(st.nextToken());
            for (int i = start; i < N; i+=gap) visit[i] = true;
        }
        int cnt = 0;
        for (boolean b : visit) if (!b) ++cnt;
        System.out.print(cnt);
    }
}