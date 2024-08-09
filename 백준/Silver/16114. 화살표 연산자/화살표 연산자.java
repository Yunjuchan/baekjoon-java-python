import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        // 0 < (양수)
        if (x < 0 && n == 1) {
            System.out.println("INFINITE");
            return;
        }

        // 0 < (음수)
        if (x >= 0 && n == 1) {
            System.out.println("0");
            return;
        }

        //
        if (n % 2 == 1) {
            System.out.println("ERROR");
            return;
        }

        if (x <= 0) {
            System.out.println("0");
            return;
        }

        if (n == 0) {
            System.out.println("INFINITE");
            return;
        }

        n = n / 2;
        System.out.println((x + n - 1) / n - 1);
    }
}