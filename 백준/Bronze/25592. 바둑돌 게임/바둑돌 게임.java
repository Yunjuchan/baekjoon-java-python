import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int order = 1;
        while (N - order >= 0) {
            N -= order;
            order++;
        }
        
        if (order % 2 == 1) {
            System.out.println(order - N);
        } else {
            System.out.println(0);
        }
    }
}