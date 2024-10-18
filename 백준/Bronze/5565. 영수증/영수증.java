import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int price = Integer.parseInt(st.nextToken());

        for (int i=0; i<9; i++) {
            st = new StringTokenizer(br.readLine());
            price -= Integer.parseInt(st.nextToken());
        }
        System.out.println(price);
    }
}