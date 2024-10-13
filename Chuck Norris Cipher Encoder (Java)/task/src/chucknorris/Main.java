package chucknorris;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/*
1. Add user menu (encode/decode/exit) [X]
2. loop until user type exit [X]
3. if user misspells the operation name, print There is not '<input>' operation [X]
4. if user provide incorrect encoded message, program should print not 'valid' substring []
    a. The encoded message includes characters other than 0 or spaces; []
    b. The first block of each sequence is not 0 or 00 []
    c. The number of blocks is odd []
    d. The length of the decoded binary string is not a multiple of 7
*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String choice = "";
        do {
            System.out.println("Please input operation (encode/decode/exit):");
            choice = scanner.nextLine();

            switch (choice) {
                case "encode":
                    System.out.println("Input string:");
                    if (scanner.hasNextLine()) {
                        String word = scanner.nextLine();
                        System.out.println("Encoded string:");
                        System.out.println(chuckNorrisEncoding(word));
                        System.out.println();
                    }
                    break;
                case "decode":
                    System.out.println("Input encoded string:");
                    if (scanner.hasNextLine()) {
                        String word = scanner.nextLine();
                        if (validateInput(word)) {
                            System.out.println("Decoded string:");
                            decoder(word);
                        } else {
                            System.out.println("Encoded string is not valid");
                        }
                        System.out.println();
                    }
                    break;
                case "exit":
                    System.out.println("Bye!");
                    break;
                default :
                    System.out.println("There is no '" + choice + "' operation\n");
                    break;
            }

        } while(!choice.equals("exit"));

        scanner.close();
    }

    // method to change the input to binary of type string
    public static StringBuilder toBinaryString(String input) {
        // change input to charArray
        char[] ch = input.toCharArray();

        StringBuilder result = new StringBuilder();
        // take each char and change it into int
        for (int i = 0; i < ch.length; i++) {
            int chDecimal = ch[i];
            String binary = String.format("%07d", Integer.parseInt(Integer.toBinaryString(chDecimal)));
            result.append(binary);
        }

        return result;
    }

    // method for chuck norris encoding
    public static StringBuilder chuckNorrisEncoding(String input) {
        StringBuilder binaryOfInput = toBinaryString(input);
        StringBuilder result = new StringBuilder();

        // assign start of the string, if starts equal 0, then previous is 0, vice versa
        String start = "00 0";
        if (binaryOfInput.charAt(0) == '1') {
            start = "0 0";
        }

        // create string that hold the first encrypted message of the starting number
        result.append(start);

        char previousChar = binaryOfInput.charAt(0);

        // loop through the string starting from index 1
        for (int i = 1; i < binaryOfInput.length(); i++) {
            char currentChar = binaryOfInput.charAt(i);

            // current char equals to previous char, append 0
            if (currentChar == previousChar) {
                result.append("0");
            } else {
                result.append(" ");
                result.append(currentChar == '1' ? "0 0" : "00 0");

                previousChar = currentChar;
            }
        }

        // return the result
        return result;
    }

    public static void decoder(String input) {
        // receive string of zeros and spaces
        StringBuilder decimalFromBinary = new StringBuilder();
        String[] binaries = input.split(" ");


            // change the string of zeros back into binary
            for (int i = 0; i < binaries.length; i+=2) {
                if ("0".equals(binaries[i])) {
                    for (int j = 0; j < binaries[i + 1].length(); j++) {
                        decimalFromBinary.append("1");
                    }
                } else if ("00".equals(binaries[i])) {
                    for (int j = 0; j < binaries[i + 1].length(); j++) {
                        decimalFromBinary.append("0");
                    }
                }
            }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < decimalFromBinary.length(); i+=7) {
            // split the result into block of seven symbols, by using substring
            String binarySegment = decimalFromBinary.substring(i, i + 7);
            // convert back into characters
            int decimal = Integer.parseInt(binarySegment,2);
            char letter = (char) decimal;
            result.append(letter);
        }

        System.out.println(result);
    }

    public static boolean validateInput(String input) {
        String[] inputArray = input.split(" ");

        //    a. The encoded message includes characters other than 0 or spaces; [X]
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != '0' && input.charAt(i) != ' ') {
                return false;
            }
        }

        //    b. The first block of each sequence is not 0 or 00 [X]
        for (int i = 0; i < inputArray.length; i+=2) {
            if (!inputArray[i].equals("0") && !inputArray[i].equals("00")) {
                return false;
            }
        }
        //    c. The number of blocks is odd [X]
        if (inputArray.length % 2 != 0) {
            return false;
        }

        //    d. The length of the decoded binary string is not a multiple of 7 []
        StringBuilder decimalFromBinary = new StringBuilder();
        // change the string of zeros back into binary
        for (int i = 0; i < inputArray.length; i+=2) {
            if ("0".equals(inputArray[i])) {
                for (int j = 0; j < inputArray[i + 1].length(); j++) {
                    decimalFromBinary.append("1");
                }
            } else if ("00".equals(inputArray[i])) {
                for (int j = 0; j < inputArray[i + 1].length(); j++) {
                    decimalFromBinary.append("0");
                }
            }
        }

        if (decimalFromBinary.length() % 7 != 0) {
            return false;
        }

        return true;
    }
}