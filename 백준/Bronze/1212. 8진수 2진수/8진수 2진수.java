import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        String N = br.readLine();

        String[] A = new String[] {"000", "001", "010", "011", "100", "101", "110", "111"};
        String[] B = new String[] {"0", "1", "10", "11", "100", "101", "110", "111"};

        sb.append(B[N.charAt(0) - '0']);
        for (int i = 1; i < N.length(); i++) {
            sb.append(A[N.charAt(i) - '0']);
        }
        
        System.out.println(sb);
    }
}
