import java.io.*;
import java.util.*;

public class Main {
    static int N, M, V, space, result = Integer.MAX_VALUE;
    static int[] dy, dx;
    static int[][] lab;
    static List<int[]> virusPosition;

    public static class Virus {
       int t;
       int y;
       int x;

       public Virus(int t, int y, int x) {
           this.t = t;
           this.y = y;
           this.x = x;
       }
    }

    public static void dfs(int start, int level, int[] virusList) {
        if ((V - start) < (M - level)) {
            return;
        }

        if (level == M) {
            result = Math.min(result, spread(virusList));
            return;
        }
        dfs(start + 1, level, virusList);
        virusList[level] = start;
        dfs(start + 1, level + 1, virusList);
        virusList[level] = 0;
    }


    public static int spread(int[] virusList) {
        int cnt = 0;
        int last = 0;
        int[][] arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(arr[i], -1);
        }

        Queue<Virus> que = new LinkedList<>();
        for (int v : virusList) {
            int y = virusPosition.get(v)[0];
            int x = virusPosition.get(v)[1];
            que.offer(new Virus(0, y, x));
            arr[y][x] = 0;
        }

        while (!que.isEmpty()) {
            Virus virus = que.poll();
            if (lab[virus.y][virus.x] == 0) {
                cnt++;
                last = virus.t;
            }

            for (int i = 0; i < 4; i++) {
                int ny = virus.y + dy[i];
                int nx = virus.x + dx[i];
                if (ny < 0 || nx < 0 || ny >= N || nx >= N || arr[ny][nx] != -1 || lab[ny][nx] == 1) {
                    continue;
                }
                arr[ny][nx] = virus.t + 1;
                que.offer(new Virus(arr[ny][nx], ny, nx));
            }
        }

        if (cnt != space) {
            return Integer.MAX_VALUE;
        }
        return last;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = 0;
        space = N * N;
        dy = new int[] {1,0,-1,0};
        dx = new int[] {0,1,0,-1};
        lab = new int[N][N];
        virusPosition = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 2) {
                    V++;
                    virusPosition.add(new int[]{i, j});
                }
                if (lab[i][j] != 0) {
                    space--;
                }
            }
        }

        dfs(0,0, new int[M]);
        if (result == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }
    }
}