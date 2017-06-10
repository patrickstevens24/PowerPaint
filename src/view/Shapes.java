package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.RectangularShape;
/**
 * Class that hold and create shapes.
 * 
 * @author Patrick Stevens
 * @version 1.0
 */
public final class Shapes {
    /**
     * The thickness of shape.
     */
    private Stroke myThickness;
    /**
     * The color of shape.
     */
    private Color myColor;
    /**
     * The shape.
     */
    private Shape myShape;
    /**
     * The start point.
     */
    private Point myStartPoint;
    /**
     * The name of shape.
     */
    private String myName;
    /**
     * Constructor for Shapes.
     * 
     * @param theShape 
     * @param theName 
     * @param theThick 
     * @param theColor 
     * @param theStartPoint 
     */
    public Shapes(final Shape theShape, final String theName, final Stroke theThick, 
                     final Color theColor, final Point theStartPoint) {
        myName = theName;
        setShape(theName, theShape);
        myColor = theColor;
        myThickness = theThick;
        myStartPoint = theStartPoint;
    }
    /**
     * Constructor for shapes.
     * @param theTool 
     */
    public Shapes(final Shapes theTool) {
        this(theTool.getShape(), theTool.getName(), theTool.getThick(),
             theTool.getColor(), theTool.getStartPoint());
    }
    /**
     * Getting the color.
     * @return myColor
     */
    protected Color getColor() {
        return myColor;
    }
    /**
     * Getting the name.
     * @return theName 
     */
    protected String getName() {
        return myName;
    }
    /**
     * Setting the name.
     * @param theName 
     */
    public void setName(final String theName) {
        myName = theName;
    }
    /**
     * Getting the thickness.
     * @return myThickness
     */
    protected Stroke getThick() {
        return myThickness;
    }
    /**
     * Getting the shape.
     * @return myShape
     */
    protected Shape getShape() {
        return myShape;
    }
    /**
     * Setting the thickness.
     * @param theThick 
     */
    public void setThick(final BasicStroke theThick) {
        final Stroke pls = new BasicStroke(0);
        if (theThick.equals(pls)) { 
            setColor(Color.WHITE);
            myThickness = theThick;
        } else {
            myThickness = theThick;
        }
        
    }
    /**
     * Setting the color.
     * @param theColor 
     */
    public void setColor(final Color theColor) {
        myColor = theColor;
        
    }
    /**
     * Setting the Shape.
     * @param theName 
     * @param theShape 
     */
    public void setShape(final String theName, final Shape theShape) {
        if ("line".equals(myName)) {
            myShape = (Shape) ((Line2D.Double) theShape).clone();
        } else if ("pencil".equals(myName)) {
            myShape = (Shape) ((GeneralPath) theShape).clone();
        } else if ("rectangle".equals(myName)) {
            myShape = (Shape) ((RectangularShape) theShape).clone();
        } else if ("ellipse".equals(myName)) {
            myShape = (Shape) ((Ellipse2D.Double) theShape).clone();
        }
    }
    /**
     * Getting the start point.
     * @return theStartPoint
     */
    public Point getStartPoint() {
        return myStartPoint;
    }
    /**
     * Setting the start point.
     * @param thePoint 
     */
    public void setStartPoint(final Point thePoint) {
        myStartPoint = thePoint;
        
    }
}

