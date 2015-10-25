package cs3500.hw04;

import java.lang.Boolean;
import java.lang.IllegalArgumentException;
import java.lang.IllegalStateException;
import java.lang.Override;
import java.lang.String;
import java.util.LinkedList;

public final class StrictCoinGameModel implements CoinGameModel {

  /**
   * Represents the state of the game. An element is true if there is a coin at that location. If
   * there is no coin at that location, the element is false.
   *
   * INVARIANT: The number of spaces in the game {@code gameState.length()}
   * cannot change during the game.
   */
  private final boolean[] gameState;

  /**
   * Represents the players in the game. The player whose turn it is is the first element in the
   * list ({@code player.get(0)})
   *
   * INVARIANT: Each String in {@code players} is unique (no two players share the same name).
   * INVARIANT: {@code players} cannot be empty.
   * INVARIANT: {@code players} cannot decrease in size (a player cannot leave the game).
   */
  private LinkedList<String> players;

  /**
   * Constructs a new StrictCoinGameModel.
   * Takes a String {@code board} as the String representation of the initial game state. Throws an
   * {@code IllegalArgumentException} if there are any characters in {@code board} that are not "-"
   * or "O"(that is the uppercase o, not the number 0). Calls {@code stringToBoard}.
   * Takes an arbitrary number of String {@code players}, which represent the names of each of the
   * starting players. Throws an {@code IllegalArgumentException} if there are any non-unique
   * (repeat) names. Throws an {@code IllegalArgumentException} if there are no players.
   *
   * @param board The String state of the board, represented with - for an empty space and O for
   *              a space with a coin.
   * @param players The unique String name of each starting player.
   * @throws IllegalArgumentException board contains characters other than - and O.
   * @throws IllegalArgumentException there are any player names that are not unique
   *  (more than one player with the same name).
   * @throws IllegalArgumentException there are no players
   */
  protected StrictCoinGameModel(String board, String... players) {
    this.players = new LinkedList<String>();
    this.gameState = StrictCoinGameModel.stringToBoard(board);
    if (players.length == 0) {
      throw new IllegalArgumentException("No Players");
    }
    for (String s : players) {
      if (this.players.contains(s)) {
        throw new IllegalArgumentException("Duplicate player name");
      }
      else {
        this.players.add(s);
      }
    }
  }

  /**
   * Returns an array of booleans that represent the String {@code board}. Throws an
   * {@code IllegalArgumentException} if there are any characters in {@code board} that are not "-"
   * or "O"(that is the uppercase o, not the integer 0).-
   * Called in {@code StrictCoinGameModel} .
   *
   * @return the boolean array board representation
   * @throws IllegalArgumentException board contains characters other than - and O.
   */
  protected static boolean[] stringToBoard(String board) {
    boolean[] arrayBoard = new boolean[board.length()];
    for (int x = 0; x < board.length(); x = x + 1) {
      if (board.substring(x, x + 1).equals("-")) {
        arrayBoard[x] = false;
      } else if (board.substring(x, x + 1).equals("O")) {
        arrayBoard[x] = true;
      } else {
        throw new IllegalArgumentException("Invalid board.");
      }
    }
    return arrayBoard;
  }

  /**
   * Returns a String representation of the {@code gameState}, with O standing for coins and
   * - standing for empty spaces.
   *
   * @return String representation of the game
   */
  protected String gameStateToString() {
    String game = "";
    for (int x = 0; x < this.boardSize(); x = x + 1) {
      if (this.gameState[x]) {
        game = game + "O";
      } else {
        game = game + "-";
      }
    }
    return game;
  }

  /**
   * Returns a list of players separated by commas.
   * For example, if players = {"A", "B", "C"}, the String returned would be "A, B, C"
   * A one player game would just return the name of that player.
   * The list will be in the same order as the turns are, with the player whose turn it currently
   * is going first.
   *
   * @return String representation of the game
   */
  protected String playersToString() {
    String playerString = "";
    for (int x = 0; x < players.size(); x = x + 1) {
      if (x == players.size() - 1) {
        playerString = playerString + this.players.get(x);
      }
      else {
        playerString = playerString + this.players.get(x) + ", ";
      }
    }
    return playerString;
  }

  /**
   * Gets the size of the board (the number of squares).
   *
   * @return the board size
   */
  @Override
  public int boardSize() {
    return this.gameState.length;
  }

  /**
   * Gets the number of coins.
   *
   * @return the number of coins
   */
  @Override
  public int coinCount() {
    int coins = 0; // number of coins seen so far
    for (int x = 0; x < this.boardSize(); x = x + 1) {
      if (this.gameState[x]) {
        coins = coins + 1;
      }
    }
    return coins;
  }

