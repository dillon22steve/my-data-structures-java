package src.scenes;

import java.awt.Graphics;

import src.App;
import src.gui.Panel;
import src.gui.controls.bars.SelectionMenuBar;


public class SelectionMenu {

    private SelectionMenuBar menuBar;

    public SelectionMenu(App app) {
        menuBar = new SelectionMenuBar(Panel.SCREEN_WIDTH, Panel.SCREEN_HEIGHT, 0, 0, app);
    } //constructor


    public void update() {
        App.UpdateOpacity();
    } //update


    public void draw(Graphics g) {
        menuBar.draw(g);
    } //draw



    public void mouseWheelMoved(int wheelRotation) {
        menuBar.mouseWheelMoved(wheelRotation);
    } //mouseWheelMoved


    public void mouseMoved(int x, int y) {
        menuBar.mouseMoved(x, y);
    } //mouseMoved


    public void mouseClicked(int x, int y) {
        menuBar.mouseClicked(x, y);
    } //mouseClicked


    public void mousePressed(int x, int y) {
        menuBar.mousePressed(x, y);
    } //mousePressed


    public void keyPressed(int keyCode) {
        menuBar.keyPressed(keyCode);
    } //keyPressed

} //SelectionMenu
