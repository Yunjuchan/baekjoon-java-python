import javax.management.StringValueExp;
import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, a, b;
    static boolean[][] status;
    static boolean[][] nextStatus;
    static int[][] A;
    static int[][] nextA;
    static void nextStatus(int y, int x) {
        int cnt = status[y][x] ? -1 : 0;
        for (int i=Math.max(0, y-K); i<=Math.min(y+K, N-1); i++) {
            int left = x-K-1;
            int right = Math.min(x+K, M-1);
            int leftN;
            int rightN;
            if (left < 0) {
                leftN = 0;
            } else {
                leftN = A[i][left];
            }
            rightN = A[i][right];
            cnt += rightN - leftN;
        }
//        System.out.println("y: " + y + " x: " + x + " cnt: " + cnt + " now status: " + status[y][x]);
        if (status[y][x] && cnt >= a && cnt <= b) {
//            System.out.println("y: " + y + " x: " + x + " cnt: " + cnt + " now status: " + status[y][x] + " => 생존");
            nextStatus[y][x] = true;
            nextA[y][x]++;
        } else if (!status[y][x] && cnt > a && cnt <= b) {
//            System.out.println("y: " + y + " x: " + x + " cnt: " + cnt + " now status: " + status[y][x] + " => 탄생");
            nextStatus[y][x] = true;
            nextA[y][x]++;
        }
        if (x<M-1) {
            nextA[y][x+1] = nextA[y][x];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        status = new boolean[N][M];
        A = new int[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j=0; j<M; j++) {
                char now = line.charAt(j);
                if (now == '*') {
                    status[i][j] = true;
                    A[i][j]++;
                }
                if (j<M-1) {
                    A[i][j+1] = A[i][j];
                }
//                System.out.print(A[i][j]);
            }
//            System.out.println();
        }

        for (int t=0; t<T; t++) {
            nextA = new int[N][M];
            nextStatus = new boolean[N][M];
//            System.out.println("t: " + t);
            for (int i=0; i<N; i++) {
                for (int j=0; j<M; j++) {
                    nextStatus(i, j);
                }
            }
            A = nextA;
            status = nextStatus;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (status[i][j]) {
                    sb.append('*');
                } else {
                    sb.append('.');
                }
            }
            sb.append('\n');
        }
        System.out.print(sb.toString());
    }
}