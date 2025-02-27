import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int max = Integer.MAX_VALUE - 1;
        for (int i = 0; i < N; i++) {
            max = Math.min(max + 1, Integer.parseInt(st.nextToken()));
            sb.append(max).append(" ");
        }
        System.out.println(sb);
    }
}