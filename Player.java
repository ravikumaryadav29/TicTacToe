package model;

/**
 * Player class — stores player name, symbol (X or O), wins count,
 * and whether this player is a computer (AI) or human.
 */
public class Player {

    private String name;
    private char   symbol;   // 'X' or 'O'
    private int    wins;
    private boolean isComputer;

    public Player(String name, char symbol, boolean isComputer) {
        this.name       = name;
        this.symbol     = symbol;
        this.wins       = 0;
        this.isComputer = isComputer;
    }

    // ── Getters ──────────────────────────────────────────────────
    public String  getName()       { return name; }
    public char    getSymbol()     { return symbol; }
    public int     getWins()       { return wins; }
    public boolean isComputer()    { return isComputer; }

    /** Called whenever this player wins a game. */
    public void addWin()           { wins++; }

    @Override
    public String toString() {
        return name + " (" + symbol + ")";
    }
}
