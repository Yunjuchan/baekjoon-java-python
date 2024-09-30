import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] now = new int[2][N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int x = Integer.parseInt(st.nextToken());
            now[0][i] = x;
            now[1][i] = x;
        }
        int[][] goal = new int[2][N];
        st = new StringTokenizer(br.readLine());
        int idx = 0;
        for (int i=0; i<M; i++) {
            int n = Integer.parseInt(st.nextToken());

            for (int j=0; j<n; j++) {
                goal[0][idx] = i % 2;
                goal[1][idx] = (i+1) % 2;
                idx++;
            }
        }

        int cnt1 = 0;
        for (int i=0; i<N; i++) {
            boolean flag = false;
            if (now[0][i] == goal[0][i]) {
                continue;
            }
            int change = -1;
            for (int j=i+1; j<N; j++) {
                if (now[0][j] == goal[0][i]) {
                    flag = true;
                    change = j;
                    break;
                }
            }
            if (flag) {
                cnt1 += change-i;
                for (int j = change; j>i; j--) {
                    int tmp = now[0][j];
                    now[0][j] = now[0][j-1];
                    now[0][j-1] = tmp;
                }
            } else {
                cnt1 = Integer.MAX_VALUE;
                break;
            }
//            System.out.println("cnt1: " + cnt1);
//            System.out.println("now[0]: ");
//            for (int x : now[0]) {
//                System.out.print(x + " ");
//            }
//            System.out.println();
        }

        int cnt2 = 0;
        for (int i=0; i<N; i++) {
            boolean flag = false;
            if (now[1][i] == goal[1][i]) {
                continue;
            }
            int change = -1;
            for (int j=i+1; j<N; j++) {
                if (now[1][j] == goal[1][i]) {
                    flag = true;
                    change = j;
                    break;
                }
            }
            if (flag) {
                cnt2 += change-i;
                for (int j=change; j>i; j--) {
                    int tmp = now[1][j];
                    now[1][j] = now[1][j-1];
                    now[1][j-1] = tmp;
                }
            } else {
                cnt2 = Integer.MAX_VALUE;
                break;
            }
//            System.out.println("cnt2: " + cnt2);
//            System.out.println("now[1]: ");
//            for (int x : now[1]) {
//                System.out.print(x + " ");
//            }
//            System.out.println();
        }
//        System.out.println("cnt1: " + cnt1 + " cnt2: " + cnt2);
        System.out.println(Math.min(cnt1, cnt2));
    }
}