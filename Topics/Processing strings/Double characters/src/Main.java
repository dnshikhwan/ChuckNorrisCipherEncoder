import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();
        // example input, The

        char[] chars = word.toCharArray();

        for (int i = 0; i < word.length(); i++) {
            System.out.print(chars[i] + "" + chars[i]);
        }

        scanner.close();
    }
}