package src.render.hash_map;

import java.awt.Color;
import java.awt.Graphics;

import src.data_structures.hash_maps.HashMap;
import src.gui.Panel;
import src.nodes.hash_map.HashMapNode;
import src.render.RenderInterface;
import src.render.StructureRender;
import src.utils.constants.FontConstants;
import src.utils.constants.ImageConstants;
import src.utils.constants.PersonConstants;


public class HashMapRender extends StructureRender implements RenderInterface {

    private HashMap map;
    private int arrayBlockHeight;

    public HashMapRender() {
        super();

        map = new HashMap(50);

        initialX = 100;
        initialY = 50;
        currX = initialX + 300;
        currY = initialY;

        nodeWidth = 120;
        nodeHeight = 30;

        arrayBlockHeight = (Panel.SCREEN_HEIGHT - 100) / 50;
    } //constructor


    @Override
    public void insertNext() {
        map.insert(PersonConstants.people[insertIndex]);
        insertIndex++;
    } //insertNext


    @Override
    public void render(Graphics g) {
        if (drawStructure) {
            drawMap(g);
            disableRendering();
        } else {
            renderInsertText(g);
        } //if
    } //render


    private void drawMap(Graphics g) {
        g.setFont(FontConstants.NODE_TEXT_FONT);
        g.setColor(Color.WHITE);

        drawArray(g);
    } //drawMap


    private void drawArray(Graphics g) {
        for (int i = 0; i < 50; i++) {
            currY = initialY + (i * arrayBlockHeight);
            g.drawRect(initialX, currY, nodeWidth, arrayBlockHeight);
            g.drawString(("" + i), initialX + 55, currY + 10);

            if (map.get(i) != null) {
                drawChain(g, i, currY);
            } //if
        } //for

        currY = initialY;
    } //drawArray


    private void drawChain(Graphics g, int index, int y) {
        HashMapNode temp = map.get(index);
        int lineStart = (initialX + nodeWidth - 15);
        int lineEnd = (lineStart + nodeWidth);

        if (index % 2 == 0) {
            lineEnd = (lineEnd + nodeWidth);
        } //if

        y = y + (arrayBlockHeight / 2);

        while (temp != null) {
            g.drawLine(lineStart, y, lineEnd, y);

            g.drawImage(ImageConstants.NodeImage, lineEnd, (y - (nodeHeight / 2)), nodeWidth, nodeHeight, null);
        
            String name = temp.getData().getName();
            g.drawString((name + ", index: " + index), lineEnd + 5, y);

            lineStart = lineEnd + nodeWidth;
            lineEnd = lineStart + nodeWidth;
            temp = temp.getNext();
        } //while
    } //drawChain
    
} //HashMapRender
