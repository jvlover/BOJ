import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean flag = true;
        String str = br.readLine();
        long num = Long.parseLong(str);
        if (!isPrime(num)) flag = false;
        else {
            char[] rev = new StringBuilder(str).reverse().toString().toCharArray();
            for (int i = 0; i < rev.length; ++i) {
                if (rev[i] == '3' || rev[i] == '4' || rev[i] == '7') {
                    flag = false;
                    break;
                }
                else if (rev[i] == '6') rev[i] = '9';
                else if (rev[i] == '9') rev[i] = '6';
            }
            if (!isPrime(Long.parseLong(new String(rev)))) flag = false;
        }
        System.out.print(flag?"yes":"no");
    }
    static boolean isPrime(long num) {
        if (num == 1) return false;
        for (long i = 2; i*i <= num; ++i)
            if (num % i == 0) return false;
        return true;
    }
}