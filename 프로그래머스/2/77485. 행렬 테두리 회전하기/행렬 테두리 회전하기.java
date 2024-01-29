class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int num = 1;
        
        int[][] map = new int[rows][columns];
        for (int i = 0; i < rows; ++i)
            for (int j = 0; j < columns; ++j)
                map[i][j] = num++;
        
        for (int i = 0; i < queries.length; ++i) {
            int r1 = queries[i][0]-1;
            int c1 = queries[i][1]-1;
            int r2 = queries[i][2]-1;
            int c2 = queries[i][3]-1;
            int start = map[r1][c1], min = start;
            
            for (int j = r1; j < r2; ++j)
                min = Math.min(min, map[j][c1] = map[j+1][c1]);
            for (int j = c1; j < c2; ++j)
                min = Math.min(min, map[r2][j] = map[r2][j+1]);
            for (int j = r2; j > r1; --j)
                min = Math.min(min, map[j][c2] = map[j-1][c2]);
            for (int j = c2; j > c1; --j)
                min = Math.min(min, map[r1][j] = map[r1][j-1]);
            map[r1][c1+1] = start;
            
            answer[i] = min;
        }
        
        return answer;
    }
}