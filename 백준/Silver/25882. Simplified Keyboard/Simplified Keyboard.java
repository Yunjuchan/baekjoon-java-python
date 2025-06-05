import java.io.*;
import java.util.*;

public class Main {

    public static boolean check(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        } else {
            for (int i = 0; i < A.length(); i++) {
                int a = A.charAt(i) - 'a';
                int b = B.charAt(i) - 'a';
                int rowA = a / 9;
                int colA = a % 9;
                int rowB = b / 9;
                int colB = b % 9;
                if (Math.abs(rowA - rowB) > 1 || Math.abs(colA - colB) > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();

            if (A.equals(B)) {
                sb.append(1).append("\n");
            } else if (check(A, B)) {
                sb.append(2).append("\n");
            } else {
                sb.append(3).append("\n");
            }
        }
        System.out.println(sb);
    }
}