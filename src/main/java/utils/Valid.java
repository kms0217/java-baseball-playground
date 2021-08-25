package utils;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Valid {

    public Boolean numberValid(String input) {
        String pattern = "^[1-9]{3}";
        Set<Character> set = new HashSet<Character>();
        if (input == null || input.isEmpty() || !Pattern.matches(pattern, input)) {
            return false;
        }
        for (char ch : input.toCharArray()) {
            set.add(ch);
        }
        return set.size() == 3;
    }

    public Boolean exitStatusValid(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        input = input.toUpperCase();
        return "Y".equals(input) || "N".equals(input);
    }
}