  /**
   * Gets the (zero-based) position of coin number {@code coinIndex}.
   *
   * @param coinIndex which coin to look up
   * @return the coin's position
   * @throws IllegalArgumentException
   *     if there is no coin with the requested index
   */
  @Override
  public int getCoinPosition(int coinIndex) {
    int coinNumber = -1; //represents coin index of the most recently seen coin
    for (int x = 0; x < this.boardSize(); x = x + 1) {
      if (this.gameState[x]) {
        coinNumber = coinNumber + 1;
        if (coinNumber == coinIndex) {
          return x;
        }
      }
    }
    throw new IllegalArgumentException("Coin " + coinIndex + " does not exist!");
  }

  /**
   * Returns whether the current game is over. The game is over if there are
   * no valid moves.
   *
   * @return whether the game is over
   */
  @Override
  public boolean isGameOver() {
    int coins = this.coinCount();
    for (int x = 0; x < coins; x = x + 1) {
      if (!this.gameState[x]) {
        return false;
      }
    }
    return true;
  }

  /**
   * Moves coin number {@code coinIndex} to position {@code newPosition} and
   * changes the turn to the next player.
   * Throws {@code IllegalMoveException} if the requested move is illegal,
   * which can happen in several ways:
   *
   * <ul>
   *   <li>There is no coin with the requested index.
   *   <li>The new position is occupied by another coin.
   *   <li>Moving the coin to that position would involve passing another coin.
   * </ul>
   *
   * Note that {@code coinIndex} refers to the coins as numbered from 0
   * to {@code coinCount() - 1}, not their absolute position on the board.
   * However, coins have no identity, so if one coin passes another, their
   * indices are exchanged. The leftmost coin is always coin 0, the next
   * leftmost is coin 1, and so on.
   *
   * @param coinIndex   which coin to move (numbered from the left)
   * @param newPosition where to move it to
   * @throws IllegalMoveException the move is illegal
   * @throws IllegalArgumentException the coin does not exist
   */
  @Override
  public void move(int coinIndex, int newPosition) {
    int coinLoc = this.getCoinPosition(coinIndex);
    if (newPosition < 0) {
      throw new IllegalMoveException("No position at that location.");
    } else if (coinLoc <= newPosition) { //includes locations larger than board size
      throw new IllegalMoveException("Can only move coin left of the current location!");
    } else if (coinIndex == 0) { // first coin, cannot be at first location because new
      this.gameState[coinLoc] = false;  //  position cannot be negative or the same as coin loc
      this.gameState[newPosition] = true;
    } else {
      for (int x = newPosition; x < coinLoc; x = x + 1) {
        if (this.gameState[x]) {
          throw new IllegalMoveException("Coins cannot pass other coins!");
        }
      }
      this.gameState[coinLoc] = false;
      this.gameState[newPosition] = true;
    }
    this.nextTurn();
  }

  /**
   * Adds a new player to the game, to play next.
   *
   * @param {@code name} The name of the new player
   * @return unique value identifying the player, starting with 1
   * @throws IllegalStateException the game is over
   * @thorws IllegalArgumentException if name is already used
   */
  public void addPlayer(String name) {
    if (this.isGameOver()) {
      throw new IllegalStateException("The game is already over!");
    } else if (this.players.contains(name)) {
      throw new IllegalArgumentException("There is already a player with that name!");
    } else {
      this.players.add(1, name);
    }
  }

  /**
   * Adds a new player to the game n turns after the current player
   *
   * @param {@code n} Turns after current player.
   * @param {@code name} The name of the new player.
   * @return unique value identifying the player, starting with 1
   * @throws IllegalStateException the game is over
   * @throws IllegalArgumentException if name is already used
   * @throws IllegalArgumentException if n > # of players
   */
  @Override
  public void addPlayer(int n, String name) {
    if (this.isGameOver()) {
      throw new IllegalStateException("The game is already over!");
    } else if (n > players.size()) {
      throw new IllegalArgumentException("Too many turns ahead!");
    } else if (this.players.contains(name)) {
      throw new IllegalArgumentException("There is already a player with that name!");
    } else {
      this.players.add(n + 1, name);
    }
  }

  /**
   * Switches the player whose move it is to the next player by rotating the list so that the
   * current player (player at {@code players.get(0)} is now at the end of players, and the player
   * after that player is now at {@code players.get(0)}
   * If there is only 1 player, it stays that players turn.
   */
  public void nextTurn() {
    String player = this.players.removeFirst();
    this.players.addLast(player);
  }

  /**
   * Gets the string identifying the player whose turn it currently is
   * (the player at the index 0 in players)
   *
   * @return string of the current player
   */
  public String currentPlayer() {
    return this.players.get(0);
  }

  /**
   * Get the winner of the game
   * Does this by checking if game is over, and if so, who last played
   * @return name of the winner
   * @throws IllegalStateException if game is not over
   */
  @Override
  public String winner() {
    if (this.isGameOver()) {
      return this.players.getLast();
    } else {
      throw new IllegalStateException("The game isn't over yet!");
    }
  }

}