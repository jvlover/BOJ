import java.io.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;
        while (!(str = br.readLine()).equals("end")) {
            boolean hasVowel = false, flag = true;
            int consonantCnt = 0, vowelCnt = 0;
            for (int i = 0; i < str.length(); ++i) {
                if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                    hasVowel = true;
                    ++vowelCnt;
                    consonantCnt = 0;
                } else {
                    ++consonantCnt;
                    vowelCnt = 0;
                }
                if ((vowelCnt >= 3 || consonantCnt >= 3) || (i != 0 && str.charAt(i) != 'e' && str.charAt(i) != 'o' && str.charAt(i) == str.charAt(i-1))) {
                    flag = false;
                    break;
                }
            }
            sb.append(String.format("<%s> is ", str));
            if (!hasVowel || !flag) sb.append("not ");
            sb.append("acceptable.\n");
        }
        System.out.print(sb);
    }
}