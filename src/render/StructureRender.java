package src.render;

import src.App;

public class StructureRender {

    private static long now = System.nanoTime();
    private static long last = now;
    private static double timePerDraw = 7_000_000_000.0;

    private static float opacityUpdate = 0.8f;

    protected int initialX, initialY;
    protected int currY, currX;
    protected int xOffset, yOffset;

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
            } //if
        } //if


        if ((int)App.opacity > 255) {
            App.opacity = 254;
        } //if
    } //update


    public void insertNext() {
        //This will be overridden by the child classes
    } //insertNext
    
} //StructureRender
