import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        char[][] A = new char[N][N];
        int heartY = 0;
        int heartX = 0;
        for (int i=0; i<N; i++) {
            A[i] = br.readLine().toCharArray();
        }
        int[] directY = {1,0,-1,0};
        int[] directX = {0,-1,0,1};

        for (int i=1; i<N-1; i++) {
            for (int j=1; j<N-1; j++) {
                if (A[i][j] == '_') {
                    continue;
                }
                int cnt = 0;
                for (int k=0; k<4; k++) {
                    int dy = directY[k] + i;
                    int dx = directX[k] + j;
                    if (A[dy][dx] == '*') {
                        cnt++;
                    }
                }
                if (cnt == 4) {
                    heartY = i;
                    heartX = j;
                    break;
                }
            }
        }
        int[] result = {0,0,0,0,0};

        int y = heartY;
        int x = heartX-1;
        while (x >= 0 && A[y][x] == '*') {
            x -= 1;
            result[0]++;
        }

        y = heartY;
        x = heartX+1;
        while (x < N && A[y][x] == '*') {
            x += 1;
            result[1]++;
        }
        y = heartY+1;
        x = heartX;

        int waistY = 0;
        int waistX = 0;
        while (y < N && A[y][x] == '*') {
            y += 1;
            result[2]++;
            waistY = y;
            waistX = x;
        }

        y = waistY;
        x = waistX-1;
        while (y < N && A[y][x] == '*') {
            y += 1;
            result[3]++;
        }

        y = waistY;
        x = waistX+1;
        while (y < N && A[y][x] == '*') {
            y += 1;
            result[4]++;
        }

        System.out.println((heartY+1) + " " + (heartX+1));
        for (int n : result) {
            System.out.print(n + " ");
        }
    }
}