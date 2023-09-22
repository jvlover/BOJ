class Solution {
    int N, M, len;
    int[][] map, key, lock;
    public boolean solution(int[][] key, int[][] lock) {
        N = lock.length;
        M = key.length;
        len = N+(M-1)*2;
        
        this.key = key;
        this.lock = lock;
        
        makeMap();
        
        boolean answer = checkMap();
        
        return answer;
    }
    
    void makeMap() {
        
        map = new int[len][len];
        
        for (int i = M-1; i < M+N-1; ++i)
            for (int j = M-1; j < M+N-1; ++j)
                map[i][j] = lock[i-M+1][j-M+1];
    }
    
    boolean checkMap() {
        
        for (int i = 0; i < 4; ++i) {
            if (check()) return true;
            rotateMap();
        }
        
        return false;
    }
    
    boolean check() {
        
        for (int i = 0; i < len-M+1; ++i) {
            for (int j = 0; j < len-M+1; ++j) {
                
                for (int k = 0; k < M; ++k)
                    for (int l = 0; l < M; ++l)
                        map[i+k][j+l] += key[k][l];
                
                if (checkAllFit()) return true;
                
                for (int k = 0; k < M; ++k)
                    for (int l = 0; l < M; ++l)
                        map[i+k][j+l] -= key[k][l];
            }
        }
        
        return false;
    }
    
    boolean checkAllFit() {
        
        for (int i = M-1; i < N+M-1; ++i)
            for (int j = M-1; j < N+M-1; ++j)
                if (map[i][j] != 1) return false;
            
        return true;
    }
    
    void rotateMap() {
        
        int[][] copyMap = new int[len][len];
        
        for (int i = 0; i < len; ++i)
            for (int j = 0; j < len; ++j)
                copyMap[i][j] = map[len-j-1][i];
        
        copy(copyMap);
    }
    
    void copy(int[][] copyMap) {
        
        for (int i = 0; i < len; ++i)
            map[i] = copyMap[i].clone();
    }
}