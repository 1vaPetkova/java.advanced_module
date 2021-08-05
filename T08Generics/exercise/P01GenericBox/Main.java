package T08Generics.exercise.P01GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Box<String> box = new Box<>();

        while (n-- > 0) {
            box.add(scan.nextLine());
        }
        System.out.println(box);
    }
}
