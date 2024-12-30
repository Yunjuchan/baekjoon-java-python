import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A1 = Integer.parseInt(st.nextToken());
        int B1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int A2 = Integer.parseInt(st.nextToken());
        int B2 = Integer.parseInt(st.nextToken());

        int B = B1 * B2;
        int A = A1 * B2 + A2 * B1;

        if (A > B) {
            int a = A;
            int b = B;
            while (b != 0) {
                int tmp = b;
                b = a % b;
                a = tmp;
            }
            System.out.println((A / a) + " " + (B / a));
        } else {
            int a = B;
            int b = A;
            while (b != 0) {
                int tmp = b;
                b = a % b;
                a = tmp;
            }
            System.out.println((A / a) + " " + (B / a));
        }


    }
}