import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < s.length(); ++i) q.offer(s.charAt(i));
        
        for (int i = 0; i < s.length(); ++i) {
            q.offer(q.poll());
            
            Stack<Character> st = new Stack<>();
            
            for (int j = 0; j < s.length(); ++j) {
                char ch = q.poll();
                
                if (st.isEmpty()) st.push(ch);
                else if ((st.peek() == '(' && ch == ')') || (st.peek() == '[' && ch == ']') || (st.peek() == '{' && ch == '}')) st.pop();
                else st.push(ch);
                
                q.offer(ch);
            }
            
            if (st.isEmpty()) ++answer;
        }
        
        return answer;
    }
}