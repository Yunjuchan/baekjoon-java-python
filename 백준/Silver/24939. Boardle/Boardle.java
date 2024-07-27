import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static long minX, minY, maxX, maxY;
    static void search(int x, int y, int d) {
        if (d == 1) {
            minY = maxY = y;
            minX = Math.max(minX, x+1);
        } else if (d == 2) {
            minY = maxY = y;
            maxX = Math.min(maxX, x-1);
        } else if (d == 3) {
            minX = maxX = x;
            maxY = Math.min(maxY, y-1);
        } else if (d == 4) {
            minX = maxX = x;
            minY = Math.max(minY, y+1);
        } else if (d == 5) {
            minX = Math.max(minX, x+1);
            minY = Math.max(minY, y+1);
        } else if (d == 6) {
            maxX = Math.min(maxX, x-1);
            minY = Math.max(minY, y+1);
        } else if (d == 7) {
            minX = Math.max(minX, x+1);
            maxY = Math.min(maxY, y-1);
        } else if (d == 8) {
            maxX = Math.min(maxX, x-1);
            maxY = Math.min(maxY, y-1);
        } else if (d == 9) {
            minX = maxX = x;
            minY = maxY = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        minX = minY = 1;
        maxX = N; maxY = M;
        st = new StringTokenizer(br.readLine());
        int Q = Integer.parseInt(st.nextToken());

        for (int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            search(x, y, d);
//            System.out.println("minX: " + minX + " maxX: " + maxX + " minY: " + minY + " maxY: " + maxY);
        }
        System.out.println((maxX-minX+1) * (maxY-minY+1));
    }
}