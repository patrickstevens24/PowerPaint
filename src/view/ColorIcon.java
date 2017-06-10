package view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;

/**
 * Class that sets up the color icon.
 * 
 * @author Patrick Stevens
 * @version 1.0
 */
public class ColorIcon extends AbstractAction {
    /**
     * Auto-Generated serial ID.
     */
    private static final long serialVersionUID = -5996470432860913796L;
    /**
     * Default icon width.
     */
    private static final int WIDTH = 15;
    /**
     * Default icon height.
     */
    private static final int HEIGHT = 15;
    /**
     * The tool that is currently selected.
     */
    private final Shapes myCurrentTool;
    /**
     * Constructor the the color icon.
     * @param theTool 
     */
    public ColorIcon(final Shapes theTool) {
        super();
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_C);
        putValue(Action.NAME, "Color...");
        final Color purp = new Color(51, 0, 111);
        putValue(Action.SMALL_ICON, getIcon(purp));
        
        myCurrentTool = theTool;
    }
    /**
     * The action the color icon performs.
     */
    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        final Color result = JColorChooser.showDialog(
                                     null , "Color Chooser", myCurrentTool.getColor());
        if (result != null) {
            putValue(Action.SMALL_ICON, getIcon(result));
            myCurrentTool.setColor(result);
        }
    }
    /**
     * Method for creating the small color icon.
     * 
     * @param theColor 
     * @return ImageIcon 
     */
    private static ImageIcon getIcon(final Color theColor) {
        final BufferedImage image = new BufferedImage(
                               WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        final Graphics2D g2d = (Graphics2D) image.getGraphics();
        g2d.setPaint(theColor);
        g2d.fill(new Rectangle2D.Double(1, 1, WIDTH, HEIGHT));
        return new ImageIcon(image);
    }
}
