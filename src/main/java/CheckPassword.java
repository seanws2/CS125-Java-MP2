import java.util.Scanner;

/**
 * A class that validates a password based on rules.
 * <p>
 * The provided code is incomplete. Modify it so that it works properly and passes the tests in
 * <code>CheckPasswordTest.java</code>.
 *
 * @see <a href="https://cs125.cs.illinois.edu/MP/2/">MP2 Documentation</a>
 */
public class CheckPassword {

    /** Password letters. */
    private static final String CAPITAL_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    /** Password numbers. */
    private static final String NUMBERS = "0123456789";

    /** Password special characters. */
    private static final String SPECIAL = "!@#$%^_*";

    /**
     * Given a potential password check it against provided rules.
     * <p>
     * The function is passed a length and capital letter, number, and special character counts.
     * It should return true if the password is the appropriate length and has the required number of capital letters,
     * numbers, and special characters, and false otherwise. !,@,#,$,%,^,_,
     * and * count as special characters.
     * <p>
     * The counts may be zero, in which case there are no requirements for that rule. For example, if
     * numberCount == 0 then the password does not have to contain a number. Of course, it still can.
     * <p>
     * The passed password string may be empty but will not be null.
     *
     * @param password string to check
     * @param minLength minimum number of characters
     * @param minCapitalLetter minimum number of uppercase letters
     * @param minNumber minimum number of numbers
     * @param minSpecial minimum number of special characters
     * @return true if the password follows the rules, false otherwise
     */
    public static boolean checkAPassword(final String password, final int minLength, final int minCapitalLetter,
                                         final int minNumber, final int minSpecial) {
        boolean out = true;
        int length = password.length();
        int upper = 0;
        int num = 0;
        int special = 0;
        for (int i = 0; i < password.length(); i++) {
            if (SPECIAL.contains(Character.toString(password.charAt(i)))) {
                special++;
            }
            if (NUMBERS.contains(Character.toString(password.charAt(i)))) {
                num++;
            }
            if (CAPITAL_LETTERS.contains(Character.toString(password.charAt(i)))) {
                upper++;
            }
        }
        if (length < minLength || special < minSpecial || num < minNumber || upper < minCapitalLetter) {
            out = false;
        }
        return out;

    }

    /* ********************************************************************************************
     * You do not need to modify code below this comment.
     * ********************************************************************************************/

    /**
     * Solicits a password from the user and checks it using static rules.
     * <p>
     * You are free to review this function, but should not modify it. Note that this function is
     * not tested by the test suite, as it is purely to aid your own interactive testing.
     *
     * @param unused unused input arguments
     */
    public static void main(final String[] unused) {
        Scanner lineScanner = new Scanner(System.in);
        System.out.println("The rules are the password must be 10 characters "
                        + "and contain two digits and one special character");
        System.out.println("Enter a password to check: ");
        String password = lineScanner.nextLine();
        final int minLength = 10;
        if (checkAPassword(password, minLength, 0, 2, 1)) {
            System.out.println("The password is valid");
        } else {
            System.out.println("The password is invalid");
        }
    }
}
