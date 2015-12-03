package cs3500.music.view;


import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Rectangle {
  Rectangle2D.Double rect;
  Color color;
  int x, y, h, l;

  public Rectangle(int x, int y, int h, int l, Color color) {
    rect = new Rectangle2D.Double();
    this.rect.setRect(x, y, h, l);
    this.color = color;
    this.x = x;
    this.y = y;
    this.h = h;
    this.l = l;

  }
}
