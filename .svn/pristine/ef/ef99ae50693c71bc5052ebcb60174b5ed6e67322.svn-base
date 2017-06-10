package main;

import java.awt.EventQueue;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import view.PowerPaintGUI;

/**
 * Main class for PowerPaint.
 * 
 * @author Patrick Stevens
 * @version 1.0
 */
public final class PowerPaintMain {
    /**
     * PowerPaint constructor.
     */
    private PowerPaintMain() {
    }
    /**
     * The main method for powerPaint which sets the look and feel.
     * @param theArgs 
     */
    public static void main(final String[] theArgs) {
        try {  
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (final UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (final IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (final InstantiationException ex) {
            ex.printStackTrace();
        } catch (final ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PowerPaintGUI();
            }
        });
    }
}
