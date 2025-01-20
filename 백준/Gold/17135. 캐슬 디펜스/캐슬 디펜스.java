import java.io.*;
import java.util.*;

public class Main {
    static int N, M, D, result = 0;
    public static int[][] arr;
    public static int kill(Set<Integer> archers, int[][] arr, int D) {
        int cnt = 0;
        int[] dist = new int[M];
        int[][] target = new int[M][2];
        int[][] cloneArr = new int[N][M];
        for (int i=0; i<N; i++) {
            cloneArr[i] = arr[i].clone();
        }

        for (int i=0; i<N; i++) {

            for (int x : archers) {
                dist[x] = Integer.MAX_VALUE;
                target[x] = new int[]{-1,-1};
            }

            for (int j=N-1-i; j>=0; j--) {
                for (int k=0; k<M; k++) {
                    for (int a : archers) {
                        if (cloneArr[j][k] == 1) {
                            int d = (N - i - j) + Math.abs(a - k);
                            if (d <= D && d < dist[a]) {
                                dist[a] = d;
                                target[a][0] = j;
                                target[a][1] = k;
                            } else if(d <= D && d == dist[a] && target[a][1] > k) {
                                target[a][0] = j;
                                target[a][1] = k;
                            }
                        }
                    }
                }
            }

            for (int a : archers) {
                int y = target[a][0];
                int x = target[a][1];
                if (y == -1 && x == -1) {
                    continue;
                }
                if (cloneArr[y][x] == 1)  {
                    cloneArr[y][x] = 0;
                    cnt++;
                }
            }

            for(int k=0; k<M; k++) {
                int y = N-i-1;
                if (cloneArr[y][k] == 1) {
                    archers.remove(k);
                }
            }
        }
        return cnt;
    }

    public static void dfs(int start, int level, Set<Integer> archers) {
        if (level == 3) {
            int cnt = kill(archers, arr, D);
            result = Math.max(result, cnt);
            return;
        }

        for (int i=start; i<M; i++) {
            archers.add(i);
            dfs(i+1, level+1, archers);
            archers.remove(i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0, new HashSet<>());
        System.out.println(result);
    }
}