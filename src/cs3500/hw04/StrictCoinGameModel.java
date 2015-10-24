package cs3500.hw03;

import java.lang.Override;
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
    throw new UnsupportedOperationException("no need to implement this");
  }

  /**
   * Returns an array of booleans that represent the String {@code board}. Throws an
   * {@code IllegalArgumentException} if there are any characters in {@code board} that are not "-"
   * or "O"(that is the uppercase o, not the integer 0).-
   * Called in {@code StrictCoinGameModel}.
   *
   * @return the boolean array board representation
   * @throws IllegalArgumentException board contains characters other than - and O.
   */
  protected static boolean[] stringToBoard(String board) {
    return new boolean[0]; //actual implementation would go here
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
   *
   * @return String representation of the game
   */
  protected String playersToString() {
  }

  /**
   * Gets the size of the board (the number of squares)
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

  @Override
  public void move(int coinIndex, int newPosition) {

  }

  /**
   * Adds a new player to the game n turns after the current player
   * @param {@code n} Turns after current player
   *
   * @return unique value identifying the player, starting with 1
   * @throws IllegalStateException the game is over
   * @thorws IllegalArgumentException if name is already used
   * @throws IllegalArgumentException if n > # of players
   */
  @Override
  public void addPlayer(String name) {
  }

  /**
   * Adds a new player to the game n turns after the current player
   * @param {@code n} Turns after current player
   *
   * @return unique value identifying the player, starting with 1
   * @throws IllegalStateException the game is over
   * @thorws IllegalArgumentException if name is already used
   * @throws IllegalArgumentException if n > # of players
   */
  @Override
  public void addPlayer(int n, String name) {

  }

  /**
   * Switches the player whose move it is to the next player by rotating the list so that the
   * current player (player at {@code players.get(0)} is now at the end of players, and the player
   * after that player is now at {@code players.get(0)}
   * If there is only 1 player, it stays that players turn.
   */
  @Override
  public void nextTurn() {
  }

  /**
   * Gets the string identifying the player whose turn it currently is
   * (the player at the index 0 in players)
   *
   * @return string of the current player
   */
  public String currentPlayer() {
    return this.players.get(0); //can do this because invariant players cannot be empty
  }

  /**
   * Get the winner of the game
   * Does this by checking if game is over, and if so, who last played
   * @return name of the winner
   * @throws IllegalArgumentException if game is not over
   */
  @Override
  public String winner() {
    return null;
  }

}