import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int y = 0;
        int x = 0;
        int[] Y = new int[6];
        int[] X = new int[6];
        int maxY = Integer.MIN_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int minX = Integer.MAX_VALUE;
        int diffY = 0;
        int diffX = 0;
        int[] cnt = new int[5];
        boolean[] visited = new boolean[4];

        for (int i=0; i<6; i++) {
            st = new StringTokenizer(br.readLine());
            int tp = Integer.parseInt(st.nextToken());
            cnt[tp]++;
            int l = Integer.parseInt(st.nextToken());
            if (tp == 1) {
                x -= l;
            } else if (tp == 2) {
                x += l;
            } else if (tp == 3){
                y -= l;
            } else {
                y += l;
            }
            Y[i] = y;
            X[i] = x;
            minY = Math.min(minY, y);
            minX = Math.min(minX, x);
            maxY = Math.max(maxY, y);
            maxX = Math.max(maxX, x);
        }
        for (int i=0; i<6; i++) {
            if (minY == Y[i] && minX == X[i]) {
                visited[0] = true;
            } else if (minY == Y[i] && maxX == X[i]) {
                visited[1] = true;
            } else if (maxY == Y[i] && minX == X[i]) {
                visited[2] = true;
            } else if (maxY == Y[i] && maxX == X[i]) {
                visited[3] = true;
            }
        }

        Arrays.sort(Y);
        Arrays.sort(X);
        if (!visited[0]) {
            diffY = Y[2] - Y[0];
            diffX = X[2] - X[0];
        } else if (!visited[1]) {
            diffY = X[4] - X[2];
            diffX = Y[2] - Y[0];
        } else if (!visited[2]) {
            diffY = Y[4] - Y[2];
            diffX = X[2] - X[0];
        } else {
            diffY = Y[4] - Y[2];
            diffX = X[4] - X[2];
        }

        int w = (Y[4] - Y[0]) * (X[4] - X[0]) - diffY * diffX;
        int result = K * w;
        System.out.println(result);
    }
}