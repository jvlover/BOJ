import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str;
		while ((str = br.readLine()) != null) {
			for (int i = 0; i < str.length(); ++i) {
				char c = str.charAt(i);
				if(c == 'i') sb.append('e');
				else if(c == 'e') sb.append('i');
				else if(c == 'I') sb.append('E');
				else if(c == 'E') sb.append('I');
				else sb.append(c);
			}
			sb.append('\n');
		}
		System.out.print(sb);
	}
}