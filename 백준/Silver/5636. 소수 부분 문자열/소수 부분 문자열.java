import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        boolean[] isPrime = new boolean[100000];
        for (int i=2; i<100000; i++) {
            isPrime[i] = true;
        }

        for (int i=2; i*i<100000; i++) {
            if (isPrime[i]) {
                for (int j=i*i; j<100000; j+=i) {
                    isPrime[j] = false;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String stringNumber = st.nextToken();

            if (stringNumber.equals("0")) {
                break;
            }

            int length = stringNumber.length();
            int result = 0;
            for (int i=1; i<6; i++) {
                for (int j=0; j<length-i; j++) {
                    String sub = stringNumber.substring(j, j+i);
                    int n = Integer.parseInt(sub);
                    if (isPrime[n]) {
                        result = n;
                    }
                }
            }
            System.out.println(result);
        }
    }
}