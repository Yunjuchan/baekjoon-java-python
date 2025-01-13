import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        List<int[]> arr = new ArrayList<>();

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int[] x = new int[2];
            x[0] = Integer.parseInt(st.nextToken());
            x[1] = Integer.parseInt(st.nextToken());
            arr.add(x);
        }

        arr.sort((a, b) -> a[0] - b[0]);
        long result = arr.get(0)[1];
        long tmp = result;
        int i=0;
        int j=0;
        while (true) {
            if (j == N-1) {
                if (arr.get(j)[0] - arr.get(i)[0] >= D) {
                    tmp -= arr.get(i)[1];
                    i++;
                } else {
                    result = Math.max(result, tmp);
                    break;
                }
            } else {
                if (arr.get(j)[0] - arr.get(i)[0] >= D) {
                    tmp -= arr.get(i)[1];
                    i++;
                } else {
                    result = Math.max(result, tmp);
                    j++;
                    tmp += arr.get(j)[1];
                }
            }
        }
        System.out.println(result);
    }
}