import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken())+1;
        int M = Integer.parseInt(st.nextToken())+1;
        int shop = Integer.parseInt(br.readLine());
        int[][] shops = new int[shop+1][2];
        for (int i = 0; i < shop+1; i++) {
        	st = new StringTokenizer(br.readLine());
        	int temp = Integer.parseInt(st.nextToken());
        	if (temp == 1) {
        		shops[i][0] = 0;
        		shops[i][1] = Integer.parseInt(st.nextToken());
        	} else if (temp == 2) {
        		shops[i][0] = M-1;
        		shops[i][1] = Integer.parseInt(st.nextToken());
        	} else if (temp == 3) {
        		shops[i][0] = Integer.parseInt(st.nextToken());
        		shops[i][1] = 0;
        	} else if (temp == 4) {
        		shops[i][0] = Integer.parseInt(st.nextToken());
        		shops[i][1] = N-1;
        	}
        }
        int sum = 0;
        for (int i = 0; i < shop; i++) {
        	if (Math.abs(shops[i][0] - shops[shop][0]) == M-1)
        		sum += M-1 + Math.min(shops[i][1]+shops[shop][1], 2*(N-1)-shops[i][1]-shops[shop][1]);
        	else if (Math.abs(shops[i][1] - shops[shop][1]) == N-1)
        		sum += N-1 + Math.min(shops[i][0]+shops[shop][0], 2*(M-1)-shops[i][0]-shops[shop][0]);
        	else if (shops[i][0] == shops[shop][0]) 
        		sum += Math.abs(shops[i][1] - shops[shop][1]);
        	else if (shops[i][1] == shops[shop][1]) 
        		sum += Math.abs(shops[i][0] - shops[shop][0]);
        	else
        		sum += Math.abs(shops[i][0]-shops[shop][0]) + Math.abs(shops[i][1]-shops[shop][1]);
        }
        System.out.println(sum);
    }
}