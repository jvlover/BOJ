import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        int cnt = 0;
        for (int i = 0; i < N; ++i) {
            int start = 0, end = N-1;
            while (start < end) {
                if (start == i) ++start;
                else if (end == i) --end;
                else {
                    int sum = arr[start] + arr[end];
                    if (sum < arr[i]) ++start;
                    else if (sum > arr[i]) --end;
                    else {
                        ++cnt;
                        break;
                    }
                }
            }
        }
        System.out.print(cnt);
    }
}