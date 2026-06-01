package model;

/**
 * Board class — manages the 3×3 grid.
 * Responsibilities:
 *   • Store the current state of each cell
 *   • Display the board in the console
 *   • Validate moves
 *   • Check win / draw conditions
 */
public class Board {

    public static final int SIZE = 3;
    private char[][] grid;

    /** Creates a fresh empty board. */
    public Board() {
        reset();
    }

    // ── Reset ────────────────────────────────────────────────────

    /** Clears all cells back to empty (' '). */
    public void reset() {
        grid = new char[SIZE][SIZE];
        for (int r = 0; r < SIZE; r++)
            for (int c = 0; c < SIZE; c++)
                grid[r][c] = ' ';
    }

    // ── Display ──────────────────────────────────────────────────

    /**
     * Prints the board with row/column guides.
     *
     * Example output:
     *       1   2   3
     *   1 | X |   | O |
     *     |---|---|---|
     *   2 |   | X |   |
     *     |---|---|---|
     *   3 | O |   | X |
     */
    public void display() {
        System.out.println();
        System.out.println("      1   2   3");
        System.out.println("    +---+---+---+");
        for (int r = 0; r < SIZE; r++) {
            System.out.print("  " + (r + 1) + " |");
            for (int c = 0; c < SIZE; c++) {
                System.out.print(" " + grid[r][c] + " |");
            }
            System.out.println();
            System.out.println("    +---+---+---+");
        }
        System.out.println();
    }

    // ── Move Validation & Placement ──────────────────────────────

    /**
     * Returns true if (row, col) is within bounds and the cell is empty.
     * row and col are 0-indexed internally.
     */
    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < SIZE
            && col >= 0 && col < SIZE
            && grid[row][col] == ' ';
    }

    /** Places the symbol on the board. Assumes move is already validated. */
    public void placeMove(int row, int col, char symbol) {
        grid[row][col] = symbol;
    }

    // ── Win / Draw Detection ─────────────────────────────────────

    /**
     * Checks whether the given symbol has won.
     * Checks all rows, columns, and both diagonals.
     */
    public boolean checkWin(char symbol) {
        // Check rows
        for (int r = 0; r < SIZE; r++) {
            if (grid[r][0] == symbol && grid[r][1] == symbol && grid[r][2] == symbol)
                return true;
        }
        // Check columns
        for (int c = 0; c < SIZE; c++) {
            if (grid[0][c] == symbol && grid[1][c] == symbol && grid[2][c] == symbol)
                return true;
        }
        // Check main diagonal (top-left → bottom-right)
        if (grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol)
            return true;
        // Check anti-diagonal (top-right → bottom-left)
        if (grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol)
            return true;

        return false;
    }

    /** Returns true if every cell is filled (no empty cell remains). */
    public boolean isFull() {
        for (int r = 0; r < SIZE; r++)
            for (int c = 0; c < SIZE; c++)
                if (grid[r][c] == ' ') return false;
        return true;
    }

    // ── AI Helper ────────────────────────────────────────────────

    /** Returns the raw grid (needed by AI to evaluate positions). */
    public char[][] getGrid() {
        return grid;
    }
}
