package cs3500.hw04;
import java.util.*;

/**
 * You don't need to implement this class or any concrete subclasses
 * for pset03.
 */
public final class StrictCoinGameModel implements CoinGameModel {

  /**
   *  The state of the board, represented internally as 0s and 1s
   *  1s represent coins, 0s empty spaces
   */
  private int[] boardState;

  /**
   * Players are represented as integers
   * Keeps track of all players and current play order.
   * players.get(0) is the current player.
   */
  private ArrayList<Integer> players;
  /**
   * INVARIANT: players never decreases in size. When a player takes his turn, he will be removed
   * from the front of the list and immediately reinserted into the back.
   * INVARIANT: All entries in players are unique. No two players should share the same id.
   * INVARIANT: Not empty.
   * INVARIANT: players is only to be modified as follows:
   *<ul>
   *     <li>Integer i = players.remove(0), only if followed by players.add(i)</li>
   *     <li>players.add(Integer i), where i is not already in players.</li>
   *</ul>
   * This maintains that the players are always in the proper play order
   *
   *
   *
  /**
   * Constructs a CoinGameModel following StrictGameModel rules. A Coin Game consists of a board
   * and an n number of players.
   * The board shall be represented as a string, whose characters are either O (uppercase 0) or '-'
   * The O represents a coin and the - an empty spot.
   * The players are provided as an ArrayList\<Integer\>,
   *
   * @param players ArrayList<Integer> Representing the players and play order
   * @param board String representing the board state
   * @throws IllegalArgumentException if the boardstate is not valid or there are no players
   */
  protected StrictCoinGameModel(String board, ArrayList<Integer> players) {
    // You don't need to implement this constructor.
    throw new UnsupportedOperationException("no need to implement this");
  }

  /**
   * Default constructor. Requires, at minimum, the initial board state. Will default to one player,
   * but supports adding additional players.
   */
  public static final class Builder {
    int playerCounter = 0;
    ArrayList<Integer> players;
    String board;

    /** Construct a builder with 1 player and the given boardstate
     * @param board Initial board state
     */
    public Builder(String board) {
      this.board = board;
      players = new ArrayList();
      this.addPlayer();
    }
    /**
     * Constructs the game with n number of players
     * @param board Initial board state
     * @param n Number of players
     */
    public Builder(String board, int n) {
      this.board = board;
      for (int i = 0; i < n; i++) {
        this.addPlayer();
      }
    }

    /**Adds a player to the game
     * @return this
     */
    public Builder addPlayer() {
      this.playerCounter++;
      players.add(new Integer(playerCounter));
      return this;
    }

    /** Rotates the player with so that the starting player is player i
     * @param i The player who will start
     * @return this
     */
    public Builder startWith(int i) {
      //TODO
      return this;
    }

    /**
     * Creates a StrictCoinGameModel as specified
     * @return StrictCoinGame Model
     */
    public StrictCoinGameModel build() {
      //TODO
      return new StrictCoinGameModel(board, players);
    }
  }

  // You don't need to implement any methods or constructors. However,
  // if you want to make sure your code compiles, you could have your
  // IDE generate stubs for all the missing methods. This would also
  // allow you to make sure that your tests in StrictCoinGameModelTest
  // actually type check and compile against this class (though you
  // don’t need to make them pass, because you don’t need to implement
  // StrictCoinGameModel’s methods).
}
