package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * The Main class implements an application that reads lines from the standard input
 * and prints them to the standard output.
 */
public class testeri {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        boolean isValid = true;
        Map<Integer, Integer> totalFiresByYear = new HashMap<>();
        Set<String> stateMonthPairs = new HashSet<>();

        // Read the first dataset
        while ((line = in.readLine()) != null && !line.trim().isEmpty()) {
            String[] parts = line.split(",");
            if (parts.length != 4 || !isNumeric(parts[0]) || !isNumeric(parts[3])) {
                isValid = false;
                break;
            }

            int year = Integer.parseInt(parts[0]);
            String state = parts[1];
            String month = parts[2];
            int number = Integer.parseInt(parts[3]);

            if (totalFiresByYear.containsKey(year)) {
                totalFiresByYear.put(year, totalFiresByYear.get(year) + number);
            } else {
                totalFiresByYear.put(year, number);
            }

            String stateMonthPair = state + "," + month;
            if (!stateMonthPairs.contains(stateMonthPair)) {
                stateMonthPairs.add(stateMonthPair);
            } else {
                isValid = false;
                break;
            }
        }

        if (isValid) {
            // Read the second dataset
            while ((line = in.readLine()) != null) {
                String[] summaryParts = line.split(",");
                if (summaryParts.length != 2 || !isNumeric(summaryParts[0]) || !isNumeric(summaryParts[1])) {
                    isValid = false;
                    break;
                }

                int year = Integer.parseInt(summaryParts[0]);
                int totalFires = Integer.parseInt(summaryParts[1]);

                if (totalFiresByYear.containsKey(year) && totalFiresByYear.get(year) != totalFires) {
                    isValid = false;
                    break;
                }
            }
        }

        System.out.println(isValid);
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
