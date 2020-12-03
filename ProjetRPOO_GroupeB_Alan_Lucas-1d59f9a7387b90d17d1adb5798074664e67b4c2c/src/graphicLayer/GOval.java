package graphicLayer;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class GOval extends GBounded {

  /**
   * .
   */
  public void draw(Graphics2D g) {
    
    Rectangle bounds = this.getBounds();
    g.setColor(color);
    g.fillOval(bounds.x, bounds.y, bounds.width, bounds.height);
    this.drawContents(g);
    Color c = g.getColor();
    g.setColor(c);
  }

}
