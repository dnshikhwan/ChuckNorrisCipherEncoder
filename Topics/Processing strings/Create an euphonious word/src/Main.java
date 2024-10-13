import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // input word
        String word = scanner.nextLine();

        // vowels = a, e, i, o, u, y
        String vowels = "aeiouy";
        String consonants = "bcdfghjklmnpqrstvwxz";
        // consonant = other than vowels

        // loop through the word
        // calculate how many vowels and consonant

        // check if vowels have 3 or more in a row
        int addLetter = 0;
        int vowelCount = 0;
        int consonantCount = 0;

        // check how many vowels
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);

            if (vowels.indexOf(currentChar) != -1) {
                // If it's a vowel, increment the vowel count and reset consonant count
                vowelCount++;
                consonantCount = 0;

                // Check if we have 3 consecutive vowels
                if (vowelCount == 3) {
                    addLetter++;  // We need to insert a consonant here
                    vowelCount = 1;  // Reset count after inserting a consonant
                }
            } else {
                // If it's a consonant, increment the consonant count and reset vowel count
                consonantCount++;
                vowelCount = 0;

                // Check if we have 3 consecutive consonants
                if (consonantCount == 3) {
                    addLetter++;  // We need to insert a vowel here
                    consonantCount = 1;  // Reset count after inserting a vowel
                }
            }
        }

        System.out.println(addLetter);

        scanner.close();
    }
}