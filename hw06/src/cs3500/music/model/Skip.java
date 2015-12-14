package cs3500.music.model;

/**
 * Created by isaacf on 12/14/15.
 */
public class Skip {
  private Skip then;
  private int skipThen;
  private int skipTo;

  public Skip(int skipTo) {
    this.then = null; //Just to be super explicit
    this.skipTo = skipTo;
    this.skipThen = -1;
  }

  public Skip(Skip then, int skipThen, int skipTo) {
    this.then = then;
    this.skipThen = skipThen;
    this.skipTo = skipTo;
  }

  public Skip getThen() {
    return then;
  }

  public void setThen(Skip then) {
    this.then = then;
  }

  public int getSkipTo() {
    return skipTo;
  }

  public int getSkipThen() {
    return skipThen;
  }
}
