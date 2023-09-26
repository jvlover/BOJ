import java.util.*;
class Solution {
    
    int[] p;
    String[] values;
    StringTokenizer st;
    
    public String[] solution(String[] commands) {
        p = new int[2501];
        values = new String[2501];
        
        ArrayList<String> list = new ArrayList<>();
        
        makeSet();
        
        for (String str : commands) {
            st = new StringTokenizer(str);
            
            String command = st.nextToken();
            
            switch (command) {
                case "UPDATE":
                    if (st.countTokens() == 3) {
                        int r = Integer.parseInt(st.nextToken());
                        int c = Integer.parseInt(st.nextToken());
                        String value = st.nextToken();
                        
                        values[findSet(change(r, c))] = value;
                    } else {
                        String value1 = st.nextToken();
                        String value2 = st.nextToken();
                        
                        for (int i = 1; i <= 2500; ++i) {
                            if (values[i].equals(value1)) {
                                values[i] = value2;
                            }
                        }
                    }
                    
                    break;
                    
                case "MERGE":
                    int r1 = Integer.parseInt(st.nextToken());
                    int c1 = Integer.parseInt(st.nextToken());
                    int r2 = Integer.parseInt(st.nextToken());
                    int c2 = Integer.parseInt(st.nextToken());
                    
                    int parentIdx1 = findSet(change(r1, c1));
                    int parentIdx2 = findSet(change(r2, c2));
                    
                    if (values[parentIdx1].equals("")) {
                        p[parentIdx1] = parentIdx2;
                    } else {
                        p[parentIdx2] = parentIdx1;
                    }
                    
                    break;
                    
                case "UNMERGE":
                    int r = Integer.parseInt(st.nextToken());
                    int c = Integer.parseInt(st.nextToken());
                    
                    int idx = change(r, c);
                    
                    int parentIdx = findSet(idx);
                    
                    String value = values[parentIdx];
                    
                    for (int i = 1; i <= 2500; ++i) {
                        findSet(i);
                    }
                    
                    for (int i = 1; i <= 2500; ++i) {
                        if (parentIdx == findSet(i)) {
                            p[i] = i;
                            values[i] = "";
                        }
                    }
                    
                    values[idx] = value;
                    
                    break;
                    
                case "PRINT":
                    r = Integer.parseInt(st.nextToken());
                    c = Integer.parseInt(st.nextToken());
                    
                    idx = change(r, c);
                    
                    parentIdx = findSet(idx);
                    
                    value = values[parentIdx];
                    
                    list.add(value.equals("") ? "EMPTY" : value);
                    
                    break;
            }
        }
        
        return list.stream().toArray(String[]::new);
    }
    
    void makeSet() {
        for (int i = 1; i <= 2500; ++i) {
            p[i] = i;
            values[i] = "";
        }
    }
    
	int findSet(int x) {
		if (x != p[x]) p[x] = findSet(p[x]);
		return p[x];
	}
    
    void union(int x, int y) {
        p[y] = x;
    }
    
    int change(int x, int y) {
        return 50 * (x-1) + y;
    }
}