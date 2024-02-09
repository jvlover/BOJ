import java.io.*;
import java.util.*;
public class Main {
    static int N, K, ans, appleCnt;
    static int[] parent;
    static Set<Integer>[] appleList;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ans = 0;
        appleCnt = 0;

        parent = new int[N];

        appleList = new HashSet[N];

        for (int i = 0; i < N; ++i) {
            parent[i] = -1;
            appleList[i] = new HashSet<>();
        }

        for (int i = 1; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            parent[c] = p;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            if (Integer.parseInt(st.nextToken()) == 1) {
                Set<Integer> connect = new HashSet<>();
                int temp = i;
                while (temp != -1) {
                    connect.add(temp);
                    temp = parent[temp];
                }
                appleList[appleCnt++] = connect;
            }
        }

        dfs(0, 0, new HashSet<>());

        System.out.print(ans);
    }

    static void dfs(int idx, int cnt, Set<Integer> set) {
        if (idx == appleCnt) {
            ans = Math.max(cnt, ans);
            return;
        }

        dfs(idx + 1, cnt, set);

        Set<Integer> newNodeSet = new HashSet<>(set);
        newNodeSet.addAll(appleList[idx]);

        if (newNodeSet.size() <= K) dfs(idx + 1, cnt + 1, newNodeSet);
    }
}