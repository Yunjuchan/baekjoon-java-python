import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double D = Double.parseDouble(st.nextToken());
        double H = Double.parseDouble(st.nextToken());
        double W = Double.parseDouble(st.nextToken());
        double l = Math.sqrt(H * H + W * W);
        int y = (int) (D * H / l);
        int x = (int) (D *W / l);
        System.out.println(y + " " + x);
    }
}