import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int result = 0;
        result += (Integer.parseInt(st.nextToken())-2) * 180;

        for (int i=1; i<N; i++) {
            int A = Integer.parseInt(st.nextToken());
            result += A * 180;
        }
        System.out.println(result);
    }
}