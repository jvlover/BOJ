import java.io.*;
import java.util.*;
public class Main {
    static int[][][] dp;
    static ArrayList<Integer> list;
    static int[][] powers = {{1, 2, 2, 2, 2}, {0, 1, 3, 4, 3}, {0, 3, 1, 3, 4}, {0, 4, 3, 1, 3}, {0, 3, 4, 3, 1}};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        while (true) {
            int temp = Integer.parseInt(st.nextToken());
            if (temp == 0) break;
            list.add(temp);
        }
        dp = new int[list.size()][5][5];
        System.out.print(solve(0, 0, 0));
    }
    static int solve(int idx, int left, int right) {
        if (idx == list.size()) return 0;
        if (dp[idx][left][right] != 0) return dp[idx][left][right];
        int next = list.get(idx);
        return dp[idx][left][right] = Math.min(solve(idx+1, next, right)+powers[left][next], solve(idx+1, left, next)+powers[right][next]);
    }
}