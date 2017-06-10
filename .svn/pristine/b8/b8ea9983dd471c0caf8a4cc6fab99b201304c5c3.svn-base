package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.event.MouseInputAdapter;
/**
 * Class that creates the panel for the drawing area.
 * 
 * @author Patrick Stevens
 * @version 1.0
 */
public class DrawingArea extends JPanel {

    /**
     * Auto-Generated serial ID.
     */
    private static final long serialVersionUID = -6299431629309349243L;
    /**
     * The panel dimension.
     */
    private static final Dimension PANEL_SIZE = new Dimension(500, 300);
    /**
     * The string for undo.
     */
    private static final String UNDO = "undo";
    /**
     * The name of the rectangle tool.
     */
    private static final String RECTANGLE_NAME = "rectangle";
    /**
     * The name of the Ellipse tool.
     */
    private static final String ELLIPSE_NAME = "ellipse";
    /**
     * The name of the Line tool.
     */
    private static final String LINE_NAME = "line";
    /**
     * The name of the Pencil tool.
     */
    private static final String PENCIL_NAME = "pencil";
    /**
     * List of the current shapes on the drawing area.
     */
    private List<Shapes> myCurrentShapes;
    /**
     * The current tool that is selected.
     */
    private final Shapes myCurrentTool;
    /**
     * If the button square/circle is selected.
     */
    private boolean mySquareCircle;
    

    /**
     * Constructor for the Drawing area.
     * 
     * @param theShapeTool 
     */
    public DrawingArea(final Shapes theShapeTool) {
        super();
        myCurrentShapes = new ArrayList<Shapes>();
        myCurrentTool = theShapeTool;
        mySquareCircle = false;
        setup();
    }
    /**
     * Method that sets up the drawing area.
     */
    private void setup() {
        final DrawingListener listen = new DrawingListener();
        addMouseMotionListener(listen);
        addMouseListener(listen);
        setPreferredSize(PANEL_SIZE);
        setBackground(Color.WHITE);
        
        //Cursor to crosshair
        final Cursor cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
        setCursor(cursor);
    }  
    /**
     * Paint component displays the shapes on the panel.
     * 
     * @param theGraphics 
     */
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        
        final Graphics2D g2d = (Graphics2D) theGraphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
                             RenderingHints.VALUE_ANTIALIAS_ON);
        
        //Fires if there are shapes in myCurrent Shapes.
        firePropertyChange(UNDO, myCurrentShapes.isEmpty(), !myCurrentShapes.isEmpty());
        
        //Displays the shapes
        for (final Shapes s : myCurrentShapes) {
            g2d.setStroke(s.getThick());
            g2d.setPaint(s.getColor());
            g2d.draw(s.getShape());
        }
    }
    /**
     * Method to clear the panel of shapes.
     */
    public void setClear() {
        
        firePropertyChange(UNDO, null, false);
        myCurrentShapes = new ArrayList<Shapes>();
        repaint();
    }
    /**
     * Method to set the square and circle to true.
     */
    protected void setOnly() {
        mySquareCircle = true;
        
    }
    /**
     * Method that sets up the frame for the rectangle.
     * 
     * @param theStart 
     * @param theEnd 
     * @return new rectangle
     */
    private Rectangle2D.Double rectangleFrame(final Point theStart, final Point theEnd) {
        final int x;
        final int y;
        final int width;
        final int height;
        
        if (!mySquareCircle) {
            x = (int) Math.min(theStart.getX(), theEnd.getX());
            y = (int) Math.min(theStart.getY(), theEnd.getY());
            width = (int) Math.abs(theStart.getX() - theEnd.getX());
            height = (int) Math.abs(theStart.getY() - theEnd.getY());
     
        } else {
            x = (int) Math.min(theStart.getX(), theEnd.getX());
            y = (int) Math.min(theStart.getY(), theEnd.getY());
            
            final int h = (int) Math.abs(theStart.getY() - theEnd.getY());
            final int w = (int) Math.abs(theStart.getX() - theEnd.getX());
            
            height = (int) Math.max(w, h);
            width = (int) Math.max(w, h);
  
        }
        return new Rectangle2D.Double(x, y, width, height);

    }
    /**
     * Class for the mouse listeners.
     * 
     * @author Patrick
     * @version 1.0
     */
    private class DrawingListener extends MouseInputAdapter {
       /**
        * Mouse dragged method for drawing the shapes.
        */
        @Override
        public void mouseDragged(final MouseEvent theEvent) {
            final Shape currentShape = myCurrentTool.getShape();
            final Point end = new Point(theEvent.getX(), theEvent.getY());
            if (myCurrentTool.getName() == LINE_NAME) {
                ((Line2D.Double) currentShape).setLine(
                                  new Line2D.Double(myCurrentTool.getStartPoint(), end));
            } else if (myCurrentTool.getName() == PENCIL_NAME) {
                ((GeneralPath) currentShape).lineTo(theEvent.getX(), theEvent.getY());
            } else if (myCurrentTool.getName() == RECTANGLE_NAME) {
                ((RectangularShape) currentShape).setFrame(rectangleFrame(
                                           myCurrentTool.getStartPoint(), end));
            } else if (ELLIPSE_NAME.equals(myCurrentTool.getName())) {
                ((Ellipse2D.Double) currentShape).setFrame(rectangleFrame(
                                           myCurrentTool.getStartPoint(), end));
            }
            myCurrentShapes.remove(myCurrentShapes.size() - 1);
            myCurrentShapes.add(myCurrentTool);
            repaint();
        }
        /**
         * Mouse pressed method for when the mouse is pressed.
         */
        @Override
        public void mousePressed(final MouseEvent theEvent) {
            final Point start1 = new Point(theEvent.getPoint());
            final Shape currentShape = myCurrentTool.getShape();
            myCurrentTool.setStartPoint(new Point(start1.x, start1.y));
            
            if (LINE_NAME.equals(myCurrentTool.getName())) {
                ((Line2D.Double) currentShape).setLine(start1, start1);
            } else if (PENCIL_NAME.equals(myCurrentTool.getName())) {
                myCurrentTool.setShape(PENCIL_NAME, new GeneralPath());
                ((GeneralPath) myCurrentTool.getShape()).moveTo(start1.x, start1.y);
            } else if (RECTANGLE_NAME.equals(myCurrentTool.getName())) {
                ((RectangularShape) currentShape).setFrame(new Rectangle2D.Double(
                                                              start1.x, start1.y, 0, 0));
            } else if (ELLIPSE_NAME.equals(myCurrentTool.getName())) {
                ((Ellipse2D.Double) currentShape).setFrame(new Rectangle2D.Double(
                                                              start1.x, start1.y, 0, 0));
            }
            myCurrentShapes.add(myCurrentTool);
            repaint();
        }
        /**
         * Mouse released method for when the mouse is released.
         * @param theEvent 
         */
        public void mouseReleased(final MouseEvent theEvent) { 
            myCurrentShapes.remove(myCurrentShapes.size() - 1);
            myCurrentShapes.add(new Shapes(myCurrentTool));
            repaint();
        }        
    }
}

