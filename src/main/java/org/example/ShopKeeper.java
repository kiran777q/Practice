package org.example;

import java.util.Arrays;

public class ShopKeeper {

    public static int minMovesToMedian(int[] price, int k) {
        int n = price.length;
        Arrays.sort(price);

        int medianIndex = (n - 1) / 2;

        return Arrays.stream(price)
                .map(value -> Math.abs(value - k))
                .sum();
    }

    public static void main(String[] args) {
        int[] prices = {4, 2, 1, 4, 7};
        int k = 3;

        int result = minMovesToMedian(prices, k);
        System.out.println("Minimum number of moves: " + result);
    }
}
