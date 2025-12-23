package org.example.day_03;

import org.example.shared.DataSet;

public class JoltageFinder {
    public static int solve(DataSet lines) {
        return lines.getLines().stream()
                .mapToInt(JoltageFinder::highestJoltage)
                .sum();
    }

    private static int highestJoltage(String bank) {
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
