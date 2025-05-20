import java.io.*;
import java.util.*;

public class Main {

    public static int gcd(int A, int B) {
        while (B != 0) {
            int tmp = B;
            B = A % B;
            A = tmp;
        }
        return A;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        long lcm = A;
        lcm *= B;
        lcm /= gcd(A, B);
        System.out.println(lcm);
    }
}

