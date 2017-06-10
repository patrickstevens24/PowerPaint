package actions;

import java.awt.Point;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.ImageIcon;

import view.Shapes;

/**
 * Creates a Ellipse.
 * 
 * @author Patrick Stevens
 * @version 1.0
 *
 */
public class Ellipse extends AbstractTool {


    /**
     * Auto-Generated serial ID.
     */
    private static final long serialVersionUID = 2028771901776672737L;
    /**
     * The shape name.
     */
    private static final String ELLIPSE_NAME = "ellipse";
    /**
     * Constructor for the ellipse.
     * 
     * @param theShape 
     */
    public Ellipse(final Shapes theShape) {
        super("Ellipse", new ImageIcon("images/ellipse.gif"), 
              KeyEvent.VK_E, theShape);
    }
    /**
     * The action that the ellipse does.
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        final Shapes currentTool = getShape();
        currentTool.setName(ELLIPSE_NAME);
        currentTool.setShape(ELLIPSE_NAME, new Ellipse2D.Double());
        currentTool.setStartPoint(new Point());
    }


}


