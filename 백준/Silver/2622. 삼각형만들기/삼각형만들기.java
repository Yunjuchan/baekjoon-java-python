import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        if (N < 3) {
            System.out.println(0);
            return;
        }
        int count = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 1; i + j < N; j++) {
                if (i < j || i < N - i - j) {
                    continue;
                }
                if (j < N - i - j) {
                    continue;
                }
                if (i < N - i) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}