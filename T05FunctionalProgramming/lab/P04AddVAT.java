package T05FunctionalProgramming.lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class P04AddVAT {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Function<String, Double> mapWithVAT = str -> Double.parseDouble(str) * 1.2;
        System.out.println("Prices with VAT:");
        Arrays.stream(scan.nextLine().split(",\\s+")).map(mapWithVAT)
                .forEach(e -> System.out.printf("%.2f\n", e));
    }
}
