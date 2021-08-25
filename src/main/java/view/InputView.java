package view;

import java.util.Scanner;
import utils.Valid;

public class InputView {

    private static Scanner sc = new Scanner(System.in);
    private static Valid valid = new Valid();

    public String inputNumber() {
        String number;
        do {
            System.out.println("숫자를 입력하세요");
            number = sc.next();
        } while (!valid.numberValid(number));
        return number;
    }

    public Boolean inputExitStatus() {
        String exitStatus;
        do {
            System.out.println("종료하시겠습니까?(Y/N)");
            exitStatus = sc.next();
        } while (!valid.exitStatusValid(exitStatus));
        return exitStatus.equals("Y") || exitStatus.equals("y");
    }
}
