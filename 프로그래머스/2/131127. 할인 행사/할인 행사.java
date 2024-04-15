import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for (int i = 0; i <= discount.length-10; ++i) {
            boolean flag = true;
            
            for (int j = 0; j < want.length; ++j) {
                int cnt = 0;
                
                for (int k = i; k < i+10; ++k)
                    if (want[j].equals(discount[k])) ++cnt;
                
                if (cnt < number[j]) {
                    flag = false;
                    break;
                } 
            }
            
            if (flag) ++answer;
        }
        
        return answer;
    }
}