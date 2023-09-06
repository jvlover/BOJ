import java.io.*;
import java.util.*;
public class Main {
    static class Store {
        int r, c;
        Store(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int store = Integer.parseInt(br.readLine());
        Store[] stores = new Store[store+1];
        for (int i = 0; i <= store; ++i) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int point = Integer.parseInt(st.nextToken());
            switch (dir) {
                case 1:
                    stores[i] = new Store(0, point);
                    break;
                case 2:
                    stores[i] = new Store(M, point);
                    break;
                case 3:
                    stores[i] = new Store(point, 0);
                    break;
                case 4:
                    stores[i] = new Store(point, N);
            }
        }
        int sum = 0;
        Store person = stores[store];
        for (int i = 0; i < store; ++i) {
            Store shop = stores[i];
            if (Math.abs(shop.r - person.r) == M)
                sum += M + Math.min(shop.c + person.c, 2*N - shop.c - person.c);
            else if (Math.abs(shop.c -person.c) == N)
                sum += N + Math.min(shop.r + person.r, 2*M - shop.r - person.r);
            else if (shop.r == person.r)
                sum += Math.abs(shop.c - person.c);
            else if (shop.c == person.c)
                sum += Math.abs(shop.r - person.r);
            else
                sum += Math.abs(shop.c - person.c) + Math.abs(shop.r - person.r);
        }
        System.out.print(sum);
    }
}
