package src.render.lists;

import java.awt.Color;
import java.awt.Graphics;

import src.data_structures.linked_list.singly_linked.LinkedList;
import src.data_structures.linked_list.singly_linked.SortedLinkedList;
import src.data_structures.linked_list.singly_linked.UnsortedLinkedList;
import src.gui.Panel;
import src.nodes.linked.SinglyLinkedNode;
import src.person.Person;
import src.render.RenderInterface;
import src.render.StructureRender;
import src.scenes.Display;
import src.utils.HelperMethods;
import src.utils.constants.FontConstants;
import src.utils.constants.ImageConstants;
import src.utils.constants.PersonConstants;


public class ListRender extends StructureRender implements RenderInterface {

    private LinkedList<Person> list;

    private static boolean isEvenRow = false;
    private static boolean isDown = false;


    public ListRender() {
        super();

        initialX = 100;
        initialY = 100;
        currY = initialY;
        currX = initialX;

        xOffset = 210;
        yOffset = 150;

        if (Display.DataStructureType == 'u') {
            list = new UnsortedLinkedList<Person>();
        } else if (Display.DataStructureType == 's') {
            list = new SortedLinkedList<Person>();
        } //if
    } //constructor


    public void insertNext() {
        if (insertIndex > PersonConstants.people.length) {
            System.exit(0);
        } //if

        list.insert(PersonConstants.people[insertIndex]);
        insertIndex++;
    } //insertNext


    @Override
    public void render(Graphics g) {
        if (drawStructure) {
            drawList(g);
            disableRendering();
        } else {
            String name = PersonConstants.people[insertIndex].getName();
            HelperMethods.drawInsertedName(g, name);
        } //if
    } //render


    private void drawList(Graphics g) {
        SinglyLinkedNode<Person> temp = list.get();

        while (temp != null) {
            g.drawImage(ImageConstants.NodeImage, currX, currY, 150, 70, null);

            boolean isInserted = (temp.getData().compareTo(PersonConstants.people[insertIndex - 1]) == 0);
            if (isInserted) {
                g.setColor(Color.GREEN);
                g.drawRect(currX - 5, currY - 5, 160, 80);
            } //if

            g.setFont(FontConstants.NODE_TEXT_FONT);
            g.setColor(Color.WHITE);
            g.drawString(("Name: " + temp.getData().getName()), currX + 10, currY + 15);
            g.drawString(("Age: " + temp.getData().getAge()), currX + 10, currY + 40);

            drawLines(g);

            currX = calculateNewX(currX);

            temp = temp.getNext();
        } //while

        currX = initialX;
        currY = initialY;
        isEvenRow = false;
        isDown = false;

        list.setCurrentPos(list.getHead());
    } //drawList


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
    
} //ListRender
