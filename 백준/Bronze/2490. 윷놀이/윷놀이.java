import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = 0;
            for (int j = 0; j < 4; j++) {
                cnt += Integer.parseInt(st.nextToken());
            }
            if (cnt == 0) {
                sb.append("D").append("\n");
            } else if (cnt == 1) {
                sb.append("C").append("\n");
            } else if (cnt == 2) {
                sb.append("B").append("\n");
            } else if (cnt == 3) {
                sb.append("A").append("\n");
            } else {
                sb.append("E").append("\n");
            }
        }
        System.out.println(sb);
    }
}