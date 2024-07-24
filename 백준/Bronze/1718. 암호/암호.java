import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        char[] A;
        A = line.toCharArray();

        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] E;
        E = st.nextToken().toCharArray();
        char[] B = new char[A.length];
        for (int i=0; i<A.length; i++) {
            if (A[i] == ' ') {
                System.out.print(" ");
                continue;
            }
            int idx = E[i % E.length] - 96;
            int next = A[i] - idx;
//            System.out.println("idx: " + idx + " next: " + next);
            if (next < 97) {
                B[i] = (char) (next + 26);
            } else {
                B[i] = (char) (next);
            }
            System.out.print(B[i]);
        }

    }
}