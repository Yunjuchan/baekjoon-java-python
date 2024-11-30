import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            long x1 = Integer.parseInt(st.nextToken());
            long y1 = Integer.parseInt(st.nextToken());
            long r1 = Integer.parseInt(st.nextToken());
            long x2 = Integer.parseInt(st.nextToken());
            long y2 = Integer.parseInt(st.nextToken());
            long r2 = Integer.parseInt(st.nextToken());

            if (x1 == x2 && y1 == y2 && r1 == r2) {
                System.out.println(-1);
                continue;
            }

            double dist = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
            dist = Math.sqrt(dist);
            if (dist > r1+r2 || dist < Math.abs(r1-r2)) {
                System.out.println(0);
            } else if (dist == r1+r2 || dist == Math.abs(r1-r2)) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
    }
}