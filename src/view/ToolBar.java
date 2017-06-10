package view;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * Creates a toolBar for the drawing area.
 * 
 * @author Patrick Stevens
 * @version 1.0
 *
 */
public class ToolBar extends JToolBar {
    /**
     * Auto-Generated serial ID.
     */
    private static final long serialVersionUID = 4268951943328073987L;
    /**
     * The group of buttons being put on the toolBar.
     */
    private final ButtonGroup myGroup;
    /**
     * Constructs a toolBar.
     */
    public ToolBar() {
        super();
        myGroup = new ButtonGroup();
    }
    /**
     * Method that adds the buttons to the toolBar.
     * 
     * @param theAction 
     */
    public void createToolBarButton(final Action theAction) {
        final JToggleButton toggleButton = new JToggleButton(theAction);
        myGroup.add(toggleButton);
        myGroup.clearSelection();
        add(toggleButton);
    }
}
