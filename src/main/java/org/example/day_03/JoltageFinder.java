package org.example.day_03;

import org.example.shared.DataSet;

public class JoltageFinder {
    public static long solve(DataSet lines, int outputSize) {
        return lines.getLines().stream()
                .mapToLong(bank -> highestJoltage(bank, outputSize))
                .sum();
    }

    public static long highestJoltage(String bank, int outputSize) {
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
}
