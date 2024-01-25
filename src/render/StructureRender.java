package src.render;

import java.awt.Graphics;

import src.App;
import src.utils.HelperMethods;
import src.utils.constants.PersonConstants;

public class StructureRender {

    protected static long now = System.nanoTime();
    protected static long last = now;
    protected static double timePerDraw = 7_000_000_000.0;

    protected static float opacityUpdate = 0.8f;

    protected int initialX, initialY;
    protected int currY, currX;
    protected int xOffset, yOffset;

    protected int nodeWidth, nodeHeight;

    protected int insertIndex;

    protected boolean drawStructure;


    public StructureRender() {
        insertIndex = 0;
        drawStructure = false;
    } //StructureRender


    public void update() {
        if (!drawStructure) {
            if (App.opacity > 0) {
                App.opacity = App.opacity - opacityUpdate;
            } else {
                App.opacity = 254;
                insertNext();
                
                drawStructure = true;
            } //if
        } else {
            now = System.nanoTime();
            if ((now - last) > timePerDraw) {
                App.opacity = 254;
                last = now;
                drawStructure = false;

                enableRendering();
            } //if
        } //if


        if ((int)App.opacity > 255) {
            App.opacity = 254;
        } //if
    } //update


    protected void renderInsertText(Graphics g) {
        if (insertIndex >= PersonConstants.people.length) {
                System.exit(0);
            } //if
            String name = PersonConstants.people[insertIndex].getName();
            HelperMethods.drawInsertedName(g, name);
    } //renderInsertText


    public void insertNext() {
        //This will be overridden by the child classes
    } //insertNext


    public void enableRendering() {
        App.draw = true;
    } //setDrawToTrue
    public void disableRendering() {
        App.draw = false;
    } //disableDrawing
    
} //StructureRender
