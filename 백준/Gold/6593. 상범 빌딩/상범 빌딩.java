import java.io.*;
import java.util.*;
public class Main {
	static class Node {
		int floor, r, c, time;
		Node(int floor, int r, int c, int time) {
			this.floor = floor;
			this.r = r;
			this.c = c;
			this.time = time;
		}
	}
	static int L, R, C;
	static char[][][] building;
	static int[][] delta = {{-1, 0, 0}, {0, -1, 0}, {1, 0, 0}, {0, 1, 0}, {0, 0, 1}, {0, 0, -1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String str;
		while (!(str = br.readLine()).equals("0 0 0")) {
			st = new StringTokenizer(str);
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			Node start = null;
			building = new char[L][R][C];
			for (int i = 0; i < L; ++i) {
				for (int j = 0; j < R; ++j) {
					building[i][j] = br.readLine().toCharArray();
					for (int k = 0; k < C; ++k)
						if (building[i][j][k] == 'S')
							start = new Node(i, j, k, 0);
				}
				br.readLine();
			}
			int ans = bfs(start);
			sb.append(ans==-1?"Trapped!":"Escaped in "+ans+" minute(s).").append('\n');
		}
		System.out.print(sb);
	}
	static int bfs(Node start) {
		Queue<Node> q = new LinkedList<>();
		boolean[][][] visit = new boolean[L][R][C];
		visit[start.floor][start.r][start.c] = true;
		q.add(start);
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i = 0; i < 6; ++i) {
				int nf = cur.floor + delta[i][2];
				int nr = cur.r + delta[i][0];
				int nc = cur.c + delta[i][1];
				if (nf < 0 || nr < 0 || nc < 0 || nf >= L || nr >= R || nc >= C || visit[nf][nr][nc] || building[nf][nr][nc] == '#') continue;
				if (building[nf][nr][nc] == 'E') return cur.time+1;
				visit[nf][nr][nc] = true;
				q.add(new Node(nf, nr, nc, cur.time+1));
			}
		}
		return -1;
	}
}