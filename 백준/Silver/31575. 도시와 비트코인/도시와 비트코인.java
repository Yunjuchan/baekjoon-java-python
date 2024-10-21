import java.io.*;
import java.util.*;

public class Main {

    public static class Position {
        int y;
        int x;

        public Position (int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    static int[] directY = {1,0};
    static int[] directX = {0,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] A = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Position> que = new LinkedList<>();
        que.offer(new Position(0, 0));
        A[0][0] = 0;

        while (!que.isEmpty()) {
            Position p = que.poll();
            for (int i=0; i<2; i++) {
                int dy = directY[i] + p.y;
                int dx = directX[i] + p.x;
                if (dy < 0 || dx < 0 || dy >= N || dx >= M || A[dy][dx] == 0) {
                    continue;
                }
                A[dy][dx] = 0;
                
                que.offer(new Position(dy, dx));
            }
            if (A[N-1][M-1] == 0) {
                break;
            }
        }

        if (A[N-1][M-1] == 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }
}