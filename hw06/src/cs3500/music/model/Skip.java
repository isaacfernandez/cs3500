package cs3500.music.model;

/**
 * Created by rdvoskin on 12/16/15.
 */
public interface Skip {

  Skip getThen();

  int getSkipTo();

  int getSkipThen();
}
