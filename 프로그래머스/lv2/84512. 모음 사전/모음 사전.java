import java.util.*;
class Solution {
    char[] arr = {'A', 'E', 'I', 'O', 'U'};
    List<String> list = new ArrayList<>();
    public int solution(String word) {
        permutation("", 0);
        return list.indexOf(word);
    }
    void permutation(String str, int cnt) {
        list.add(str);
        if (cnt == 5) return;
        for (int i = 0; i < 5; ++i)
            permutation(str+arr[i], cnt+1);
    }
}