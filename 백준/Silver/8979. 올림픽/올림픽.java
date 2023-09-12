import java.io.*;
import java.util.*;
public class Main {
    static class Nation {
        int gold, silver, bronze;
        Nation(int gold, int silver, int bronze) {
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        Nation[] nations = new Nation[N+1];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            nations[Integer.parseInt(st.nextToken())] = new Nation(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        int rank = 1;
        Nation target = nations[K];
        for (int i = 1; i <= N; ++i) {
            Nation cur = nations[i];
            if (cur.gold > target.gold || (cur.gold == target.gold && cur.silver > target.silver) || (cur.gold == target.gold && cur.silver == target.silver && cur.bronze > target.bronze)) ++rank;
        }
        System.out.print(rank);
    }
}