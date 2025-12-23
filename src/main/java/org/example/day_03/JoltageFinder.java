package org.example.day_03;

import org.example.shared.DataSet;

public class JoltageFinder {
    public static long solve12Digits(DataSet lines) {
        return lines.getLines().stream()
                .mapToLong(JoltageFinder::highestJoltage12)
                .sum();
    }

    public static long solve(DataSet lines) {
        return lines.getLines().stream()
                .mapToLong(JoltageFinder::highestJoltage)
                .sum();
    }

    public static long highestJoltage12(String bank) {
        int outputSize = 12;
        int toRemove = bank.length() - outputSize; // how many digits we have to remove

        var stack = new java.util.ArrayDeque<Character>();

        for (char digit : bank.toCharArray()) {
            while (!stack.isEmpty()
                    && toRemove > 0
                    && stack.peekLast() < digit) {
                stack.pollLast();
                toRemove--;
            }
            stack.addLast(digit);
        }

        // if we need to remove something what's left - from the end
        while (toRemove-- > 0) {
            stack.pollLast();
        }

        long result = 0;
        for (char stackDigit : stack) {
            result = result * 10 + (stackDigit - '0'); // build the result
        }
        return result;
    }

    public static int highestJoltage(String bank) {
        int best = 0;
        for(int i = 0; i < bank.length() - 1; i++) {
            int firstDigit = Character.getNumericValue(bank.charAt(i));

            for(int j = i + 1; j < bank.length(); j++) {
                int secondDigit = Character.getNumericValue(bank.charAt(j));
                best = Math.max(best, firstDigit * 10 + secondDigit);
            }
        }
        return best;
    }
}
