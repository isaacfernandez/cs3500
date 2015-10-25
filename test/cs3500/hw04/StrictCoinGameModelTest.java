package cs3500.hw04;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StrictCoinGameModelTest {
  StrictCoinGameModel game0 = new StrictCoinGameModel("", "");
  StrictCoinGameModel game1 = new StrictCoinGameModel("----", "Someone", "Someone else!");
  StrictCoinGameModel game2 = new StrictCoinGameModel("O-O", "A person", "A different person");
  StrictCoinGameModel game3 = new StrictCoinGameModel("-OOOO-","abc", "def", "ghi");
  StrictCoinGameModel game4 = new StrictCoinGameModel("----O----O", "me");
  StrictCoinGameModel game5 = new StrictCoinGameModel("----O----O", "player 1", "player 2",
      "player 3", "player 4");
  StrictCoinGameModel game6 = new StrictCoinGameModel("OOOOO", "a");
  StrictCoinGameModel game7 = new StrictCoinGameModel("OO---", "???", "!!!", "?!?!?!");

  /*
  Constructor exception tests.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testConstructorException0() {
    CoinGameModel illegal = new StrictCoinGameModel("wrong", "PLAYER");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorException1() {
    CoinGameModel illegal = new StrictCoinGameModel("---o", "PLAYER", "OTHER PLAYER");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorException2() {
    CoinGameModel illegal = new StrictCoinGameModel("---OO", "me", "someone else", "me");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorException3() {
    CoinGameModel illegal = new StrictCoinGameModel("----OO", "a", "a", "a");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorException4() {
    CoinGameModel illegal = new StrictCoinGameModel("O-O");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorException5() {
    CoinGameModel illegal = new StrictCoinGameModel("really wrong");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testConstructorException6() {
    CoinGameModel illegal = new StrictCoinGameModel("also really wrong", ":o", ":o");
  }

  /*
  boardSize tests.
  */
  @Test
  public void testBoardSize0() {
    assertEquals(this.game0.boardSize(), 0);
  }

  @Test
  public void testBoardSize1() {
    assertEquals(this.game1.boardSize(), 4);
  }

  @Test
  public void testBoardSize2() {
    assertEquals(this.game2.boardSize(), 3);
  }

  @Test
  public void testBoardSize3() {
    assertEquals(this.game3.boardSize(), 6);
  }

  @Test
  public void testBoardSize4() {
    assertEquals(this.game4.boardSize(), 10);
  }

  @Test
  public void testBoardSize5() {
    assertEquals(this.game6.boardSize(), 5);
  }

  /*
  coinCount tests.
  */
  @Test
  public void testCointCount0() {
    assertEquals(this.game0.coinCount(), 0);
  }

  @Test
  public void testCointCount1() {
    assertEquals(this.game1.coinCount(), 0);
  }

  @Test
  public void testCointCount2() {
    assertEquals(this.game2.coinCount(), 2);
  }

  @Test
  public void testCointCount3() {
    assertEquals(this.game3.coinCount(), 4);
  }

  @Test
  public void testCointCount4() {
    assertEquals(this.game4.coinCount(), 2);
  }

  @Test
  public void testCointCount5() {
    assertEquals(this.game6.coinCount(), 5);
  }

  /*
  getCoinPosition exception tests.
  */
  @Test(expected = IllegalArgumentException.class)
  public void testCoinPosException0() {
    this.game0.getCoinPosition(0);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCoinPosException1() {
    this.game6.getCoinPosition(5);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCoinPosException2() {
    this.game4.getCoinPosition(2);
  }

  /*
  getCoinPosition tests.
   */
  @Test
  public void testCoinPos0() {
    assertEquals(this.game2.getCoinPosition(0), 0);
  }

  @Test
  public void testCoinPos1() {
    assertEquals(this.game2.getCoinPosition(1), 2);
  }

  @Test
  public void testCoinPos2() {
    assertEquals(this.game4.getCoinPosition(0), 4);
  }

  @Test
  public void testCoinPos3() {
    assertEquals(this.game6.getCoinPosition(4), 4);
  }

  /*
  isGameOver tests
  */
  @Test
  public void testIsGameOver0() {
    assertEquals(this.game0.isGameOver(), true);
  }

  @Test
  public void testIsGameOver1() {
    assertEquals(this.game1.isGameOver(), true);
  }

  @Test
  public void testIsGameOver2() {
    assertEquals(this.game2.isGameOver(), false);
  }

  @Test
  public void testIsGameOver3() {
    assertEquals(this.game3.isGameOver(), false);
  }

  @Test
  public void testIsGameOver4() {
    assertEquals(this.game4.isGameOver(), false);
  }

  @Test
  public void testIsGameOver5() {
    assertEquals(this.game6.isGameOver(), true);
  }

  @Test
  public void testIsGameOver7() {
    assertEquals(this.game7.isGameOver(), true);
  }

  /*
  gameStateToString tests.
   */
  @Test
  public void testGameStateToString0() {
    assertEquals(this.game0.gameStateToString(), "");
  }

  @Test
  public void testGameStateToString1() {
    assertEquals(this.game1.gameStateToString(), "----");
  }

  @Test
  public void testGameStateToString2() {
    assertEquals(this.game2.gameStateToString(), "O-O");
  }

  @Test
  public void testGameStateToString3() {
    assertEquals(this.game3.gameStateToString(), "-OOOO-");
  }

  @Test
  public void testGameStateToString4() {
    assertEquals(this.game4.gameStateToString(), "----O----O");
  }

  @Test
  public void testGameStateToString5() {
    assertEquals(this.game6.gameStateToString(), "OOOOO");
  }

  /*
  playersToString tests.
   */
  @Test
  public void testPlayersToString0() {
    assertEquals(this.game0.playersToString(), "");
  }

  @Test
  public void testPlayersToString1() {
    assertEquals(this.game1.playersToString(), "Someone, Someone else!");
  }

  @Test
  public void testPlayersToString2() {
    assertEquals(this.game2.playersToString(), "A person, A different person");
  }

  @Test
  public void testPlayersToString3() {
    assertEquals(this.game3.playersToString(), "abc, def, ghi");
  }

  @Test
  public void testPlayersToString4() {
    assertEquals(this.game4.playersToString(), "me");
  }

  @Test
  public void testPlayersToString5() {
    assertEquals(this.game5.playersToString(), "player 1, player 2, player 3, player 4");
  }

  @Test
  public void testPlayersToString6() {
    assertEquals(this.game7.playersToString(), "???, !!!, ?!?!?!");
  }

  /*
  stringToBoard tests.
   */
  @Test
  public void testStringToBoard0() {
    boolean[] board = new boolean[0];
    assertEquals(StrictCoinGameModel.stringToBoard(""), board);
  }

  @Test
  public void testStringToBoard1() {
    boolean[] board = {false, false, true, true};
    assertEquals(StrictCoinGameModel.stringToBoard("--OO"), board);
  }

  @Test
  public void testStringToBoard2() {
    boolean[] board = {true, false, true, false, true, false, true, false};
    assertEquals(StrictCoinGameModel.stringToBoard("O-O-O-O-"), board);
  }

  @Test
  public void testStringToBoard3() {
    boolean[] board = {false, false, false, false, false};
    assertEquals(StrictCoinGameModel.stringToBoard("-----"), board);
  }

  /*
  stringToBoard exception tests.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testStringToBoardException0() {
    StrictCoinGameModel.stringToBoard("nope");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testStringToBoardException1() {
    StrictCoinGameModel.stringToBoard("---O-o");
  }

  /*
  nextTurn and currentPlayer tests.
  (Tested together so more than one player per game can be the current player, and so we can see
  if next turn actually changes the player.)
   */
  @Test
  public void testNextTurnAndCurrentPlayer0() {
    StrictCoinGameModel game = new StrictCoinGameModel("----O----O", "player 1", "player 2",
        "player 3", "player 4");
    assertEquals(game.currentPlayer(), "player 1");
    game.nextTurn();
    assertEquals(game.currentPlayer(), "player 2");
    game.nextTurn();
    assertEquals(game.currentPlayer(), "player 3");
    game.nextTurn();
    assertEquals(game.currentPlayer(), "player 4");
    game.nextTurn();
    assertEquals(game.currentPlayer(), "player 1");
    game.nextTurn();
    assertEquals(game.currentPlayer(), "player 2");
  }

  @Test
  public void testNextTurnAndCurrentPlayer1() {
    StrictCoinGameModel game = new StrictCoinGameModel("----O", ":o");
    assertEquals(game.currentPlayer(), ":o");
    game.nextTurn();
    assertEquals(game.currentPlayer(), ":o");
  }

  @Test
  public void testNextTurnAndCurrentPlayer2() {
    StrictCoinGameModel game = new StrictCoinGameModel("-O---O", "a", "b");
    assertEquals(game.currentPlayer(), "a");
    game.nextTurn();
    assertEquals(game.currentPlayer(), "b");
    game.nextTurn();
    assertEquals(game.currentPlayer(), "a");
    game.nextTurn();
    assertEquals(game.currentPlayer(), "b");
  }

  /*
  addPlayer tests.
   */
  @Test
  public void testAddPlayer0() {
    StrictCoinGameModel game = new StrictCoinGameModel("", "!");
    assertEquals(game.playersToString(), "!");
    game.addPlayer("someone");
    assertEquals(game.playersToString(), "!, someone");
    game.addPlayer("not me");
    assertEquals(game.playersToString(), "!, not me, someone");
  }

  @Test
  public void testAddPlayer1() {
    StrictCoinGameModel game = new StrictCoinGameModel("-OOOO-","abc", "def", "ghi");
    assertEquals(game.playersToString(), "abc, def, ghi");
    game.addPlayer("jkl");
    assertEquals(game.playersToString(), "abc, jkl, def, ghi");
    game.nextTurn();
    game.addPlayer("mno");
    assertEquals(game.playersToString(), "abc, jkl, mno, def, ghi");
  }

  @Test
  public void testAddPlayer2() {
    StrictCoinGameModel game = new StrictCoinGameModel("----O----O", "me", "you");
    game.nextTurn();
    game.addPlayer("another dude");
    assertEquals(game.playersToString(), "me, you, another dude");
    game.nextTurn();
    game.nextTurn();
    game.addPlayer(":o");
    assertEquals(game.playersToString(), "me, :o, you, another dude");
  }

  /*
  addPlayer exception tests.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testAddPlayerException0() {
    StrictCoinGameModel game = new StrictCoinGameModel("----O----O", "me", "you");
    game.addPlayer("you");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddPlayerException1() {
    StrictCoinGameModel game = new StrictCoinGameModel("----O----O", "player 1", "player 2",
        "player 3", "player 4");
    game.addPlayer("player 5");
    game.addPlayer("player 1");
  }

  /*
  winner tests.
   */
  @Test
  public void testWinner0() {
    StrictCoinGameModel game = new StrictCoinGameModel("OO--", "player 1", "player 2");
    assertEquals(game.winner(), "player 1");
  }

  @Test
  public void testWinner1() {
    StrictCoinGameModel game = new StrictCoinGameModel("O-----OO", "player 1", "player 2",
        "player 3");
    game.move(1, 1);
    game.move(2, 2);
    assertEquals(game.winner(), "player 2");
  }

  @Test
  public void testWinner2() {
    StrictCoinGameModel game = new StrictCoinGameModel("O-----OO", "player 1", "player 2",
        "player 3");
    game.move(1, 3);
    game.move(2, 4);
    game.move(1, 1);
    game.move(2, 2);
    assertEquals(game.winner(), "player 1");
  }

  /*
  winner exception tests
   */
  @Test(expected = IllegalArgumentException.class)
  public void testWinnerException0() {
    StrictCoinGameModel game = new StrictCoinGameModel("O--O--OO", "player 1", "player 2",
        "player 3", "player 4");
    game.winner();
  }

  @Test(expected = IllegalArgumentException.class)
  public void testWinnerException1() {
    StrictCoinGameModel game = new StrictCoinGameModel("-OOO", ":o", ":)");
    game.move(0, 0);
    game.winner();
  }

}
