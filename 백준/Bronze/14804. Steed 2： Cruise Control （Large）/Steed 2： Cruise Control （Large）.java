import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            double second = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                double K = Integer.parseInt(st.nextToken());
                double S = Integer.parseInt(st.nextToken());

                second = Math.max(second, (D - K) / S);
            }

            double speed = D / second;
            System.out.printf("Case #%d: %.6f\n", t, speed);
        }
    }
}