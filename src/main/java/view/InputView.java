package view;

import java.util.Scanner;

public class InputView {

    private static final Scanner sc = new Scanner(System.in);

    public String inputNumber() {
        return sc.next();
    }

    public String inputExitStatus() {
        return sc.next();
    }
}
