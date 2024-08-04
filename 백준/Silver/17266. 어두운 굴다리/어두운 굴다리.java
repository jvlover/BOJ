import java.io.*;
import java.util.*;
public class Main {
	static int N, M;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[M];
		for (int i = 0; i < M; i++) arr[i] = Integer.parseInt(st.nextToken());
		int start = 0;
		int end = N;
		int mid;
		int ans = N;
		outer: while (start <= end) {
			mid = (start + end) / 2;
			int pos = 0;
			for (int i = 0; i < M; i++) {
				if (arr[i] - mid <= pos) pos = arr[i] + mid;
				else {
					start = mid + 1;
					continue outer;
				}
			}
			if (pos >= N) {
				end = mid - 1;
				ans = mid;
			} else {
				start = mid + 1;
			}
		}
		System.out.println(ans);
	}
}