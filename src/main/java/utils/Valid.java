package utils;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Valid {

    public Boolean numberValid(String input) {
        String pattern = "^[1-9]{3}";
        Set<Character> set = new HashSet<Character>();
        if (input == null || input.isEmpty()) {
            System.out.println("잘못된 입력입니다.");
            return false;
        }
        for (char ch : input.toCharArray()) {
            set.add(ch);
        }
        if (!Pattern.matches(pattern, input) || set.size() != 3) {
            System.out.println("잘못된 입력입니다.");
            return false;
        }
        return true;
    }

    public Boolean exitStatusValid(String input) {
        if ("N".equals(input) || "Y".equals(input) || "y".equals(input) || "n".equals(input)) {
            return true;
        }
        System.out.println("잘못된 입력입니다.");
        return false;
    }
}
