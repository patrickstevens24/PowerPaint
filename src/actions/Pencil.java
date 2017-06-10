package actions;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.GeneralPath;

import javax.swing.ImageIcon;

import view.Shapes;

/**
 * Creates a pencil tool.
 * 
 * @author Patrick Stevens
 * @version 1.0
 */
public class Pencil extends AbstractTool {

    /**
     * Auto-Generated serial ID.
     */
    private static final long serialVersionUID = 2028771901776672737L;
    /**
     * The name of the pencil tool.
     */
    private static final String PENCIL_NAME = "pencil";
    /**
     * Constructor for the pencil.
     * @param theShape 
     */
    public Pencil(final Shapes theShape) {
        super("Pencil", new ImageIcon("images/pencil.gif"), KeyEvent.VK_P, theShape);
    }
    
    /**
     * the action the pencil does.
     * @param theEvent 
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        final Shapes currentTool = getShape();
        currentTool.setName(PENCIL_NAME);
        currentTool.setShape(PENCIL_NAME, new GeneralPath());
        currentTool.setStartPoint(new Point());
        
    }

}
