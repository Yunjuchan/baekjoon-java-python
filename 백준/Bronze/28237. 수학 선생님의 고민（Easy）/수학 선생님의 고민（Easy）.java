import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        double D = (N + 1) * (N + 1) + 4 * N * (N + 2);
        double sqrtD = Math.sqrt(D);

        if (sqrtD != (int) sqrtD) {
            System.out.println(-1);
            return;
        }

        double x = (-(N + 1) + sqrtD) / (2 * N);
        double y = (-(N + 1) - sqrtD) / (2 * N);

        for (int a = 1; a <= N; a++) {
            if (N % a == 0) {
                int c = N / a;

                if (x * a == (int) (x * a) && y * c == (int) (y * c)) {
                    int b = (int) - (x * a);
                    int d = (int) - (y * c);
                    System.out.println(a + " " + b + " " + c + " " + d);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}