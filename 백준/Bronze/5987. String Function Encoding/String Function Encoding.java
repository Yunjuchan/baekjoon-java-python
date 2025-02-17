import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int Z = Integer.parseInt(br.readLine());

        for (int i = 0; i < Z; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            for (int j = 0; j < C; j++) {
                str = str.substring(N) + str;
            }
            System.out.println(str);
        }


    }
}