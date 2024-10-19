import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        if (N % 2 == 0) {
            int q = N / 2;
            for (int i=1; i<=q; i++) {
                sb.append(i).append(" ").append(-i).append(" ");
            }
            sb.append(0);
        } else {
            int q = N / 2;
            for (int i=1; i<=q; i++) {
                sb.append(i).append(" ").append(-i).append(" ");
            }
            sb.append(N*N).append(" ").append(N);
        }

        System.out.println(sb.toString());
    }
}