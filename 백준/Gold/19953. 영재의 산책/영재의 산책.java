import java.io.*;
import java.util.*;

public class Main {

    static int[] dy = new int[] {1, 0, -1, 0};
    static int[] dx = new int[] {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        /**
         * m의 1의자리 수가 0일 때 -> 바로 0;
         * m의 1의 자리 수가 1일 때, v 반복; v가
         * m의 1의 자리 수가 2일 때, 2, 4, 8, 6 * v반복;
         * m의 1의 자리 수가 3일 때, 3, 9, 7, 1 반복;
         * m의 1의 자리 수가 4일 때, 4, 6 반복;
         * m의 1의 자리 수가 5일 때, 5 반복;
         * m의 1의 자리 수가 6일 때, 6 반복;
         * m의 1의 자리 수가 7일 때, 7, 9, 1 반복;
         * 1 7 9 1 / 2 4 8 6
         * m의 1의 자리 수가 8일 때, 8, 4, 2, 6반복;
         * m의 1의 자리 수가 9일 때, 9, 1 반복;
         * m의 1의 자리 수가 1일 때, v 반복;
         *
         */
        int v = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken()) - 1;

        long y = v, x = 0;
        long my = 0, mx = 0;

        List<int[]> moves = new ArrayList<>();

        for (int time = 1; time < 5; time++) {
            v = (v * m) % 10;
            int[] cur = new int[] {dy[time % 4] * v, dx[time % 4] * v};
            my += cur[0];
            mx += cur[1];
            moves.add(cur);
        }

        int res = t % 4;
        y += (t / 4) * my;
        x += (t / 4) * mx;
        for (int i = 0; i < res; i++) {
            y += moves.get(i)[0];
            x += moves.get(i)[1];
        }

        System.out.println(x + " " + y);
    }
}