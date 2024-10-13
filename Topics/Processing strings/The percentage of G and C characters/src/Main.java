import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine().toLowerCase();

        int gcContent = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'g' || word.charAt(i) == 'c') {
                gcContent++;
            }
        }

        int len = word.length();

        if (len > 0) {
            double result = (double) gcContent / len;
            System.out.println(result * 100);

        }
        scanner.close();
    }
}