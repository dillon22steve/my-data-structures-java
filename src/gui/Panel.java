package src.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JPanel;

import src.App;
import src.gui.inputs.*;
import src.scenes.Scenes;


public class Panel extends JPanel {

    private App app;

    public static int SCREEN_WIDTH;
    public static int SCREEN_HEIGHT;
    private Dimension screenSize;

    private KeyboardInputs keyboardInputs;
    private MouseInputs mouseInputs;


    public Panel(App app) {
        this.app = app;
        setPanelSize();
        this.setBackground(Color.BLACK);
    } //constructor

    public void initInputs() {
        this.mouseInputs = new MouseInputs(app);
        this.keyboardInputs = new KeyboardInputs(app);

        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
        addMouseWheelListener(mouseInputs);
        addKeyListener(keyboardInputs);

        requestFocus();
    } //initInputs

    private void setPanelSize() {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        SCREEN_WIDTH = (int)screenSize.getWidth();
        SCREEN_HEIGHT = (int)screenSize.getHeight();

        setMinimumSize(screenSize);
        setPreferredSize(screenSize);
    } //setPanelSize


    public void update() {
        switch (Scenes.CurrentScene) {
            case Scenes.SELECTION_MENU:
                app.getSelectionMenu().update();
                break;
            case Scenes.DATA_INPUT:
                break;
            case Scenes.DISPLAY:
                break;
            case Scenes.PAUSE_MENU:
                break;
        } //switch
    } //update


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        switch (Scenes.CurrentScene) {
            case Scenes.SELECTION_MENU:
                app.getSelectionMenu().draw(g);
                break;
            case Scenes.DATA_INPUT:
                break;
            case Scenes.DISPLAY:
                app.getDisplay().draw(g);
                break;
            case Scenes.PAUSE_MENU:
                break;
        } //switch
    } //paintComponent
    
} //Panel
