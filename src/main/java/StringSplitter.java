import java.util.Scanner;
import java.util.Arrays;
/**
 * A class that splits a string on character change boundaries.
 * <p>
 * The provided code is incomplete. Modify it so that it works properly and passes the tests in
 * <code>StringSplitterTest.java</code>.
 * @see <a href="https://cs125.cs.illinois.edu/MP/2/">MP2 Documentation</a>
 */
public class StringSplitter {
    /**
     * function that splits the string.
     * @param split string input
     * @return out split string
     */
    public static String[] stringSplitter(final String split) {
        if (split == null) {
            return null;
        }
        int count = 1;
        int i = 1;
        while (i < split.length()) {
            int j = i - 1;
            if (split.charAt(i) != split.charAt(j)) {
                count++;
            }
            i++;
        }
        int spot = 0;
        String[] out = new String[0];
        if (split.length() == 0) {
            return out;
        }
        out = new String[count];
        out[spot] = Character.toString(split.charAt(0));
        i = 1;
        boolean firstTimeCheck = true;
        while (i < split.length()) {
            int j = i - 1;
            if (split.charAt(i) == split.charAt(j)) {
                out[spot] = out[spot] + Character.toString(split.charAt(i));
            } else {
                spot++;
                if (firstTimeCheck) {
                    out[spot] = Character.toString(split.charAt(i));
                } else {
                    out[spot] = out[spot] + Character.toString(split.charAt(i));
                }
            }
            i++;
        }
        return out;
    }




    /* ********************************************************************************************
     * You do not need to modify code below this comment.
     * ********************************************************************************************/

    /**
     * Solicit a string and split it whenever the character changes.
     * <p>
     * You are free to review this function, but should not modify it. Note that this function is
     * not tested by the test suite, as it is purely to aid your own interactive testing.
     *
     * @param unused unused input arguments
     */
    public static void main(final String[] unused) {
        Scanner lineScanner = new Scanner(System.in);
        System.out.println("Enter a string to split: ");
        String input = lineScanner.nextLine();
        System.out.println("This splits into: ");
        System.out.println(Arrays.toString(stringSplitter(input)));
    }
}
