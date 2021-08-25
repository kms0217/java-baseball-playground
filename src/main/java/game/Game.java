package game;

import utils.NumGenerator;
import view.InputView;
import view.ResultView;

public class Game {

    private static Game game = null;
    private static InputView inputView;
    private static ResultView resultView;
    private static NumGenerator generator;
    private String generatedNum;

    private Game() {
    }

    private static void init() {
        game = new Game();
        inputView = new InputView();
        resultView = new ResultView();
        generator = new NumGenerator();
    }

    public static Game getInstance() {
        if (game == null) {
            init();
        }
        return game;
    }

    public void start() {
        int strikeNum;
        int ballNum;
        Boolean end;
        String input;
        generatedNum = generator.generate();
        do {
            input = inputView.inputNumber();
            strikeNum = countStrike(generatedNum, input);
            ballNum = countBall(generatedNum, input);
            resultView.resultPrint(strikeNum, ballNum);
            end = checkEnd(strikeNum);
        } while (!end);
    }

    public int countBall(String com, String user) {
        int ret = 0;
        if (com.charAt(0) == user.charAt(1) || com.charAt(0) == user.charAt(2)) {
            ret++;
        }
        if (com.charAt(1) == user.charAt(0) || com.charAt(1) == user.charAt(2)) {
            ret++;
        }
        if (com.charAt(2) == user.charAt(0) || com.charAt(2) == user.charAt(1)) {
            ret++;
        }
        return ret;
    }

    public int countStrike(String com, String user) {
        int ret = 0;
        if (com.charAt(0) == user.charAt(0)) {
            ret++;
        }
        if (com.charAt(1) == user.charAt(1)) {
            ret++;
        }
        if (com.charAt(2) == user.charAt(2)) {
            ret++;
        }
        return ret;
    }

    public Boolean checkEnd(int strikeNum) {
        if (strikeNum == 3) {
            generatedNum = generator.generate();
            return inputView.inputExitStatus();
        }
        return false;
    }
}
