import java.util.HashSet;

public class SudokuDemo {
    static int[][] board = {
            {6, 3, 9, 5, 7, 4, 1, 8, 2},
            {5, 4, 1, 8, 2, 9, 3, 7, 6},
            {7, 8, 2, 6, 1, 3, 9, 5, 4},
            {1, 9, 8, 4, 6, 7, 5, 2, 3},
            {3, 6, 5, 9, 8, 2, 4, 1, 7},
            {4, 2, 7, 1, 3, 5, 8, 6, 9},
            {9, 5, 6, 7, 4, 8, 2, 3, 1},
            {8, 1, 3, 2, 9, 6, 7, 4, 5},
            {2, 7, 4, 3, 5, 1, 6, 9, 8}
    };

    public static void main(String[] args) {
        System.out.println(verify(board));
    }

    private static boolean verify(int[][] rows) {
        return verifyRows(rows) && verifyColumns(rows) && verifySquares(rows);
    }

    private static boolean verifyNine(int[] nineDigits) {
        HashSet<Integer> set = new HashSet<>();
        for (int digit : nineDigits) {
            if (set.contains(digit)) return false;
            set.add(digit);
        }
        return true;
    }

    private static boolean verifyRows(int[][] rows) {
        for (int[] row : rows) {
            if (!verifyNine(row)) return false;
        }
        return true;
    }

    private static boolean verifyColumns(int[][] rows) {
        for (int i = 0; i < 9; i += 1) {
            if (!verifyNine(getColumn(rows, i))) return false;
        }
        return true;
    }

    private static int[] getColumn(int[][] rows, int index) {
        int[] column = new int[9];
        for (int i = 0; i < 9; i += 1) {
            column[i] = rows[i][index];
        }
        return column;
    }

    private static boolean verifySquares(int[][] rows) {
        for (int x = 0; x < 9; x += 3) {
            for (int y = 0; y < 9; y += 3) {
                if (!verifyNine(getSquare(rows, x, y))) return false;
            }
        }
        return true;
    }

    private static int[] getSquare(int[][] rows, int x, int y) {
        return new int[]{
                rows[x][y], rows[x][y + 1], rows[x][y + 2],
                rows[x + 1][y], rows[x + 1][y + 1], rows[x + 1][y + 2],
                rows[x + 2][y], rows[x + 2][y + 1], rows[x + 2][y + 2]
        };
    }
}
