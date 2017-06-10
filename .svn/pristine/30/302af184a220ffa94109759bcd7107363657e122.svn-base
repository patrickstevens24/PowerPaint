package actions;

import java.awt.Point;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import view.DrawingArea;
import view.Shapes;
/**
 * Abstract tool class.
 * 
 * @author Patrick Stevens
 * @version 1.0
 */
public abstract class AbstractTool extends AbstractAction implements Tool {
    
    /**
     * Auto-Generated serial ID.
     */
    private static final long serialVersionUID = 5988406131602963917L;
    /**
     * the Drawing Area.
     */
    protected DrawingArea myPanel;
    /**
     * The shape.
     */
    protected Shapes myShape;
    /**
     * The end point.
     */
    private final Point myEndPoint;
    /**
     * the Start point.
     */
    private final Point myStartPoint;
    /**
     * The tool name.
     */
    private String myName;
    
    /**
     * Constructor for AbstractTool.
     * 
     * @param theName 
     * @param theIcon 
     * @param theMnemonic 
     * @param theShape 
     */
    public AbstractTool(final String theName, final ImageIcon theIcon, 
                              final int theMnemonic, final Shapes theShape) {
        super();
        putValue(Action.NAME, theName);
        putValue(Action.SMALL_ICON, theIcon);
        putValue(Action.MNEMONIC_KEY, theMnemonic);
        putValue(Action.SELECTED_KEY, true);

        myStartPoint = new Point();
        myEndPoint = new Point();
        myShape = theShape;
        myName = theName;
    }
    /**
     * Getting the name of tool.
     */
    @Override
    public String getName() {
        return myName;
    }
    /**
     * Getting the start point of tool.
     */
    @Override
    public Point getStartPoint() {
        return myStartPoint.getLocation();
    }
    /**
     * getting the end point of tool.
     */
    @Override
    public Point getEndPoint() {
        return myEndPoint.getLocation();
    }
    /**
     * Setting the start point.
     * @param thePoint 
     */
    public void setStartPoint(final Point thePoint) {
        myStartPoint.setLocation(thePoint);
    }
    /**
     * Setting the end point.
     * @param thePoint 
     */
    protected void setEndPoint(final Point thePoint) {
        myEndPoint.setLocation(thePoint);
    }
    /**
     * Getting the shape.
     * @return myShape
     */
    public Shapes getShape() {
        return myShape;
    }
    /**
     * Setting the name.
     * @param theName 
     */
    protected void setName(final String theName) {
        myName = theName;
    }
}
