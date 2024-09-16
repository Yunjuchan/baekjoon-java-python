import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] data = new int[3][N];
        for (int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        List<Integer> original = new ArrayList<>();
        boolean flag = false;
        for (int i=N-1; i>=0; i--) {
            if (data[0][i] != data[1][i] && data[1][i] == data[2][i]) {
                flag = true;
                for (int j=0; j<N; j++) {
                    if (data[0][j] == data[1][i]) {
                        continue;
                    }
                    original.add(data[0][j]);
                    if (original.size() == i) {
                        original.add(data[1][i]);
                    }
                }
            } else if (data[1][i] != data[2][i] && data[2][i] == data[0][i]) {
                flag = true;
                for (int j=0; j<N; j++) {
                    if (data[1][j] == data[2][i]) {
                        continue;
                    }
                    original.add(data[1][j]);
                    if (original.size() == i) {
                        original.add(data[2][i]);
                    }
                }
            } else if (data[2][i] != data[0][i] && data[0][i] == data[1][i]) {
                flag = true;
                for (int j=0; j<N; j++) {
                    if (data[2][j] == data[0][i]) {
                        continue;
                    }
                    original.add(data[2][j]);
                    if (original.size() == i) {
                        original.add(data[0][i]);
                    }
                }
            }
            if (flag) {
                break;
            }

        }
        for (int x : original) {
            System.out.print(x + " ");
        }
    }
}