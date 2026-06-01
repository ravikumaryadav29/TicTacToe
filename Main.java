package main;

import game.Game;
import model.Player;

import java.util.Scanner;

/**
 * Main class — entry point.
 *
 * Responsibilities:
 *   1. Show welcome banner
 *   2. Ask for game mode (2-player vs computer)
 *   3. Collect player name(s)
 *   4. Create Player objects and launch Game
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printBanner();

        int mode = chooseMode(scanner);

        Player player1;
        Player player2;

        if (mode == 1) {
            // ── 2-Player Mode ────────────────────────────────────
            System.out.print("\n  Enter name for Player X: ");
            String name1 = readName(scanner, "Player X");

            System.out.print("  Enter name for Player O: ");
            String name2 = readName(scanner, "Player O");

            player1 = new Player(name1, 'X', false);
            player2 = new Player(name2, 'O', false);

        } else {
            // ── Single-Player Mode (vs Computer) ─────────────────
            System.out.print("\n  Enter your name: ");
            String name1 = readName(scanner, "Player");

            player1 = new Player(name1,    'X', false);
            player2 = new Player("Computer", 'O', true);
        }

        // Launch the game session
        Game game = new Game(player1, player2, scanner);
        game.start();

        scanner.close();
    }

    // ── Helpers ──────────────────────────────────────────────────

    private static int chooseMode(Scanner scanner) {
        System.out.println("\n  ┌─────────────────────────────┐");
        System.out.println("  │       SELECT GAME MODE      │");
        System.out.println("  ├─────────────────────────────┤");
        System.out.println("  │  1. Two Players (Human)     │");
        System.out.println("  │  2. Single Player (vs AI)   │");
        System.out.println("  └─────────────────────────────┘");

        while (true) {
            System.out.print("  Your choice (1 or 2): ");
            try {
                String line = scanner.nextLine().trim();
                int choice = Integer.parseInt(line);
                if (choice == 1 || choice == 2) return choice;
                System.out.println("  ⚠  Please enter 1 or 2.");
            } catch (NumberFormatException e) {
                System.out.println("  ⚠  Invalid input. Enter 1 or 2.");
            }
        }
    }

    private static String readName(Scanner scanner, String defaultName) {
        try {
            String name = scanner.nextLine().trim();
            return name.isEmpty() ? defaultName : name;
        } catch (Exception e) {
            return defaultName;
        }
    }

    private static void printBanner() {
        System.out.println();
        System.out.println("  ╔══════════════════════════════════════════╗");
        System.out.println("  ║                                          ║");
        System.out.println("  ║    ✖ ○  T I C  T A C  T O E  ✖ ○       ║");
        System.out.println("  ║                                          ║");
        System.out.println("  ║     Built with Java | OOP + AI + Threads ║");
        System.out.println("  ║                                          ║");
        System.out.println("  ╚══════════════════════════════════════════╝");
    }
}
