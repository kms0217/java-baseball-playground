import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {

    private SimpleCalculator simpleCalculator;

    @BeforeEach
    public void init() {
        simpleCalculator = new SimpleCalculator();
    }

    @DisplayName("1. 입력값 제대로 받는지 Test")
    @Test
    void test_1(){
        String input = "2 + 3 * 4 / 2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(simpleCalculator.getInput()).isEqualTo(input);
    }

    @DisplayName("2. 연산자 구분 제대로 하는지 Test")
    @ParameterizedTest
    @CsvSource(value = {"+:True", "-:True", "/:True", "*:True", "1:False", "2:False", "k:False"}, delimiter = ':')
    void test_2(String str, Boolean except){
        assertThat(simpleCalculator.isOperator(str)).isEqualTo(except);
    }

    @DisplayName("3. 계산 제대로 하는지 Test")
    @ParameterizedTest
    @CsvSource(value = { "2 + 3 * 4 / 2:10", "3 * 2 / 1 + 9:15", "3 - 3 - 3:-3"}, delimiter = ':')
    void test_3(String input, Integer except) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThat(simpleCalculator.calc()).isEqualTo(except);
    }

    @DisplayName("4. Exception Test")
    @ParameterizedTest
    @ValueSource(strings = {"1 / 0", "a b c"})
    void test_4(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThatThrownBy(() -> {
            simpleCalculator.calc();
        }).isInstanceOfAny(ArithmeticException.class, NumberFormatException.class);
    }
}