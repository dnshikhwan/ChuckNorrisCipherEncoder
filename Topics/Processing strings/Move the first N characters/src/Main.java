import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // string s and int n
        String s = scanner.next();
        int n = scanner.nextInt();

        moveNChar(s, n);

        scanner.close();
    }

    public static void moveNChar(String word, int n) {
        // if n is greater than s, output the unchanged string
        if (n > word.length()) {
            System.out.println(word);
        } else {
            // moves first n char of s to the end of the string
            // output the changed string

            // example, Hello
            String firstNChar = word.substring(0, n); // Hel
            String remainingChar = word.substring(n, word.length());
            System.out.println(remainingChar + firstNChar);
        }
    }
}