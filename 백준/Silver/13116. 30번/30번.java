import java.io.*;
import java.util.*;

public class Main {

    static int[] depths, parents;
    public static int LCA(int A, int B) {
        int dA = depths[A];
        int dB = depths[B];
        int dMin = Math.min(dA, dB);

        while (dA != dMin) {
            dA--;
            A = parents[A];
        }

        while (dB != dMin) {
            dB--;
            B = parents[B];
        }

        while (A != B) {
            A = parents[A];
            B = parents[B];
        }

        return A;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int x = 1;
        int d = 2;
        depths = new int[1024];
        parents = new int[1024];
        for (int i = 1; i < 1024; i++) {
            if (i > x - 1) {
                x *= 2;
                d++;
            }
            parents[i] = i / 2;
            depths[i] = d;
        }

        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append(LCA(A, B) * 10).append("\n");
        }
        System.out.println(sb);
    }
}