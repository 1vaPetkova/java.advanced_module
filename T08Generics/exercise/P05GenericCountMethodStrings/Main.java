package T08Generics.exercise.P05GenericCountMethodStrings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        Box<String> box = new Box<>();

        while (n-- > 0) {
            box.add(scan.nextLine());
        }
        String element = scan.nextLine();
        System.out.println(box.countGreaterElements(element));
    }
}
