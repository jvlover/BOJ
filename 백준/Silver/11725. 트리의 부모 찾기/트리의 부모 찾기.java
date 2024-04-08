import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int[] parents;
	static boolean[] check;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		parents = new int[N+1];
		check = new boolean[N+1];
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++)
			list[i] = new ArrayList<Integer>();
		for (int i = 0; i < N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list[A].add(B);
			list[B].add(A);
		}
		for (int i = 1; i <= N; i++)
			if (!check[i]) dfs(i);
		for (int i = 2; i <= N; i++)
			sb.append(parents[i]).append('\n');
		System.out.println(sb);
	}
	static void dfs(int num) {
		if (check[num]) return;
		check[num] = true;
		for (int i : list[num]) {
			if (!check[i]) {
				parents[i] = num;
				dfs(i);
			}
		}
	}
}