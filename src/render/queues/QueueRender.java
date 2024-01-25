package src.render.queues;

import java.awt.Color;
import java.awt.Graphics;

import src.render.RenderInterface;
import src.render.StructureRender;
import src.utils.constants.FontConstants;
import src.utils.constants.ImageConstants;
import src.utils.constants.PersonConstants;
import src.data_structures.queues.Queue;
import src.gui.Panel;
import src.nodes.linked.SinglyLinkedNode;
import src.person.Person;


public class QueueRender extends StructureRender implements RenderInterface {

    Queue<Person> queue;

    private static boolean isEvenRow = false;
    private static boolean isDown = false;


    public QueueRender() {
        super();

        queue = new Queue<Person>();

        initialX = 100;
        initialY = 100;

        currY = initialY;
        currX = initialX;

        xOffset = 210;
        yOffset = 150;

        nodeWidth = 150;
        nodeHeight = 70;
    } //constructor


    @Override
    public void insertNext() {
        queue.enqueue(PersonConstants.people[insertIndex]);
        insertIndex++;
    } //insertNext


    @Override
    public void render(Graphics g) {
        if (drawStructure) {
            drawQueue(g);
            disableRendering();
        } else {
            renderInsertText(g);
        } //if
    } //render


    private void drawQueue(Graphics g) {
        SinglyLinkedNode<Person> temp = queue.getRear();

        drawRear(g);
        while (temp != null) {
            g.drawImage(ImageConstants.NodeImage, currX, currY, nodeWidth, nodeHeight, null);

            g.setFont(FontConstants.NODE_TEXT_FONT);
            g.setColor(Color.WHITE);
            g.drawString(("Name: " + temp.getData().getName()), currX + 10, currY + 15);
            g.drawString(("Age: " + temp.getData().getAge()), currX + 10, currY + 40);

            if (temp.getNext() == null) {
                drawFront(g, currX, currY);
            } //if

            drawLines(g);

            currX = calculateNewX(currX);

            temp = temp.getNext();
        } //while

        currX = initialX;
        currY = initialY;
        isEvenRow = false;
        isDown = false;
    } //drawQueue




    private int calculateNewX(int origX) {
        if (!isEvenRow) {
            int newX = origX + xOffset;
            if ((newX) > (Panel.SCREEN_WIDTH - 250)) {
                isEvenRow = true;

                currY = currY + yOffset;
                return origX;
            } else {
                if ((newX + xOffset) > (Panel.SCREEN_WIDTH - 250)) isDown = true;
                return newX;
            } //if
        } else {
            int newX = origX - xOffset;
            if (newX < initialX) {
                isEvenRow = false;
                
                currY = currY + yOffset;
                return origX;
            } else {
                if ((newX - xOffset) < initialX) isDown = true;
                return newX;
            } //if
        } //if
    }


    private void drawLines(Graphics g) {
        int startY, endY, startX, endX;
        if (!isDown) {
            startY = endY = currY + 28;
            if (isEvenRow) {
                startX = currX - 55;
                endX = currX - 5;
                g.drawLine(startX, startY , endX, endY);
            } else {
                startX = currX + 155;
                endX = currX + 205;
                g.drawLine((currX + 155), (currY + 28), (currX + 205), (currY + 28));
            } //if
        } else {
            startY = currY + 75;
            endY = startY + 70;
            startX = endX = currX + 68;
            g.drawLine(startX, startY, endX, endY);
            isDown = false;
        } //if
    } //drawLines


    private void drawFront(Graphics g, int nodeX, int nodeY) {
        g.setColor(Color.GREEN);
        g.drawString("Front", (nodeX + (nodeWidth / 3)), (nodeY - 20));
    } //drawFront


    private void drawRear(Graphics g) {
        g.setColor(Color.GREEN);
        g.drawString("Rear", (initialX + (nodeWidth / 3)), (initialY - 20));
    } //drawRear
    
} //QueueRender
