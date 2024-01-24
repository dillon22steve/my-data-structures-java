package src.gui.controls.bars;

import java.awt.Color;
import java.awt.Graphics;

import src.App;
import src.gui.controls.buttons.Button;
import src.utils.constants.KeyboardConstants;


public class ButtonBar {

    protected int width, height, xPos, yPos;
    protected Button[] buttons;
    protected int selectedIndex;
    protected App app;

    public ButtonBar(int width, int height, int xPos, int yPos, App app) {
        this. width = width;
        this. height = height;
        this.xPos = xPos;
        this.yPos = yPos;
        this.app = app;
    } //constructor


    public void draw(Graphics g) {
        g.drawRect(xPos, yPos, width, height);

        for (int i = 0; i < buttons.length; i++) {
            if (selectedIndex == i) {
                g.setColor(new Color(255, 255, 255, (int)App.opacity));
            } else {
                g.setColor(Color.WHITE);
            } //if

            buttons[i].draw(g);
        } //for
    } //draw


    public void keyPressed(int keyCode) {
        switch(keyCode) {
            case KeyboardConstants.UP:
                updateSelection('u');
                break;
            case KeyboardConstants.LEFT:
                updateSelection('l');
                break;
            case KeyboardConstants.RIGHT:
                updateSelection('r');
                break;
            case KeyboardConstants.DOWN:
                updateSelection('d');
                break;
            case KeyboardConstants.ENTER:
                selectHandler();
                break;
        } //switch
    } //keyPressed


    public void mouseWheelMoved(int wheelRotation) {
        if (wheelRotation < 0) {
            updateSelection('u');
        } else {
            updateSelection('d');
        } //if
    } //mouseWheelMoved


    private void updateSelection(char dir) {
        switch (dir) {
            case 'u':
                if (selectedIndex == 0) selectedIndex = 10;
                else if (selectedIndex == 1) selectedIndex = 9;
                else selectedIndex = selectedIndex - 2;
                break;
            case 'l':
                if (selectedIndex % 2 == 1) selectedIndex--;
                else if (selectedIndex == 10);
                else selectedIndex++;
                break;
            case 'r':
                if (selectedIndex % 2 == 1) selectedIndex--;
                else if (selectedIndex == 10);
                else selectedIndex++;
                break;
            case 'd':
                if (selectedIndex == 10) selectedIndex = 0;
                else if (selectedIndex == 9) selectedIndex = 1;
                else selectedIndex = selectedIndex + 2;
                break;
        } //switch
    } //updateSelection


    public void mouseMoved(int mouseX, int mouseY) {
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].getBounds().contains(mouseX, mouseY)) {
                selectedIndex = i;
            } //if
        } //for
    } //mouseMoved


    public void mouseClicked(int mouseX, int mouseY) {
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].getBounds().contains(mouseX, mouseY)) {
                selectHandler();
            } //if
        } //for
    } //mouseClicked


    public void mousePressed(int mouseX, int mouseY) {
        for (int i = 0; i < buttons.length; i++) {
            if (buttons[i].getBounds().contains(mouseX, mouseY)) {
                selectHandler();
            } //if
        } //for
    } //mousePressed


    void selectHandler() {
        //This method will be overridden by child classes
    } //selectHandler
    
} //ButtonBar