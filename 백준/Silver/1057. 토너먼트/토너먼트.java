import java.io.*;
import java.util.HashSet;
import java.util.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken())+1;
        int L = Integer.parseInt(st.nextToken())+1;
        int result = 0;
        while (K != L) {
            result++;

            K /= 2;
            K += 1;

            L /= 2;
            L += 1;
        }
        System.out.println(result);
    }
}
