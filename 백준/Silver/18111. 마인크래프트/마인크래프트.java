import java.io.*;
import java.util.*;
public class Main {
	static int[][] arr;
	static int N, M, B;
	static int min = 256, max = 0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				min = Math.min(min, arr[r][c]);
				max = Math.max(max, arr[r][c]);
			}
		}
		minecraft();
		System.out.println(sb);
	}
	public static void minecraft() {
		int time = Integer.MAX_VALUE;
		int height = -1;
		for (int i = min; i <= max; i++) {
			int tempTime = 0;
			int item = B;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					int diff = arr[r][c] - i;
					if (diff > 0) {
						tempTime += diff * 2;
						item += diff;
					} else {
						tempTime += Math.abs(diff);
						item -= Math.abs(diff);
					}
				}
			}
			if (item >= 0 && tempTime <= time) {
				time = tempTime;
				height = i;
			}
		}
		sb.append(time + " " + height);
	}
}