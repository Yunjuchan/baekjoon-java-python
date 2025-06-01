import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if (A == 0 && B == 0) {
                System.out.println(sb);
                return;
            } else if (A % B == 0 && B % A != 0) {
                sb.append("multiple").append("\n");
            } else if (A % B != 0 && B % A == 0) {
                sb.append("factor").append("\n");
            } else {
                sb.append("neither").append("\n");
            }
        }

    }
}