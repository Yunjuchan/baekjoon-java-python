import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < 7; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n % 2 != 1) {
                continue;
            }
            min = Math.min(min, n);
            sum += n;
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}