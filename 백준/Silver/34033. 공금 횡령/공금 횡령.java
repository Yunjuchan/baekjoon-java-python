import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Double> list = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String item = st.nextToken();
            double price = Integer.parseInt(st.nextToken());
            list.put(item, price);
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            String item = st.nextToken();
            double purchase = Integer.parseInt(st.nextToken());
            double price = list.get(item);
            if (purchase > price * 1.05) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}