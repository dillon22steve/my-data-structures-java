package src.scenes;

import java.awt.Graphics;

import src.App;
import src.render.RenderInterface;
import src.render.hash_map.HashMapRender;
import src.render.lists.ListRender;
import src.render.queues.PriorityQueueRender;
import src.render.queues.QueueRender;
import src.render.stacks.StackRender;
import src.render.trees.BstRender;
import src.render.trees.RedBlackTreeRender;

public class Display {

    public static float opacity = 0;
    public static float opacityUpdate = 1.2F;

    public static char DataStructureType;

    private RenderInterface render;

    public Display() {
        
    } //constructor


    public void draw(Graphics g) {
        render.render(g);
    } //draw


    public void initDisplay() {
        switch (DataStructureType) {
            case 'u':
                render = new ListRender();
                break;
            case 's':
                render = new ListRender();
                break;
            case 'd':
                break;
            case 'b':
                render = new BstRender();
                break;
            case 'q':
                render = new QueueRender();
                break;
            case 't':
                render = new StackRender();
                break;
            case 'p':
                render = new PriorityQueueRender();
                break;
            case 'h':

                break;
            case 'a':

                break;
            case 'r':
                render = new RedBlackTreeRender();
                break;
            case 'm':
                render = new HashMapRender();
                break;
        } //switch

        App.opacity = 254;
    } //initDisplay


    public static void updateOpacity() {

    } //updateOpacity


    public RenderInterface getRender() {
        return render;
    } //getRender
    
} //Display
