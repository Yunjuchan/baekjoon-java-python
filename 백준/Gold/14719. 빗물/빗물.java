import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        boolean[][] arr = new boolean[H][W];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<W; i++) {
            int h = Integer.parseInt(st.nextToken());
            for (int j=0; j<h; j++) {
                arr[j][i] = true;
            }
        }

        int result = 0;
        for (int i=0; i<H; i++) {
            boolean flag = false;
            int cnt = -1;
            for (int j=0; j<W; j++) {
                if (!flag && arr[i][j]) {
                    flag = true;
                    cnt = 0;
                } else if (flag && arr[i][j]) {
                    result += cnt;
                    cnt = 0;
                } else if (flag && !arr[i][j]) {
                    cnt++;
                }
            }
        }

        System.out.println(result);
    }
}