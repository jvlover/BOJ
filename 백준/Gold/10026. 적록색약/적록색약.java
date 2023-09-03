import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static char[][] normalArr, blindArr;
	static boolean[][] normalVisit, blindVisit;
	static int[][] drdc = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static class Node {
		int r, c;
		char color;
		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		normalArr = new char[N][N];
		blindArr = new char[N][N];
		normalVisit = new boolean[N][N];
		blindVisit = new boolean[N][N];
		for (int i = 0; i < N; ++i) {
			char[] temp = br.readLine().toCharArray();
			for (int j = 0; j < N; ++j) {
				normalArr[i][j] = temp[j];
				if (temp[j] == 'R') blindArr[i][j] = 'G';
				else blindArr[i][j] = temp[j];
			}
		}
		int cnt1 = 0, cnt2 = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (!normalVisit[i][j]) {
					++cnt1;
					normalBfs(i, j);
				}
				if (!blindVisit[i][j]) {
					++cnt2;
					blindBfs(i, j);
				}
			}
		}
		System.out.println(cnt1 + " " + cnt2);
	}
	static void normalBfs(int r, int c) {
		Queue<Node> q = new LinkedList<>();
		normalVisit[r][c] = true;
		q.offer(new Node(r, c)); 
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i = 0; i < 4; ++i) {
				int nr = cur.r + drdc[i][0];
				int nc = cur.c + drdc[i][1];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || normalVisit[nr][nc] || normalArr[nr][nc] != normalArr[r][c]) continue;
				normalVisit[nr][nc] = true;
				q.offer(new Node(nr, nc));
			}
		}
	}
	static void blindBfs(int r, int c) {
		Queue<Node> q = new LinkedList<>();
		blindVisit[r][c] = true;
		q.offer(new Node(r, c)); 
		while (!q.isEmpty()) {
			Node cur = q.poll();
			for (int i = 0; i < 4; ++i) {
				int nr = cur.r + drdc[i][0];
				int nc = cur.c + drdc[i][1];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || blindVisit[nr][nc] || blindArr[nr][nc] != blindArr[r][c]) continue;
				blindVisit[nr][nc] = true;
				q.offer(new Node(nr, nc));
			}
		}
	}
}