package src.gui.controls.buttons;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Button extends Rectangle {

    private String text;
    private char structureType;


    public Button(int x, int y, int width, int height, String text, char structureType) {
        super(x, y, width, height);

        this.structureType = structureType;
        this.text = text;
    } //constructor


    public void draw(Graphics g) {
        g.drawRect(x, y, width, height);
        drawText(g);
    } //draw


    private void drawText(Graphics g) {
        g.setFont(new Font("Bookman Old Style", Font.PLAIN, 24));
        
        int textX = this.x + (this.width / 10);
        int textY = this.y + (this.height / 10);
        g.drawString(text, textX, textY);
    } //drawText


    public String getText() {
        return this.text;
    } //getText
    public void setText(String text) {
        this.text = text;
    } //setText

    public char getStructureType() {
        return structureType;
    } //getStructureType
    
} //Button
