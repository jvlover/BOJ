import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> trucks = new LinkedList<>();
		int time = 0, weight = 0;
		while (n-->0)
			trucks.offer(Integer.parseInt(st.nextToken()));
		while (w-->0)
			bridge.offer(0);
		while (!bridge.isEmpty()) {
			time++;
			weight -= bridge.poll();
			if (!trucks.isEmpty() && weight + trucks.peek() <= L) {
				weight += trucks.peek();
				bridge.offer(trucks.poll());
			} else if (!trucks.isEmpty() && weight + trucks.peek() > L){
				bridge.offer(0);
			}
		}
		System.out.println(time);
	}
}