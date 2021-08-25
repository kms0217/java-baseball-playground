package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CharAtTest {
    @Test
    public void BasicTest() {
        String str = "abc";
        assertThat(str.charAt(0)).isEqualTo('a');
        assertThat(str.charAt(1)).isEqualTo('b');
        assertThat(str.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("Index 예외 테스트")
    public void ExceptionTest() {
        String str = "abc";
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    str.charAt(5);
                }).withMessageMatching("String index out of range: \\d+");
    }
}
