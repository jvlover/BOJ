import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int cnt = 1;
        while (B != A) {
        	if (B < A || (B % 2 != 0 && B % 10 != 1)) {
        		System.out.print(-1);
            	System.exit(0);
        	}
        	if (B % 2 == 0) B = B >> 1;
        	else B /= 10;
        	cnt++;
        }
        System.out.print(cnt);
	}
}