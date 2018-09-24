
/**
 * A class that generates a times table.
 * <p>
 * The provided code is incomplete. Modify it so that it works properly and passes the tests in
 * <code>StringSplitterTest.java</code>.
 * @see <a href="https://cs125.cs.illinois.edu/MP/2/">MP2 Documentation</a>
 */
public class TimesTable {
    /**
     * function that generates a 2d array times table.
     * @param first integer lower bound
     * @param second integer upper bound
     * @return timesTable which is a 2d array
     */
    public static int[][] generateTimesTable(final int first, final int second) {
        if (first <= 0 || second <= 0 || second <= first) {
            return null;
        }
        int i;
        int j;
        int row = second - first + 2;
        int[][] table = new int[row][row];
        table[0][0] = 0;
        for (i = 1; i < row; i++) {
            table[i][0] = first + i - 1;
        }
        for (j = 1; j < row; j++) {
            table[0][j] = first + j - 1;
        }
        for (i = 1; i < row; i++) {
            for (j = 1; j < row; j++) {
                table[i][j] = table[i][0] * table[0][j];
            }
        }
        return table;
    }
}
