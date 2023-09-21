import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long cnt = 0;
        Stack<Integer> stack = new Stack<>();
        while (N-->0) {
            int H = Integer.parseInt(br.readLine());
            while (!stack.isEmpty()) {
                if (H >= stack.peek()) stack.pop();
                else break;
            }
            cnt += stack.size();
            stack.push(H);
        }
        System.out.print(cnt);
    }
}