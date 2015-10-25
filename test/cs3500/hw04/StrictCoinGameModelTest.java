package cs3500.hw04;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

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


  //Helper because assertEquals(boolean[], boolean[]) doesn't exist
  public static boolean booleanArrayEq(boolean[] a, boolean[] b) {
    if (a.length != b.length) {
      return false;
    }
    for (int i = 0; i < a.length; i++) {
      if (a[i] != b[i]) {
        return false;
      }
    }
    return true;
    }

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
    assertEquals(true, booleanArrayEq(StrictCoinGameModel.stringToBoard(""), board));
  }

  @Test
  public void testStringToBoard1() {
    boolean[] board = {false, false, true, true};
    assertEquals(true, booleanArrayEq(StrictCoinGameModel.stringToBoard("--OO"), board));
  }

  @Test
  public void testStringToBoard2() {
    boolean[] board = {true, false, true, false, true, false, true, false};
    assertEquals(true, booleanArrayEq(StrictCoinGameModel.stringToBoard("O-O-O-O-"), board));
  }

  @Test
  public void testStringToBoard3() {
    boolean[] board = {false, false, false, false, false};
    assertEquals(true, booleanArrayEq(StrictCoinGameModel.stringToBoard("-----"), board));
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
    StrictCoinGameModel game = new StrictCoinGameModel("--O", "!");
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
    assertEquals(game.playersToString(), "jkl, mno, def, ghi, abc");
  }

  @Test
  public void testAddPlayer2() {
    StrictCoinGameModel game = new StrictCoinGameModel("----O----O", "me", "you");
    game.nextTurn();
    game.addPlayer("another dude");
    assertEquals(game.playersToString(), "you, another dude, me");
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
  move tests.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveException0() {
    CoinGameModel mgame = new StrictCoinGameModel("----", "beep", "honk", "bzzz");
    mgame.move(0, 1);
  }

  @Test(expected = CoinGameModel.IllegalMoveException.class)
  public void testMoveException1() {
    CoinGameModel mgame = new StrictCoinGameModel("-OOO-O", "mmmmhhhmmmmmmm", "D:");
    mgame.move(1, 0);
  }

  @Test(expected = CoinGameModel.IllegalMoveException.class)
  public void testMoveException2() {
    CoinGameModel mgame = new StrictCoinGameModel("-O----O-", "!!!", "!!!???", "?", "why");
    mgame.move(1, 1);
  }

  @Test(expected = CoinGameModel.IllegalMoveException.class)
  public void testMoveException3() {
    CoinGameModel mgame = new StrictCoinGameModel("--O----","you", "who?");
    mgame.move(0, 2);
  }

  @Test(expected = CoinGameModel.IllegalMoveException.class)
  public void testMoveException4() {
    CoinGameModel mgame = new StrictCoinGameModel("--O----", "a player", "another player");
    mgame.move(0, 4);
  }

  @Test(expected = CoinGameModel.IllegalMoveException.class)
  public void testMoveException5() {
    CoinGameModel mgame = new StrictCoinGameModel("--O----", "a player");
    mgame.move(0, -1);
  }
  @Test(expected = CoinGameModel.IllegalMoveException.class)
  public void testMoveException6() {
    CoinGameModel mgame = new StrictCoinGameModel("--O----", "a player", "??");
    mgame.move(0, 1);
    mgame.move(0, -1);
  }

  @Test
  public void testMove0() {
    StrictCoinGameModel mgame = new StrictCoinGameModel("--O----", "a player", "another player");
    mgame.move(0, 1);
    assertEquals(mgame.gameStateToString(), "-O-----");
  }

  @Test
  public void testMove1() {
    StrictCoinGameModel mgame = new StrictCoinGameModel("--O----", "a", "b", "c", "d", "e", "f");
    mgame.move(0, 0);
    assertEquals(mgame.gameStateToString(), "O------");
  }

  @Test
  public void testMove2() {
    StrictCoinGameModel mgame = new StrictCoinGameModel("----O----O", ":o");
    mgame.move(1, 5);
    assertEquals(mgame.gameStateToString(), "----OO----");
  }

  @Test
  public void testMove3() {
    StrictCoinGameModel mgame = new StrictCoinGameModel("----O----O", "runescape", "world of warcraft",
        "league of legends" );
    mgame.move(0, 1);
    assertEquals(mgame.gameStateToString(), "-O-------O");
    mgame.move(0,0);
    assertEquals(mgame.gameStateToString(), "O--------O");
    mgame.move(1,3);
    assertEquals(mgame.gameStateToString(), "O--O------");
  }

  /*
  winner tests.
   */
  @Test
  public void testWinner0() {
    StrictCoinGameModel game = new StrictCoinGameModel("OO--", "player 1", "player 2");
    assertEquals(game.winner(), "player 2");
  }

  @Test
  public void testWinner1() {
    StrictCoinGameModel game = new StrictCoinGameModel("OO--", "player 2", "player 1");
    assertEquals(game.winner(), "player 1");
  }

  @Test
  public void testWinner2() {
    StrictCoinGameModel game = new StrictCoinGameModel("O-----OO", "player 1", "player 2",
        "player 3");
    game.move(1, 1);
    game.move(2, 2);
    assertEquals(game.winner(), "player 2");
  }

  @Test
  public void testWinner3() {
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
  @Test(expected = IllegalStateException.class)
  public void testWinnerException0() {
    StrictCoinGameModel game = new StrictCoinGameModel("O--O--OO", "player 1", "player 2",
        "player 3", "player 4");
    game.winner();
  }

  @Test(expected = IllegalStateException.class)
  public void testWinnerException1() {
    StrictCoinGameModel game = new StrictCoinGameModel("-OOO", ":o", ":)");
    game.move(0, 0);
    game.winner();
  }


  @Test
  public void testAddThrowException0() {
    StrictCoinGameModel game = new StrictCoinGameModel("OOO---", ":o", ":)");
    if (!game.isGameOver()) {
      fail("Game isn't over?");
      return;
    }
    try {
      game.addPlayer(":c");
    } catch (IllegalStateException e) {
      assertEquals(e.getMessage(), "The game is already over!");
      return;
    }
    fail("Did not error");
  }

  @Test(expected = IllegalStateException.class)
  public void testAddThrowException1() {
    StrictCoinGameModel game = new StrictCoinGameModel("OOOOO--", "XD",":o", ":)", ":D");
      game.addPlayer(":c");
  }

  @Test
  public void testAddThrowException2() {
    StrictCoinGameModel game = new StrictCoinGameModel("-OO---", ":o", ":)");
    try {
      game.addPlayer(100, ":c");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "Too many turns ahead!");
      return;
    }
    fail("Did not error");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddThrowException3() {
    StrictCoinGameModel game = new StrictCoinGameModel("-OO---", "?", "!");
      game.addPlayer(3, ":c");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddThrowExceptionNeg4() {
    StrictCoinGameModel game = new StrictCoinGameModel("-OO---", "?", "!");
    game.addPlayer(-4, ":c");
  }

  @Test
  public void testAddThrowException4() {
    StrictCoinGameModel game = new StrictCoinGameModel("-OO---", ":o", ":)");
    try {
      game.addPlayer(":o");
    } catch (IllegalArgumentException e) {
      assertEquals(e.getMessage(), "There is already a player with that name!");
      return;
    }
    fail("Did not error");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testAddThrowException5() {
    StrictCoinGameModel game = new StrictCoinGameModel("-OO---", "yes", "no", "maybe");
    game.addPlayer("maybe");
  }

  @Test
  public void testAddPlayer() {
    StrictCoinGameModel game = new StrictCoinGameModel("-OO---", "yes", "no");
    game.addPlayer(0, "maybe");
    StrictCoinGameModel g2 = new StrictCoinGameModel("-OO---", "yes", "no");
    g2.addPlayer("maybe");
    assertEquals(game.playersToString(), g2.playersToString());
  }

  /*
  toString tests.
  */
  @Test
  public void testToString0() {
    assertEquals(this.game0.toString(), "");
  }

  @Test
  public void testToString1() {
    assertEquals(this.game1.toString(), "----");
  }

  @Test
  public void testToString2() {
    assertEquals(this.game2.toString(), "O-O");
  }

  @Test
  public void tesToString3() {
    assertEquals(this.game3.toString(), "-OOOO-");
  }

  @Test
  public void testToString4() {
    assertEquals(this.game4.toString(), "----O----O");
  }

  @Test
  public void testToString5() {
    assertEquals(this.game6.toString(), "OOOOO");
  }
}
