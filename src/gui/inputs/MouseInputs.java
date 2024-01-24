package src.gui.inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import src.App;
import src.scenes.Scenes;


public class MouseInputs implements MouseListener, MouseMotionListener, MouseWheelListener {

    private App app;


    public MouseInputs(App app) {
        this.app = app;
    } //constructor


    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {

        switch (Scenes.CurrentScene) {
            case (Scenes.SELECTION_MENU):
                app.getSelectionMenu().mouseWheelMoved(e.getWheelRotation());
                break;
            case (Scenes.DATA_INPUT):
                break;
            case (Scenes.DISPLAY):
                break;
            case (Scenes.PAUSE_MENU):
                break;
        } //switch
        
    } //mouseWheelMoved

    @Override
    public void mouseDragged(MouseEvent e) {
        
    } //mouseDragged

    @Override
    public void mouseMoved(MouseEvent e) {
        switch (Scenes.CurrentScene) {
            case (Scenes.SELECTION_MENU):
                app.getSelectionMenu().mouseMoved(e.getX(), e.getY());
                break;
            case (Scenes.DATA_INPUT):
                break;
            case (Scenes.DISPLAY):
                break;
            case (Scenes.PAUSE_MENU):
                break;
        } //switch
    } //mouseMoved

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (Scenes.CurrentScene) {
            case (Scenes.SELECTION_MENU):
                app.getSelectionMenu().mouseClicked(e.getX(), e.getY());
                break;
            case (Scenes.DATA_INPUT):
                break;
            case (Scenes.DISPLAY):
                break;
            case (Scenes.PAUSE_MENU):
                break;
        } //switch
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (Scenes.CurrentScene) {
            case (Scenes.SELECTION_MENU):
                app.getSelectionMenu().mousePressed(e.getX(), e.getY());
                break;
            case (Scenes.DATA_INPUT):
                break;
            case (Scenes.DISPLAY):
                break;
            case (Scenes.PAUSE_MENU):
                break;
        } //switch
    } //mouseClicked

    @Override
    public void mouseReleased(MouseEvent e) {
        
    } //mouseReleased

    @Override
    public void mouseEntered(MouseEvent e) {
        
    } //mouseEntered

    @Override
    public void mouseExited(MouseEvent e) {
        
    } //mouseExited
    
} //MouseInputs
