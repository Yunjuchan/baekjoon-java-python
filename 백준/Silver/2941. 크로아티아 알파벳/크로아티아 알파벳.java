import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String word = br.readLine();
        word = word.replace("c=", "*");
        word = word.replace("c-", "*");
        word = word.replace("dz=", "*");
        word = word.replace("d-", "*");
        word = word.replace("lj", "*");
        word = word.replace("nj", "*");
        word = word.replace("s=", "*");
        word = word.replace("z=", "*");
        bw.write(String.valueOf(word.length()));
        bw.close();
    }
}