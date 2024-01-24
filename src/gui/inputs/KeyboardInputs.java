package src.gui.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import src.App;
import src.scenes.Scenes;

public class KeyboardInputs implements KeyListener {

    private App app;

    public KeyboardInputs(App app) {
        this.app = app;
    } //constructor


    @Override
    public void keyTyped(KeyEvent e) {
        
    } //keyTyped


    
    @Override
    public void keyPressed(KeyEvent e) {

        switch (Scenes.CurrentScene) {
            case (Scenes.SELECTION_MENU):
                app.getSelectionMenu().keyPressed(e.getKeyCode());
                break;
            case (Scenes.DATA_INPUT):
                break;
            case (Scenes.DISPLAY):
                break;
            case (Scenes.PAUSE_MENU):
                break;
        } //switch
        
    } //keyPressed



    @Override
    public void keyReleased(KeyEvent e) {
        
    } //keyReleased
    
} //KeyboardInputs
