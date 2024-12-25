import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int angle = 180 * (N-1);
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            angle -= 2 * Integer.parseInt(st.nextToken());
        }
        System.out.println(angle);
    }
}