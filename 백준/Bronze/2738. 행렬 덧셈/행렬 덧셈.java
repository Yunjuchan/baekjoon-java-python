import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line = br.readLine();
        StringTokenizer st = new StringTokenizer(line);
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] arr = new int[r][c];
        for (int i=0; i< 2*r; i++) {
            StringTokenizer row = new StringTokenizer(br.readLine());
            for (int j=0;j<c; j++) {
                arr[i%r][j] += Integer.parseInt(row.nextToken());
            }
        }
        for (int i=0; i<r; i++) {
            for (int j=0; j<c; j++) {
                bw.write(arr[i][j]+" ");
            }
            bw.newLine();
        }
        bw.close();
    }
}