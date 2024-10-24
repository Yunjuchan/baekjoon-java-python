import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Set<Integer> S = new HashSet<>();
        int a = 1;
        for (int i=1; i<=10; i++) {
            a *= 2;
            S.add(a);
        }
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = B * B - 4 * A * C;
        if (D <= 0) {
            System.out.println("둘다틀렸근");
            return;
        }
        double x = (-B + Math.sqrt(D)) / (2 * A);
        double y = (-B - Math.sqrt(D)) / (2 * A);
        double zero = 0.0;

        if (x - (int) x != zero || y - (int) y != zero) {
            System.out.println("둘다틀렸근");
        } else if (!S.contains((int) x) || !S.contains((int) y)) {
            System.out.println("정수근");
        } else {
            System.out.println("이수근");
        }
    }
}