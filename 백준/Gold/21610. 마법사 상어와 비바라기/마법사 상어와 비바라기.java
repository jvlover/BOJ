import java.io.*;
import java.util.*;
public class Main {
    
    static class Cloud {
        int r, c;
        Cloud(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    
    static int N, M;
    static int[][] map;
    static boolean[][] visit;
    static List<Cloud> clouds;
    
    static BufferedReader br;
    static StringTokenizer st;
    
    static final int ROW = 0, COL = 1;
    static int[][] delta = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
    
    public static void main(String[] args) throws Exception {
        init();
        
        while (M-->0) {
            move();
            copyWater();
            clouds.clear();
            makeCloud();
        }
        
        solve();
    }
    
    static void init() throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][N];
        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; ++j) map[i][j] = Integer.parseInt(st.nextToken());
        }
        
        clouds = new ArrayList<>();
        clouds.add(new Cloud(N-1, 0));
        clouds.add(new Cloud(N-1, 1));
        clouds.add(new Cloud(N-2, 0));
        clouds.add(new Cloud(N-2, 1));
    }
    
    static void move() throws Exception {
        
        st = new StringTokenizer(br.readLine());
        int dir = Integer.parseInt(st.nextToken())-1;
        int dist = Integer.parseInt(st.nextToken());
        
        visit = new boolean[N][N];
        for (Cloud cloud : clouds) {
            int nr = cloud.r + delta[dir][ROW]*(dist%N);
            int nc = cloud.c + delta[dir][COL]*(dist%N);
            
            cloud.r = nr = nr < 0 ? nr+N : nr >= N ? nr-N : nr;
            cloud.c = nc = nc < 0 ? nc+N : nc >= N ? nc-N : nc;
            
            ++map[nr][nc];
            visit[nr][nc] = true;
        }
    }
    
    static void copyWater() {
        int[][] tempMap = new int[N][N];
        
        for (Cloud cloud : clouds) {
            int cnt = 0;
            for (int dir = 1; dir < 8; dir += 2) {
                int nr = cloud.r + delta[dir][ROW];
                int nc = cloud.c + delta[dir][COL];
                if (nr >= 0 && nc >= 0 && nr < N && nc < N && map[nr][nc] > 0) ++cnt;
            }
            
            tempMap[cloud.r][cloud.c] = cnt;
        }
        
        for (int i = 0; i < N; ++i)
            for (int j = 0; j < N; ++j)
                map[i][j] += tempMap[i][j];
    }
    
    static void makeCloud() {
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                if (!visit[i][j] && map[i][j] >= 2) {
                    map[i][j] -= 2;
                    clouds.add(new Cloud(i, j));
                }
            }
        }
    }
    
    static void solve() {
        int ans = 0;
        for (int[] arr : map)
            for (int water : arr)
                ans += water;
        System.out.print(ans);
    }
}