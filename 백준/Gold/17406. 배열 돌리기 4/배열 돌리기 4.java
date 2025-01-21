import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, result = Integer.MAX_VALUE;
    static boolean[] visited;
    static int[][] arr, query;
    static int[] directY = {0,1,0,-1};
    static int[] directX = {1,0,-1,0};

    public static int[][] swapArr(int[] order) {
        int[][] newArr = new int[N][M];
        for (int i=0; i<N; i++) {
            newArr[i] = arr[i].clone();
        }

        for (int o : order) {
            int[] q = query[o];
            for (int i=1; i<=q[2]; i++) {   // 돌리는 크기
                int y = q[0] - i;
                int x = q[1] - i;

                int prev = newArr[y][x];
                int now = -1;
                for (int j=0; j<4; j++) {   // 우 하 좌 상 돌리기
                    for (int k=0; k<2*i; k++) {
                        y += directY[j];
                        x += directX[j];

                        now = newArr[y][x];
                        newArr[y][x] = prev;
                        prev = now;
                    }
                }

            }
        }
        return newArr;
    }

    public static void dfs(int level, int[] order) {
        if (level == K) {
            // MAX : 720회
            int[][] newArr = swapArr(order);

            for (int i=0; i<N; i++) {
                result = Math.min(result, Arrays.stream(newArr[i]).sum());
            }
        }

        for (int i=0; i<K; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            order[level] = i;
            dfs(level+1, order);
            order[level] = 0;
            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        query = new int[K][3];
        visited = new boolean[K];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k=0; k<K; k++) {
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<2; i++) {
                query[k][i] = Integer.parseInt(st.nextToken())-1;
            }
            query[k][2] = Integer.parseInt(st.nextToken());
        }

        dfs(0, new int[K]);
        System.out.println(result);
    }
}