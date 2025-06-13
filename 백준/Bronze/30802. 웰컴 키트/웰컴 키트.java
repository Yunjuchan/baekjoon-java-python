import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] size = new int[6];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            size[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int shirt = 0;
        for (int i = 0; i < 6; i++) {
            shirt += (size[i] + T - 1) / T;
        }
        System.out.println(shirt);
        System.out.println(N / P + " " + N % P);
    }
}