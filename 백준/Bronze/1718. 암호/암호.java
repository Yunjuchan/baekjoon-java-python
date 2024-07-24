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
        
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<A.length; i++) {
            if (A[i] == ' ') {
                sb.append(' ');
                continue;
            }
            int next = A[i] - (E[i % E.length] - 96);
//            System.out.println("idx: " + idx + " next: " + next);
            if (next < 97) {
                sb.append((char) (next + 26));
            } else {
                sb.append((char) (next));
            }
        }
        System.out.println(sb.toString());
    }
}