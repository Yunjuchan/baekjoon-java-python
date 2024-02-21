import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[][] arr = new int[9][9];
        for (int i=0; i<9; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(str.nextToken());
            }
        }
        int max = 0;
        int r = 0;
        int c = 0;
        for (int i=0; i<9; i++) {
            for (int j = 0; j < 9; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                    r = i;
                    c = j;
                }
            }
        }
        bw.write(String.valueOf(max)+"\n");
        bw.write(String.valueOf(r+1)+ " " + String.valueOf(c+1));
        bw.close();
    }
}