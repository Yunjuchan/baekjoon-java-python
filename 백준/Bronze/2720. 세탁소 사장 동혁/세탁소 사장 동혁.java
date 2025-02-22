import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            sb = new StringBuilder();
            int C = Integer.parseInt(br.readLine());

            sb.append(C / 25).append(" ");
            C %= 25;

            sb.append(C / 10).append(" ");
            C %= 10;

            sb.append(C / 5).append(" ");
            C %= 5;

            sb.append(C / 1).append(" ");
            C %= 1;
            System.out.println(sb);
        }
    }
}