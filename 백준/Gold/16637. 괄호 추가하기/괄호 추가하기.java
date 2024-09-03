import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N;
    public static int[] numbers;
    public static char[] operators;
    public static int maxResult = Integer.MIN_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        String expression = br.readLine();
        numbers = new int[N/2+1];
        operators = new char[N/2];

        for (int i=0; i<N; i++) {
            if (i % 2 == 0) {
                numbers[i / 2] = Integer.parseInt(Character.toString(expression.charAt(i)));
            } else {
                operators[i / 2] = expression.charAt(i);
            }
        }

        dfs(numbers[0], 0);

        System.out.println(maxResult);
    }

    public static void dfs(int currentResult, int index) {

        if (index == operators.length) {
            maxResult = Math.max(maxResult, currentResult);
            return;
        }

        int nextResult = calculate(currentResult, numbers[index + 1], operators[index]);
        dfs(nextResult, index + 1);

        if (index + 1 < operators.length) {
            int bracketResult = calculate(numbers[index + 1], numbers[index + 2], operators[index + 1]);
            int nextBracketResult = calculate(currentResult, bracketResult, operators[index]);
            dfs(nextBracketResult, index + 2);
        }
    }


    public static int calculate(int a, int b, char operator) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            default:
                return 0;
        }
    }
}