package actions;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Line2D;

import javax.swing.ImageIcon;

import view.Shapes;
/**
 * Creates a Line tool.
 * 
 * @author Patrick Stevens
 * @version 1.0
 */
public final class Line extends AbstractTool {
    /**
     * Auto-Generated serial ID.
     */
    private static final long serialVersionUID = 3016595312247435381L;
    /**
     * The line name.
     */
    private static final String LINE_NAME = "line";
    /**
     * Constructor for the line.
     * 
     * @param theShape 
     */
    public Line(final Shapes theShape) {
        super("Line", new ImageIcon("images/line.gif"), 
              KeyEvent.VK_L, theShape);
    }
    /**
     * Action that the line does.
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        final Shapes currentTool = getShape();
        currentTool.setName(LINE_NAME);
        currentTool.setShape(LINE_NAME, new Line2D.Double());
        currentTool.setStartPoint(new Point());
    }

}
