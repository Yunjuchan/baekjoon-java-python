import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<String, Double> grade = new HashMap<>();
        grade.put("A+", 4.5);
        grade.put("A0", 4.0);
        grade.put("B+", 3.5);
        grade.put("B0", 3.0);
        grade.put("C+", 2.5);
        grade.put("C0", 2.0);
        grade.put("D+", 1.5);
        grade.put("D0", 1.0);
        grade.put("F", 0.0);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner scanner = new Scanner(System.in);
        double subjectN = 0;
        double totalGrade = 0;
        while (true) {
            String line = br.readLine();
            if (line == null || line.isEmpty()) break; // 빈 문자열이거나 null이 들어오면 종료
            String[] input = line.split(" ");
            if (input[input.length-1].equals("P")) {
                continue;
            }
            subjectN += Double.parseDouble(input[input.length-2]);
            totalGrade += Double.parseDouble(input[input.length-2]) * grade.get(input[input.length-1]);
        }
        bw.write(String.format("%.6f", totalGrade / subjectN));
        bw.close();
    }
}