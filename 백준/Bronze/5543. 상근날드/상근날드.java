import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int burger = Integer.MAX_VALUE;
        for (int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            burger = Math.min(burger, Integer.parseInt(st.nextToken()));
        }
        int drink = Integer.MAX_VALUE;
        for (int i=0; i<2; i++) {
            st = new StringTokenizer(br.readLine());
            drink = Math.min(drink, Integer.parseInt(st.nextToken()));
        }
        System.out.println((burger + drink - 50));
    }
}