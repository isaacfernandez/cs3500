package cs3500.music.model;

/**
 * Created by isaacf on 12/14/15.
 */
public class SkipImp implements Skip {
  //For nested skips,

  //The location in which the next skip should be placed
  private int skipThen;
  //The next skip
  private Skip then;


  //Where this skip should skip to
  private int skipTo;

  public SkipImp(int skipTo) {
    this.then = null; //Just to be super explicit
    this.skipTo = skipTo;
    this.skipThen = -1;
  }
  // .......... null ..... null ......... mandatory
  public SkipImp(Skip then, int skipThen, int skipTo) {
    this.then = then;
    this.skipThen = skipThen;
    this.skipTo = skipTo;
  }

  public Skip getThen() {
    return then;
  }

  public int getSkipTo() {
    return skipTo;
  }

  public int getSkipThen() {
    return skipThen;
  }
}
