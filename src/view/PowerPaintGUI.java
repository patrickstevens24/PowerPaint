package view;

import actions.Ellipse;
import actions.Line;
import actions.Pencil;
import actions.Rectangle;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.geom.GeneralPath;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFrame;



/**
 * GUI class that sets up the frame with all the components. 
 * 
 * @author Patrick Stevens
 * @version 1.0
 */
public class PowerPaintGUI {

    /** The default width of the frame. */
    public static final int DEFAULT_WIDTH = 500;

    /** The default height of the frame. */
    public static final int DEFAULT_HEIGHT = 400;

    /**
     * Constructor for the GUI that calls the start method.
     */
    public PowerPaintGUI() {
        start();
    }
    
    /**
     * Start method sets up all the components.
     */
    private void start() {
        //The main frame
        final JFrame mainFrame = new JFrame("PowerPaint");
        mainFrame.setIconImage(new ImageIcon("images/uw.jpg").getImage());
        
        //Starting UW Purple color
        final Color purp = new Color(51, 0, 111);
        
        //Starting default tool selected
        final Shapes defaultPencil = new Shapes(new GeneralPath(), 
                                            "pencil",  new BasicStroke(5), purp, new Point());
        final Action[] shape = {new Pencil(defaultPencil), new Line(defaultPencil),
            new Rectangle(defaultPencil), new Ellipse(defaultPencil)};
       
        final DrawingArea drawingArea = new DrawingArea(defaultPencil);
        final ToolBar toolbar = new ToolBar();
        final MenuBar menuBar = new MenuBar(defaultPencil, mainFrame, drawingArea);
        
        //Adding the action tools to the toolBar and the menuBar
        for (final Action a : shape) {
            toolbar.createToolBarButton(a);
            menuBar.toolsMenu(a);
        }
        //Adding property change listener to the menuBar.
        drawingArea.addPropertyChangeListener(menuBar);

        mainFrame.add(drawingArea, BorderLayout.CENTER);
        mainFrame.setJMenuBar(menuBar);
        mainFrame.add(toolbar, BorderLayout.SOUTH);
        mainFrame.setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
