package cs3500.hw03;

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
    return "";
  }

  /**
   * Returns a list of players separated by commas.
   * For example, if players = {"A", "B", "C"}, the String returned would be "A, B, C"
   * A one player game would just return the name of that player.
   *
   * @return String representation of the game
   */
  protected String playersToString() {
    return "";
  }

  @Override
  public int boardSize() {
    return 0;
  }

  @Override
  public int coinCount() {
    return 0;
  }

  @Override
  public int getCoinPosition(int coinIndex) {
    return 0;
  }

  @Override
  public boolean isGameOver() {
    return false;
  }

  @Override
  //
  public void move(int coinIndex, int newPosition) {

  }

  @Override
  public void addPlayer(String name) {

  }

  public void addPlayer(int n, String name) {

  }


  /**
   * Switches the player whose move it is to the next player by rotating the list so that the
   * current player (player at {@code players.get(0)} is now at the end of players, and the player
   * after that player is now at {@code players.get(0)}
   * If there is only 1 player, it stays that players turn.
   *
   */
  @Override
  public void nextTurn() {
  }

  @Override
  public String currentPlayer() {
    return null;
  }

  @Override
  public String winner() {
    return null;
  }

}