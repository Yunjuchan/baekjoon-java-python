import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] day = new int[]{31, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            if ((y % 4 == 0 && y % 100 != 0) || y % 400 == 0) {
                day[2] += 1;
            }
            if (m == 1) {
                System.out.println((y - 1) + " 12 31");
            } else {
                System.out.println(y + " " + (m - 1) + " " + day[m - 1]);
            }
        }
    }
}