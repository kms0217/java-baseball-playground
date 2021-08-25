package game;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameTest {

    private final String generatedNum = "397";
    private Game game;

    @BeforeEach
    void init() {
        game = Game.getInstance();
    }

    @DisplayName("1. Ball 개수 세기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"739:3", "193:1", "124:0", "793:2"}, delimiter = ':')
    void test_1(String input, int expect) {
        assertThat(game.countBall(generatedNum, input)).isEqualTo(expect);
    }

    @DisplayName("2. Strike 개수 세기 테스트")
    @ParameterizedTest
    @CsvSource(value = {"739:0", "193:1", "124:0", "793:1", "397:3", "367:2"}, delimiter = ':')
    void test_2(String input, int expect) {
        assertThat(game.countStrike(generatedNum, input)).isEqualTo(expect);
    }
}