package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SubStringTest {
    @Test
    public void subStringTest() {
        String str = "(1,2)";
        String result = str.substring(1, str.length() - 1);
        assertThat(result).isEqualTo("1,2");
    }
}
