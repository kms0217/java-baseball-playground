package utils;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class NumGenerator {

    public String generate() {
        Random random = new Random();
        Set<Integer> set = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();

        while (set.size() < 3) {
            set.add(random.nextInt(9) + 1);
        }
        set.stream().forEach(c -> sb.append(c.toString()));
        return sb.toString();
    }
}
