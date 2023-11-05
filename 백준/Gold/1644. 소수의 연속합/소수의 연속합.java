import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[N+1];
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= N; ++i) {
            if (!isPrime[i]) {
                primes.add(i);
                int temp = i;
                while (temp <= N) {
                    isPrime[temp] = true;
                    temp += i;
                }
            }
        }
        int start = 0, end = 0, sum = 0, cnt = 0;
        while (start < primes.size() || end < primes.size()) {
            if (sum < N && end < primes.size()) sum += primes.get(end++);
            else sum -= primes.get(start++);
            if (sum == N) ++cnt;
        }
        System.out.print(cnt);
    }
}