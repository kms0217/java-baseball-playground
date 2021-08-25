package utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ValidTest {

    private Valid valid;

    @BeforeEach
    void init() {
        valid = new Valid();
    }

    @DisplayName("1. 정상적인 입력 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"123", "429", "981"})
    void test_1(String input) {
        assertThat(valid.numberValid(input)).isTrue();
    }

    @DisplayName("2. 잘못 된 입력 테스트(중복, 3개 미만 혹은 4개 이상, 숫자 아닌 입력, 0입력)")
    @ParameterizedTest
    @ValueSource(strings = {"112", "4912", "012", "3a1", "1 4"})
    void test_2(String input) {
        assertThat(valid.numberValid(input)).isFalse();
    }

    @DisplayName("3. 정상적인 Y, N 입력")
    @ParameterizedTest
    @ValueSource(strings = {"Y", "N", "y", "n"})
    void test_3(String input) {
        assertThat(valid.exitStatusValid(input)).isTrue();
    }

    @DisplayName("4. 잘못 된 Y, N 입력")
    @ParameterizedTest
    @ValueSource(strings = {"YY", "Ny", "1", "T"})
    void test_4(String input) {
        assertThat(valid.exitStatusValid(input)).isFalse();
    }
}
