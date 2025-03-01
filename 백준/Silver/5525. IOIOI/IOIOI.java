import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String line = br.readLine();
        String target = "I" + "OI".repeat(N);

        int result = 0;

        for (int i = 0; i <= M - 2 * N - 1; i++) {
            if (target.equals(line.substring(i, i + 2 * N + 1))) {
                result++;
            }
        }
        System.out.println(result);
    }
}