import java.io.*;
import java.util.*;

public class Main {

    public static int gcd(int n, int m) {

        while (m != 0) {
            int l = n % m;
            n = m;
            m = l;
        }
        return n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(":");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);

        int g = gcd(n, m);
        System.out.println((n / g) + ":" + (m / g));
    }
}