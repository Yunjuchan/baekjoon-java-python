import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= N; i++) {
            sb.append(String.format("%" + N + "s", "*".repeat(i))).append("\n");
        }
        for (int i = N - 1; i > 0; i--) {
            sb.append(String.format("%" + N + "s", "*".repeat(i))).append("\n");
        }
        System.out.println(sb);
    }
}
