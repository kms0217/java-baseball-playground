import java.util.Scanner;

//연산자 순서 신경쓰지 않고 무조건 앞에서 부터 계산
public class SimpleCalculator {
    public int calc() throws ArithmeticException, NumberFormatException{
        String input = getInput();
        String[] values = input.split(" ");
        int ret = 0;
        String operator = "+";
        if (input == null || input.isEmpty())
            return ret;
        for (String value : values) {
            if (isOperator(value)) {
                operator = value;
                continue;
            }
            if (operator.equals("+"))
                ret += Integer.parseInt(value);
            else if (operator.equals("-"))
                ret -= Integer.parseInt(value);
            else if (operator.equals("*"))
                ret *= Integer.parseInt(value);
            else
                ret /= Integer.parseInt(value);
        }
        return ret;
    }

    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        return value;
    }

    public Boolean isOperator(String value) {
        return value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/");
    }
}
