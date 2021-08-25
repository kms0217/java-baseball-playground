package view;

public class ResultView {

    private static final String NOTHING = "낫싱";
    private static final String CORRECT = "정답입니다.";

    public void resultPrint(int strikeNum, int ballNum) {
        if (strikeNum == 3) {
            System.out.println(CORRECT);
            return;
        }
        if (strikeNum == 0 && ballNum == 0) {
            System.out.println(NOTHING);
            return;
        }
        System.out.println(strikeNum + " 스트라이크, " + ballNum + " 볼");
    }
}
