package src.render.queues;

import java.awt.Color;
import java.awt.Graphics;

import src.data_structures.heaps.Heap;
import src.data_structures.queues.PriorityQueue;
import src.gui.Panel;
import src.person.Person;
import src.render.RenderInterface;
import src.render.StructureRender;
import src.utils.constants.FontConstants;
import src.utils.constants.ImageConstants;
import src.utils.constants.PersonConstants;


public class PriorityQueueRender extends StructureRender implements RenderInterface {

    private static boolean isEvenRow = false;
    private static boolean isDown = false;

    PriorityQueue<Person> queue;
    Heap<Person> heap;


    public PriorityQueueRender() {
        super();

        queue = new PriorityQueue<Person>(PersonConstants.people.length);
        heap = queue.getHeap();

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
    }  //insertNext


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
        int parent = insertIndex - 1;

        while (parent > 0) {
            int leftChild = heap.getLeftChild(parent);
            int rightChild = heap.getRightChild(parent);

            if (leftChild < heap.getArray().size()) {
                drawNode(g, heap.getArray().get(leftChild));
            } //if
            if (rightChild < heap.getArray().size()) {
                drawNode(g, heap.getArray().get(rightChild));
            } //if

            parent = parent - 1;
        } //while

        drawRoot(g);

        currX = initialX;
        currY = initialY;
        isEvenRow = false;
        isDown = false;
    } //drawQueue


    private void drawRoot(Graphics g) {
        if (heap.getArray().size() > 2) {
            drawNode(g, heap.getArray().get(2));
        } //if
        if (heap.getArray().size() > 1) {
            drawNode(g, heap.getArray().get(1));
        } //if
        System.out.print("\n");

        drawPriority(g);
        drawNode(g, heap.getArray().get(0));
    } //drawRoot


    private void drawPriority(Graphics g) {
        g.setFont(FontConstants.NODE_TEXT_FONT);
        g.setColor(Color.GREEN);
        g.drawString("Highest priority", (currX + (nodeWidth / 4)), (currY - 20));
    } //drawPriority


    private void drawNode(Graphics g, Person person) {
        g.drawImage(ImageConstants.NodeImage, currX, currY, nodeWidth, nodeHeight, null);

        g.setFont(FontConstants.NODE_TEXT_FONT);
        g.setColor(Color.WHITE);
        g.drawString(("Name: " + person.getName()), currX + 10, currY + 15);
        g.drawString(("Age: " + person.getAge()), currX + 10, currY + 40);

        drawLines(g);

        currX = calculateNewX(currX);
    } //drawNode


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
    } //calculateNewX


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
    
} //PriorityQueueRender
