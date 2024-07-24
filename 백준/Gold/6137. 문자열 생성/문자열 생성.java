import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] arr = new char[N];
        for (int i = 0; i < N; ++i) arr[i] = br.readLine().charAt(0);
        int left = 0, right = N-1;
        StringBuilder sb = new StringBuilder();
        while (N-->0) {
            boolean flag = true;
            int mid = (right-left+1)/2;
            for (int i = 0; i < mid; ++i) {
                if (arr[left+i] != arr[right-i]) {
                    if (arr[left+i] > arr[right-i]) flag = false;
                    break;
                }
            }
            sb.append(flag ? arr[left++] : arr[right--]);
            if (sb.length() == 80) {
                System.out.println(sb);
                sb = new StringBuilder();
            }
        }
        System.out.print(sb);
    }
}