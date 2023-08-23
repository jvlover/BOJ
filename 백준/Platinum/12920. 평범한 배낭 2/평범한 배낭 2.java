import java.io.*;
import java.util.*;
public class Main {
	static class Thing {
		int weight, score;
		Thing(int weight, int score) {
			this.weight = weight;
			this.score = score;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] dp = new int[M+1];
		ArrayList<Thing> list = new ArrayList<>();
		list.add(new Thing(0, 0));
		while (N-->0) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int idx = 1;
			while (K > 0) {
				int temp = Math.min(idx, K);
				list.add(new Thing(V*temp, C*temp));
				K -= temp;
				idx <<= 1;
			}
		}
		for (int i = 1; i < list.size(); ++i)
			for (int j = M; j >= list.get(i).weight; --j)
				dp[j] = Math.max(dp[j], dp[j-list.get(i).weight]+list.get(i).score);
		System.out.println(dp[M]);
	}
}