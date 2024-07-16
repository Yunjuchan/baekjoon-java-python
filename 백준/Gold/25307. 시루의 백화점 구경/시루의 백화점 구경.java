import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] A;
    static boolean[][] visited;
    static int[] directY = {1,0,-1,0};
    static int[] directX = {0,1,0,-1};
    static void changeA(Queue<int[]> que) {
        while (!que.isEmpty()) {
            int[] now = que.poll();
            int cnt = now[0];
            int nowY = now[1];
            int nowX = now[2];
            for (int i=0; i<4; i++) {
                int nextY = nowY+directY[i];
                int nextX = nowX+directX[i];
//                System.out.println(nextY + " " + nextX);
                if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= M || A[nextY][nextX] == 3) {
                    continue;
                }
                visited[nextY][nextX] = true;
                A[nextY][nextX] = 3;
                if (cnt<K-1) {
                    que.offer(new int[]{cnt+1, nextY, nextX});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<int[]> que = new LinkedList<>();
        Queue<int[]> que2 = new LinkedList<>();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        visited = new boolean[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    A[i][j] = 1;
                    visited[i][j] = true;
                } else if (tmp == 2) {
                    if (A[i][j] == 0) {
                        A[i][j] = 2;
                    }
                } else if (tmp == 3) {
                    que2.offer(new int[]{0, i, j});
                    visited[i][j] = true;
                } else if (tmp == 4){
                    que.offer(new int[]{0,i,j});
                    visited[i][j] = true;
                }
            }
        }
        if (K != 0) {
            changeA(que2);
        }

        int result = -1;
        while (!que.isEmpty()) {
            int[] now = que.poll();
            int cnt = now[0];
            int nowY = now[1];
            int nowX = now[2];
            if (A[nowY][nowX] == 2) {
                result = cnt;
                break;
            }
            for (int i=0; i<4; i++) {
                int nextY = nowY+directY[i];
                int nextX = nowX+directX[i];
                if (nextY < 0 || nextX < 0 || nextY >= N || nextX >= M || visited[nextY][nextX]) {
                    continue;
                }
                visited[nextY][nextX] = true;
                que.offer(new int[]{cnt+1, nextY, nextX});
            }
        }
        System.out.println(result);


//        for (int i=0; i<N; i++) {
//            for (int j=0; j<N; j++) {
//                System.out.print(A[i][j]);
//            }
//            System.out.println();
//        }
    }
}