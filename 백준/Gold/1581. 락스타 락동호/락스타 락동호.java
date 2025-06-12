import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int FF = Integer.parseInt(st.nextToken());
        int FS = Integer.parseInt(st.nextToken());
        int SF = Integer.parseInt(st.nextToken());
        int SS = Integer.parseInt(st.nextToken());

        int startF = FF + FS;

        if (startF > 0) {
            if (FS == 0) {
                System.out.println(FF);
            } else if (SF >= FS) {
                int cnt = FS * 2 + SS;
                System.out.println(FF + cnt);
            } else {
                int cnt = SF * 2 + 1 + SS;
                System.out.println(FF + cnt);
            }
        } else {
            System.out.println(SS + (SF > 0 ? 1 : 0));
        }
    }
}
