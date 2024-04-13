import java.util.*;

class Node {
    int prev, now, next;
    Node(int prev, int now, int next) {
        this.prev = prev;
        this.now = now;
        this.next = next;
    }
}

class Solution {
    public StringBuilder solution(int n, int k, String[] cmd) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) sb.append('O');
        
        int[] prev = new int[n], next = new int[n];
        for (int i = 0; i < n; ++i) {
            prev[i] = i-1;
            next[i] = i+1;
        }
        next[n-1] = -1;

        Stack<Node> stack = new Stack<>();
        for (int i = 0; i < cmd.length; ++i) {
            int num;
            switch (cmd[i].charAt(0)) {
                case 'U':
                    num = Integer.parseInt(cmd[i].substring(2));
                    while (num-->0) k = prev[k];
                    break;
                case 'D':
                    num = Integer.parseInt(cmd[i].substring(2));
                    while (num-->0) k = next[k];
                    break;
                case 'C':
                    stack.push(new Node(prev[k], k, next[k]));
                    if (prev[k] != -1) next[prev[k]] = next[k];
                    if (next[k] != -1) prev[next[k]] = prev[k];
                    sb.setCharAt(k, 'X');
                    if (next[k] != -1) k = next[k];
                    else k = prev[k];
                    break;
                case 'Z':
                    Node node = stack.pop();
                    int now = node.now;
                    if (node.prev != -1) next[node.prev] = now;
                    if (node.next != -1) prev[node.next] = now;
                    sb.setCharAt(now, 'O');
            }
        }
        return sb;
    }
}