import java.io.*;
import java.util.*;
public class Main {
	static class Node {
		int r, c;
		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	static int N;
	static int[][] map, students;
	static int[][] delta = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		students = new int[N*N+1][4];
		for (int i = 0; i < N*N; ++i) {
			st = new StringTokenizer(br.readLine());
			int student = Integer.parseInt(st.nextToken());
			int idx = 0;
			for (int j = 0; j < 4; ++j) students[student][idx++] = Integer.parseInt(st.nextToken());
			find1(student);
		}
		System.out.print(satisfaction());
	}
	static void find1(int student) {
		List<Node> list = new ArrayList<>();
		int max = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				if (map[i][j] != 0) continue;
				int cnt = 0;
				for (int k = 0; k < 4; ++k) {
					int nr = i + delta[k][0];
					int nc = j + delta[k][1];
					if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
					for (int l = 0; l < 4; ++l)
						if (map[nr][nc] == students[student][l]) ++cnt;
				}
				if (max == cnt) list.add(new Node(i, j));
				else if (max < cnt) {
					list.clear();
					list.add(new Node(i, j));
					max = cnt;
				}
			}
		}
		if (list.size() == 1) map[list.get(0).r][list.get(0).c] = student;
		else find2(list, student);
	}
	
	static void find2(List<Node> list, int student) {
		List<Node> emptyList = new ArrayList<>();
		int max = 0;
		for (Node cur : list) {
			int cnt = 0;
			for (int i = 0; i < 4; ++i) {
				int nr = cur.r + delta[i][0];
				int nc = cur.c + delta[i][1];
				if (nr < 0 || nc < 0 || nr >= N || nc >= N || map[nr][nc] != 0) continue;
				++cnt;
			}
			if (max == cnt) emptyList.add(new Node(cur.r, cur.c));
			else if (max < cnt) {
				emptyList.clear();
				emptyList.add(new Node(cur.r, cur.c));
				max = cnt;
			}
		}
		if (emptyList.size() == 1) map[emptyList.get(0).r][emptyList.get(0).c] = student;
		else find3(emptyList, student);
	}
	static void find3(List<Node> emptyList, int student) {
		Collections.sort(emptyList, new Comparator<Node>() {
			@Override
			public int compare(Node o1, Node o2) {
				if (o1.r == o2.r) return o1.c - o2.c;
				return o1.r - o2.r;
			}
		});
		map[emptyList.get(0).r][emptyList.get(0).c] = student;
	}
	static int satisfaction() {
		int sum = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j < N; ++j) {
				int cnt = 0;
				for (int k = 0; k < 4; ++k) {
					int nr = i + delta[k][0];
					int nc = j + delta[k][1];
					if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
					for (int l = 0; l < 4; ++l)
						if (map[nr][nc] == students[map[i][j]][l]) ++cnt;
				}
				switch (cnt) {
				case 1: ++sum; break;
				case 2: sum += 10; break;
				case 3: sum += 100; break;
				case 4: sum += 1000; break;
				}
			}
		}
		return sum;
	}
}