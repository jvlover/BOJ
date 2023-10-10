import java.io.*;
import java.util.*;
public class Main {
    static List<Long> list;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i <= 9; ++i) backtracking(i, 1);
        Collections.sort(list);
        try {
            System.out.print(list.get(N));
        } catch (IndexOutOfBoundsException e) {
            System.out.print(-1);
        }
    }
    static void backtracking(long num, int idx) {
        if (idx > 10) return;
        list.add(num);
        for (int i = 0; i < num%10; ++i)
            backtracking(num*10+i, idx+1);
    }
}