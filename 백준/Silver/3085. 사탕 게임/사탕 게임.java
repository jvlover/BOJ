import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static char[][] arr;
	static int N, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		String str;
		for (int r = 0; r < N; r++) {
			str = br.readLine();
			for (int c = 0; c < N; c++) {
				arr[r][c] = str.charAt(c);
			}
		}
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				find(r, c);
			}
		}
		System.out.println(max);
	}

	public static int find(int r, int c) {
		int[][] delta = { { 1, 0 }, { 0, 1 } }; // 아래쪽, 오른쪽 (중복이라 이렇게만 체크)
		for (int i = 0; i < 2; i++) {
			int nr = r + delta[i][0];
			int nc = c + delta[i][1];
			char temp;
			if (nr < N && nc < N && arr[r][c] != arr[nr][nc]) {
				// 카드 서로 자리 바꾸기
				temp = arr[r][c];
				arr[r][c] = arr[nr][nc];
				arr[nr][nc] = temp;
				
				int tempMax = 1;
				// 바꾸고 나서 개수 체크
				for (int x = 0; x < N; x++) {
					int tempR = 1;
					int tempC = 1;
					char nowR = arr[x][0];
					char nowC = arr[0][x];
					for (int y = 1; y < N; y++) {
						if (nowR != arr[x][y]) {
							tempMax = Math.max(tempMax, tempR);
							nowR = arr[x][y];
							tempR = 1;
						} else {
							++tempR;
						}
						
						if (nowC != arr[y][x]) {
							tempMax = Math.max(tempMax, tempC);
							nowC = arr[y][x];
							tempC = 1;
						} else {
							++tempC;
						}
					}
					tempMax = Math.max(tempMax, tempR>tempC?tempR:tempC);
				}
				
				max = Math.max(max, tempMax);
				// 카드 자리 바꿔 놓은 거 원상복귀
				temp = arr[r][c];
				arr[r][c] = arr[nr][nc];
				arr[nr][nc] = temp;
			}
		}
		return max;
	}
}