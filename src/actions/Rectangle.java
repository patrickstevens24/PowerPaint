package actions;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;

import view.Shapes;

/**
 * Creates a rectangle tool.
 * 
 * @author Patrick Stevens
 * @version 1.0
 */
public class Rectangle extends AbstractTool {
    /**
     * Auto-Generated serial ID.
     */
    private static final long serialVersionUID = 2028771901776672737L;
    /**
     * The name of the Rectangle tool.
     */
    private static final String RECTANGLE_NAME = "rectangle";
    /**
     * Constructor for the Rectangle.
     * @param theShape 
     */
    public Rectangle(final Shapes theShape) {
        super("Rectangle", new ImageIcon("images/rectangle.gif"), 
              KeyEvent.VK_R, theShape);
    }
    /**
     * The action the rectangle does.
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        final Shapes currentTool = getShape();
        currentTool.setStartPoint(new Point()); 
        currentTool.setName(RECTANGLE_NAME);
        currentTool.setShape(RECTANGLE_NAME, new Rectangle2D.Double());       
    }
}


