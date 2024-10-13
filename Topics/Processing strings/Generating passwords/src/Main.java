import java.util.*;

/*
* A uppercase, B lowercase, C digits, N symbol/length
*
* Task :
* password cannot contain two or more same characters in a row
* create password that match, A, B, C, N
* A, B, C, N are non-negative numbers [X]
* A + B + C <= N [X]
* any parameter can equal to zero [X]
*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // sample input = 3 2 3 10
        // sample output = ABAab121AB

        int A = scanner.nextInt();
        int B = scanner.nextInt();
        int C = scanner.nextInt();
        int N = scanner.nextInt();

        // handling errors
        if (A < 0 || B < 0 || C < 0 || N < 0) {
            System.out.println("Input can't be a negative value!");
        } else if (A + B + C > N) {
            System.out.println("Wrong input!");
        }

        // create the array for password
        char[] password = new char[N];

        // create password that match the requirements
        // uppercase
        for (int i = 0; i < A; i++) {
            password[i] = i % 2 == 0 ? 'A' : 'B';
        }
        // lowercase
        for (int i = A; i < A + B; i++) {
            password[i] = i % 2 == 0 ? 'b' : 'a';
        }
        // digits
        for (int i = A + B; i < A + B + C; i++) {
            password[i] = i % 2 == 0 ? '2' : '1';
        }
        for (int i = A + B + C; i < N; i++) {
            password[i] = i % 2 == 0 ? 'A' : 'B';
        }


        // change the password array into string
        String finishedPassword = new String(password);
        System.out.println(finishedPassword);

        scanner.close();
    }
}