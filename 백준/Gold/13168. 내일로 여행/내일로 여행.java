import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Integer> cities = new HashMap<>();
        Map<String, Integer> vehicles = new HashMap<>();
        vehicles.put("Subway", 0);
        vehicles.put("Bus", 1);
        vehicles.put("Taxi", 2);
        vehicles.put("Airplane", 3);
        vehicles.put("KTX", 4);
        vehicles.put("S-Train", 5);
        vehicles.put("V-Train", 6);
        vehicles.put("ITX-Saemaeul", 7);
        vehicles.put("ITX-Cheongchun", 8);
        vehicles.put("Mugunghwa", 9);

        int N = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cities.put(st.nextToken(), i);
        }

        int M = Integer.parseInt(br.readLine());
        int[] route = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            route[i] = cities.get(st.nextToken());
        }

        double[][] buyNaeillo = new double[N][N];
        double[][] notBuyNaeillo = new double[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(buyNaeillo[i], 20_000_000);
            Arrays.fill(notBuyNaeillo[i], 20_000_000);
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int v = vehicles.get(st.nextToken());
            int s = cities.get(st.nextToken());
            int e = cities.get(st.nextToken());
            double c = Integer.parseInt(st.nextToken());
            notBuyNaeillo[s][e] = Math.min(notBuyNaeillo[s][e], c);
            notBuyNaeillo[e][s] = Math.min(notBuyNaeillo[s][e], c);
            if (v == 5 || v == 6) {
                buyNaeillo[s][e] = Math.min(buyNaeillo[s][e], c / 2);
                buyNaeillo[e][s] = Math.min(buyNaeillo[e][s], c / 2);
            } else if (v >= 7) {
                buyNaeillo[s][e] = 0;
                buyNaeillo[e][s] = 0;
            } else {
                buyNaeillo[s][e] = Math.min(buyNaeillo[s][e], c);
                buyNaeillo[e][s] = Math.min(buyNaeillo[e][s], c);
            }

        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                if (i == k) {
                    continue;
                }
                for (int j = 0; j < N; j++) {
                    if (j == i || j == k) {
                        continue;
                    }
                    notBuyNaeillo[i][j] = Math.min(notBuyNaeillo[i][j], notBuyNaeillo[i][k] + notBuyNaeillo[k][j]);
                    buyNaeillo[i][j] = Math.min(buyNaeillo[i][j], buyNaeillo[i][k] + buyNaeillo[k][j]);
                }
            }
        }

        double buyTicket = R;
        double notBuyTicket = 0;
        for (int i = 0; i < M - 1; i++) {
            buyTicket += buyNaeillo[route[i]][route[i + 1]];
            notBuyTicket += notBuyNaeillo[route[i]][route[i + 1]];
        }

        if (buyTicket < notBuyTicket) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}