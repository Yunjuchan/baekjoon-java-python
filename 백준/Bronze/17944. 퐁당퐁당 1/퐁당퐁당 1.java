import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int order = T % (4*N-2);
        if (order == 0) {
            System.out.println(2);
        }
        else if (order <= 2*N) {
            System.out.println(order);
        } else {
            System.out.println(2*N - (order - 2*N));
        }
    }
}