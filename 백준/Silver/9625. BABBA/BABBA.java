import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(br.readLine());
//        StringBuilder sb = new StringBuilder();
        int A = 1; int B = 0;
        for (int i=0; i<K; i++) {
            int tmpA = B;
            int tmpB = A + B;

            A = tmpA;
            B = tmpB;
        }
        System.out.println(A + " " + B);

    }
}