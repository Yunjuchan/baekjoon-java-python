import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        List<Integer> three = new ArrayList<>();
        List<Integer> five = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            if (t == 3) {
                three.add(s);
            } else {
                five.add(s);
            }
        }

        three.sort(Collections.reverseOrder());
        five.sort(Collections.reverseOrder());

        long[] prefixThree = new long[three.size() + 1];
        long[] prefixFive = new long[five.size() + 1];
        for (int i = 0; i < three.size(); i++) {
            prefixThree[i + 1] = prefixThree[i] + three.get(i);
        }
        for (int i = 0; i < five.size(); i++) {
            prefixFive[i + 1] = prefixFive[i] + five.get(i);
        }

        long maxSweet = 0;
        for (int i = 0; i <= three.size(); i++) {
            int weight = 3 * i;
            if (weight > w) {
                break;
            }
            int remainingWeight = w - weight;
            int j = Math.min(remainingWeight / 5, five.size());
            long totalSweet = prefixThree[i] + prefixFive[j];
            maxSweet = Math.max(maxSweet, totalSweet);
        }
        System.out.println(maxSweet);
    }
}