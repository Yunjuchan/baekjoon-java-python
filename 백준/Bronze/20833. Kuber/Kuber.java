import java.io.*;
    import java.util.*;

    public class Main {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            int N = Integer.parseInt(br.readLine());
            int result = 0;
            for (int i=1; i<=N; i++) {
                result += (int) Math.pow(i, 3);
            }
            System.out.println(result);
        }
    }