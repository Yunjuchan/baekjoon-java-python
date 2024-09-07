import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[] stairs = new int[10];
        for (int i=1; i<10; i++) {
            stairs[i] = 1;
        }

        for (int i=1; i<N; i++) {
            int[] tmp = new int[10];
            for (int j=0; j<10; j++) {
                if (j-1 >= 0) {
                    tmp[j-1] += stairs[j];
                    tmp[j-1] %= 1000000000;
                }
                if (j+1 < 10) {
                    tmp[j+1] += stairs[j];
                    tmp[j+1] %= 1000000000;
                }
            }
            stairs = tmp.clone();
        }
        int result = 0;
        for (int n : stairs) {
            result += n;
            result %= 1000000000;
        }
        System.out.println(result);

    }
}