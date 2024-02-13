class Solution {
    public int solution(String[] board) {
        char[][] map = new char[3][3];
        
        int oCnt = 0, xCnt = 0;
        
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                map[i][j] = board[i].charAt(j);
                if (map[i][j] == 'O') ++oCnt;
                else if (map[i][j] == 'X') ++xCnt;
            }
        }
        
        if (oCnt != xCnt && oCnt != xCnt+1) return 0;
        
        boolean oFlag = false, xFlag = false;
        for (int i = 0; i < 3; ++i) {
            if (map[i][0] == 'O' && map[i][1] == 'O' && map[i][2] == 'O') oFlag = true;
            if (map[i][0] == 'X' && map[i][1] == 'X' && map[i][2] == 'X') xFlag = true;
            if (map[0][i] == 'O' && map[1][i] == 'O' && map[2][i] == 'O') oFlag = true;
            if (map[0][i] == 'X' && map[1][i] == 'X' && map[2][i] == 'X') xFlag = true;
        }
        if (map[0][0] == 'O' && map[1][1] == 'O' && map[2][2] == 'O') oFlag = true;
        if (map[0][0] == 'X' && map[1][1] == 'X' && map[2][2] == 'X') xFlag = true;
        if (map[0][2] == 'O' && map[1][1] == 'O' && map[2][0] == 'O') oFlag = true;
        if (map[0][2] == 'X' && map[1][1] == 'X' && map[2][0] == 'X') xFlag = true;
        
        if ((oFlag && oCnt != xCnt+1) || (xFlag && oCnt != xCnt)) return 0;
        
        return 1;
    }
}