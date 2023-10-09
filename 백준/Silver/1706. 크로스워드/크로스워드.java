import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());
		char[][] map = new char[R][C];
		for (int i = 0; i < R; ++i) map[i] = br.readLine().toCharArray();
		PriorityQueue<String> pq = new PriorityQueue<>();
		for (int i = 0; i < R; ++i) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < C; ++j) {
				if (map[i][j] != '#') sb.append(map[i][j]);
				else if (sb.length() != 0){
					if (sb.length() > 1) pq.add(sb.toString());
					sb = new StringBuilder();
				}
			}
			if (sb.length() > 1) pq.add(sb.toString());
		}
		for (int j = 0; j < C; ++j) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < R; ++i) {
				if (map[i][j] != '#') sb.append(map[i][j]);
				else if (sb.length() != 0){
					if (sb.length() > 1) pq.add(sb.toString());
					sb = new StringBuilder();
				}
			}
			if (sb.length() > 1) pq.add(sb.toString());
		}
		System.out.print(pq.poll());
	}
}