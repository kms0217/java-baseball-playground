package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("1. Set Size Test")
    @Test
    void test_1(){
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("2. Set 원소 확인 Not ParameterizedTest")
    @Test
    void test_2(){
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(3)).isTrue();
    }

    @DisplayName("3. Set 원소 확인 ParameterizedTest")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    void test_3(int number){
        assertThat(numbers).contains(number);
    }

    @DisplayName("4. 존재해서는 안되는 원소도 확인")
    @ParameterizedTest
    @CsvSource(value = {"1:True", "2:True", "3:True", "4:False", "5:False"}, delimiter = ':')
    void test_4(Integer input, Boolean expected){
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
