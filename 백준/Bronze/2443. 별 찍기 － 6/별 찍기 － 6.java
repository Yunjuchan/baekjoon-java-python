import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            sb.append(" ".repeat(i));
            sb.append("*".repeat(2 * N - 2 * i - 1)).append("\n");
        }
        System.out.println(sb);
    }
}