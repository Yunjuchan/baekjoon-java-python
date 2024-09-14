import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static int gcd(int a, int b) {
        if (b > a) {
            int swap = b;
            b = a;
            a = swap;
        }
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int count = 0;

        for (int x1 = 0; x1 <= N; x1++) {
            for (int y1 = 0; y1 <= M; y1++) {
                for (int x2 = 0; x2 <= N; x2++) {
                    for (int y2 = 0; y2 <= M; y2++) {
                        if (x1 == x2 && y1 == y2) continue;
                        int dx = Math.abs(x2 - x1);
                        int dy = Math.abs(y2 - y1);

                        int g = gcd(dx, dy);

                        int points = g + 1;

                        if (points == K) {
                            count++;
                        }
                    }
                }
            }
        }

        System.out.println(count / 2);
    }
}