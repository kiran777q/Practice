package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PageSelection {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> startPages = new ArrayList<>();
        startPages.add(1);
        startPages.add(3);

        int numOptions = 3;
        int nextPageNum = 4;

        List<Integer> endPages = new ArrayList<>();

        while (!startPages.isEmpty()) {
            List<Integer> nextPages = new ArrayList<>();

            for (Integer startPage : startPages) {
                System.out.println("Current page: " + startPage);
                System.out.println("Choose next page:");
                for (int i = 0; i < numOptions; i++) {
                    System.out.println((i + 1) + ". " + (nextPageNum + i * 2));
                }
                System.out.print("Enter the number of your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline not consumed by nextInt()

                if (choice == 1) {
                    nextPages.add(nextPageNum);
                } else if (choice == 2) {
                    nextPages.add(nextPageNum + 2);
                } else if (choice == 3) {
                    nextPages.add(nextPageNum + 4);
                }
            }

            startPages = nextPages;
            nextPageNum += numOptions * 2;
        }

        System.out.println("End pages: " + endPages);
    }
}
