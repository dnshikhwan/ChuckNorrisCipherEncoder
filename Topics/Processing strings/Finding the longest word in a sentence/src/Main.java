import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        findFirstLongestString(sentence);
    }

    public static void findFirstLongestString(String input) {
        String[] word = input.split(" ");

        int index = 0;
        int longest = word[0].length();

        // need to output the first longest word in the sentence

        // loop through the word array to find the longest word
        for (int i = 1; i < word.length; i++) {
            // if the word is the longest, get the index
            if (word[i].length() > longest) {
                longest = word[i].length(); // update the longest to current longest word
                index = i;
            }
        }

        System.out.println(word[index]);

        // print the word with the longest index
    }
}