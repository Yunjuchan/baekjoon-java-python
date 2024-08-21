import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            if (A < B) {
                int tmp = A;
                A = B;
                B = tmp;
            }
            int X = Integer.parseInt(st.nextToken());
            while (B != 0) {
                int tmp = A % B;
                A = B;
                B = tmp;
            }
            System.out.println(X / A);
        }

    }
}