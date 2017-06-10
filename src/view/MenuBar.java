package view;

import java.awt.BasicStroke;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Class that creates the menuBar.
 * 
 * @author Patrick
 * @version 1.0
 */
public class MenuBar extends JMenuBar implements PropertyChangeListener {
    /**
     * Auto-Generated serial ID.
     */
    private static final long serialVersionUID = -4288966875105692553L;
    /**
     * The starting thickness.
     */
    private static final int INITIAL_THICK = 5;
    /**
     * The message displayed when about is clicked.
     */
    private static final String ABOUT_MESSAGE = 
                    "TCSS 305 PowerPaint\nWinter 2016\nPatrick Stevens";
    /**
     * The max thickness.
     */
    private static final int MAX_THICK = 20;
    /**
     * The min thickness.
     */
    private static final int MIN_THICK = 0;
    /**
     * The spacing for the thickness slider.
     */
    private static final int MAJOR_THICK_SPACING = 5;
    /**
     * The spacing for the thickness slider.
     */
    private static final int MINOR_THICK_SPACING = 1;
    /**
     * The buttons to be added to the menuBar.
     */
    private final ButtonGroup myShapeGroup;
    /**
     * The tool menu.
     */
    private final JMenu myToolMenu;
    /**
     * The current tool selected.
     */
    private final Shapes myCurrentTool;
    /**
     * The main frame.
     */
    private final JFrame myMainFrame;
    /**
     * The drawing area panel.
     */
    private final DrawingArea myPanel;
    /**
     * The undo Button.
     */
    private final JMenuItem  myUndoButton;

    /**
     * Constructor for the menuBar.
     * 
     * @param theTool 
     * @param theMainFrame 
     * @param thePanel 
     */
    public MenuBar(final Shapes theTool, final JFrame theMainFrame,
                   final DrawingArea thePanel) {
        super();
        myPanel = thePanel;
        myCurrentTool = theTool;
        myShapeGroup = new ButtonGroup();
        myToolMenu = new JMenu(new MenuAction("Tools", KeyEvent.VK_T));
        myMainFrame = theMainFrame;
        myUndoButton = new JMenuItem("Undo all changes");
        setup();
    }
    /**
     * Setting up the menuBar.
     */
    private void setup() {
        add(fileMenu());
        add(optionsMenu());
        add(myToolMenu);
        add(helpMenu()); 
    }
    /**
     * If the drawing area has shapes then set undo button enabled to true.
     */
    @Override
    public void propertyChange(final PropertyChangeEvent theEvent) {
        if ("undo".equals(theEvent.getPropertyName())) {
            myUndoButton.setEnabled((boolean) theEvent.getNewValue());
        }
        
    }
    /**
     * Method to create the file menu.
     * @return the file menu bar
     */
    private JMenu fileMenu() {
        final JMenu file = new JMenu(new MenuAction("File", KeyEvent.VK_F));
        final JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myMainFrame.dispatchEvent(new WindowEvent(myMainFrame,
                                                           WindowEvent.WINDOW_CLOSING));
            } 
        });
        myUndoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myPanel.setClear();
            }
        });
        file.add(myUndoButton);
        file.addSeparator();
        file.add(exit);
        return file;
    }
    /**
     * Method to create the options menu.
     * @return the options menu
     */
    private JMenu optionsMenu() {
        final JMenu options = new JMenu(new MenuAction("Options", KeyEvent.VK_O));
        final JCheckBoxMenuItem only = new JCheckBoxMenuItem(
                             new MenuAction("Square/Cirlce Only", false, KeyEvent.VK_S));
        only.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theAction) {
                myPanel.setOnly();
            }          
        });
        
        final JMenu thickness = new JMenu(new MenuAction("Thickness", KeyEvent.VK_T));
        final JSlider slider = new JSlider(MIN_THICK, MAX_THICK, INITIAL_THICK);
        slider.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(final ChangeEvent theEvent) {
                final JSlider slider = (JSlider) theEvent.getSource();
                myCurrentTool.setThick(new BasicStroke(slider.getValue()));   
            }
        });
        
        slider.setMajorTickSpacing(MAJOR_THICK_SPACING);
        slider.setMinorTickSpacing(MINOR_THICK_SPACING);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        thickness.add(slider);
        final JMenuItem color = new JMenuItem(new ColorIcon(myCurrentTool)); 
        options.add(only);
        options.addSeparator();
        options.add(thickness);
        options.addSeparator();
        options.add(color);
        return options;
    }
    /**
     * Method to create the tools menu. Adding tools to menuBar.
     * @param theAction 
     */
    public void toolsMenu(final Action theAction) {
        final JRadioButtonMenuItem item = new JRadioButtonMenuItem(theAction);
        myShapeGroup.add(item);
        myToolMenu.add(item);
    }
    /**
     * Method to create the help menu.
     * @return the help menu
     */
    private JMenu helpMenu() {
        final JMenu help = new JMenu(new MenuAction("Help", KeyEvent.VK_H));
        final JMenuItem about = new JMenuItem(new MenuAction("About...", KeyEvent.VK_A));
        about.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                try {
                    final BufferedImage img = ImageIO.read(new File("images/uw.jpg"));
                    final Image tmp = img.getScaledInstance(40, 40, 
                                                            BufferedImage.SCALE_SMOOTH);
                    JOptionPane.showMessageDialog(myMainFrame, ABOUT_MESSAGE,
                                 "About", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(tmp));
                } catch (final IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        });
        
        help.add(about);
        return help;
    }
    /**
     * The action that the menuBar does.
     * 
     * @author Patrick Stevens
     * @version 1.0
     */
    private class MenuAction extends AbstractAction {
        /**
         * Auto-Generated serial ID.
         */
        private static final long serialVersionUID = -867434452367676212L;
        /**
         * MenuAction constructor. 
         * 
         * @param theName 
         * @param theMnemonic 
         */
        MenuAction(final String theName, final int theMnemonic) {
            this(theName, true, theMnemonic);   
        }
        /**
         * MenuAction constructor for the button attributes.
         * @param theName 
         * @param theStatus 
         * @param theMnemonic 
         */
        MenuAction(final String theName, final boolean theStatus, final int theMnemonic) {
            super();
            putValue(Action.NAME, theName);
            putValue(Action.MNEMONIC_KEY, theMnemonic);
            putValue(Action.SELECTED_KEY, theStatus);   
        }
        @Override
        public void actionPerformed(final ActionEvent theArg) {
        } 
    } 
}
