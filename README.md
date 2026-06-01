# ✖○ Tic Tac Toe — Java Project

A complete, beginner-friendly yet professionally structured Tic Tac Toe game in Java.

---

## 📁 Project Structure

```
TicTacToe/
└── src/
    ├── model/
    │   ├── Player.java       ← Player entity (name, symbol, wins, isComputer)
    │   └── Board.java        ← 3x3 grid (display, validate, win/draw check)
    ├── game/
    │   ├── Game.java         ← Main game loop (turns, input, win detection)
    │   ├── AIPlayer.java     ← Minimax AI (unbeatable computer opponent)
    │   ├── MoveTimer.java    ← Per-move countdown (background thread)
    │   └── Scoreboard.java   ← Tracks wins/draws across rounds
    └── main/
        └── Main.java         ← Entry point (mode selection, player setup)
```

---

## ▶️ Compile & Run

```bash
# 1. Go to project folder
cd TicTacToe

# 2. Create output folder
mkdir out

# 3. Compile all files
javac -d out src/model/*.java src/game/*.java src/main/Main.java

# 4. Run
java -cp out main.Main
```

---

## 🎮 How to Play

```
Select mode:
  1 → Two Players (you vs friend)
  2 → Single Player (you vs AI)

Board positions:
      1   2   3
  1 |   |   |   |
  2 |   |   |   |
  3 |   |   |   |

Enter row (1-3) then col (1-3) to place your symbol.
You have 20 seconds per move.
```

---

## 🧠 Class-by-Class Explanation

### model/Player.java
Stores everything about one player:
- `name` — display name
- `symbol` — 'X' or 'O'
- `wins` — incremented each time they win
- `isComputer` — true for AI player

### model/Board.java
Manages the 3×3 grid:
- `display()` — prints grid with row/col labels
- `isValidMove(r, c)` — checks bounds + not already filled
- `placeMove(r, c, symbol)` — writes symbol to grid
- `checkWin(symbol)` — checks all 8 win lines
- `isFull()` — detects draw condition

### game/Game.java
The game loop:
- Alternates turns between player1 and player2
- Calls `makeHumanMove()` or `makeAIMove()` based on player type
- Starts MoveTimer for each human turn
- Detects win/draw after every move
- Handles restart between rounds

### game/AIPlayer.java
Minimax algorithm:
- Recursively simulates every possible future game state
- Scores: +10 for AI win, -10 for human win, 0 for draw
- Depth is subtracted/added so it prefers faster wins
- Result: AI is unbeatable — best you can do is draw

### game/MoveTimer.java
Background countdown timer:
- Runs in a **daemon thread** (auto-dies when app exits)
- Uses `AtomicBoolean` for thread-safe flag sharing
- Prints warning at halfway mark
- Main thread checks `isExpired()` in its input loop

### game/Scoreboard.java
Tracks wins and draws across all rounds in one session.
Displays a formatted table after each game.

### main/Main.java
Entry point:
- Shows banner
- Asks for game mode (1 or 2)
- Collects player name(s)
- Creates `Player` objects and starts `Game`

---

## ✅ Features Checklist

| Feature | Status |
|---|---|
| 2-Player mode | ✅ |
| Single-player vs AI | ✅ |
| Minimax AI (smart moves) | ✅ |
| 3×3 board display | ✅ |
| Row/column input | ✅ |
| Input validation | ✅ |
| Win detection (row/col/diagonal) | ✅ |
| Draw detection | ✅ |
| Move timer (threads) | ✅ |
| Scoreboard (multi-round) | ✅ |
| Restart option | ✅ |
| Clean OOP structure | ✅ |
| Comments throughout | ✅ |

---

## 🚀 Resume Improvement Ideas

1. **JavaFX GUI** — build a visual board with click-to-play
2. **4×4 or 5×5 board** — extend Board and win-check logic
3. **Network multiplayer** — use Java Sockets for LAN play
4. **Difficulty levels** — Easy (random), Medium (1-step ahead), Hard (full Minimax)
5. **Save game history** — write results to a file with timestamps
6. **Unit tests** — JUnit 5 tests for Board.checkWin() and AIPlayer
7. **Spring Boot REST** — expose game as an API, play from browser

---

## 🔑 Java Concepts Demonstrated

| Concept | Where Used |
|---|---|
| OOP (classes, encapsulation) | All model classes |
| Recursion | Minimax in AIPlayer |
| Multithreading | MoveTimer (daemon thread) |
| AtomicBoolean | Thread-safe timer flag |
| try-catch | Integer parsing in Game + Main |
| 2D arrays | Board grid |
| Comparable / sorting logic | Scoreboard |
