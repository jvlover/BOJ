import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		if (N == 1) {
			System.out.print("1/1");
			System.exit(0);
		}
		int[] arr = new int[4473];
		arr[1] = 1;
		for (int i = 2; i < 4473; i++) {
			arr[i] = arr[i-1] + i;
			if (arr[i] >= N) {
				if (i % 2 == 0) {
					System.out.printf("%d/%d",N - arr[i-1], i - (N - arr[i-1]) + 1);
					break;
				} else {
					System.out.printf("%d/%d",i - (N - arr[i-1]) + 1, N - arr[i-1]);
					break;
				}
			}
		}
	}
}