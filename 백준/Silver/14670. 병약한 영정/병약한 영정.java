import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;

        int N = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> pills = new HashMap<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int e = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            pills.put(e, n);
        }
        int R = Integer.parseInt(br.readLine());
        for (int i=0; i<R; i++) {
            sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());

            for (int j=0; j<L; j++) {
                int S = Integer.parseInt(st.nextToken());
                if (pills.containsKey(S)) {
                    sb.append(pills.get(S)).append(" ");
                } else {
                    sb = new StringBuilder();
                    sb.append("YOU DIED");
                    break;
                }
            }
            System.out.println(sb.toString());
        }
    }
}