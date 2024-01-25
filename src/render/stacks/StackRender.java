package src.render.stacks;

import java.awt.Color;
import java.awt.Graphics;

import src.data_structures.stack.Stack;
import src.gui.Panel;
import src.nodes.linked.SinglyLinkedNode;
import src.person.Person;
import src.render.RenderInterface;
import src.render.StructureRender;
import src.utils.HelperMethods;
import src.utils.constants.FontConstants;
import src.utils.constants.ImageConstants;
import src.utils.constants.PersonConstants;

public class StackRender extends StructureRender implements RenderInterface {

    private Stack<Person> stack;

    public StackRender() {
        stack = new Stack<Person>();

        nodeWidth = 150;
        nodeHeight = ((Panel.SCREEN_HEIGHT - 100) / (PersonConstants.people.length)) - 20;

        initialX = (Panel.SCREEN_WIDTH / 2) - (nodeWidth / 2);
        initialY = 50;

        currX = initialX;
        currY = initialY;

        yOffset = 40;
    } //constructor


    @Override
    public void insertNext() {
        stack.push(PersonConstants.people[insertIndex]);
        insertIndex++;
    } //insertNext


    @Override
    public void render(Graphics g) {
        if (drawStructure) {
            drawStack(g);
            disableRendering();
        } else {
            if (insertIndex >= PersonConstants.people.length) {
                System.exit(0);
            } //if
            String name = PersonConstants.people[insertIndex].getName();
            HelperMethods.drawInsertedName(g, name);
        } //if
    } //render


    private void drawStack(Graphics g) {
        SinglyLinkedNode<Person> temp = stack.getTop();

        while (temp != null) {
            g.drawImage(ImageConstants.NodeImage, currX, currY, nodeWidth, nodeHeight, null);

            g.setFont(FontConstants.NODE_TEXT_FONT);
            g.setColor(Color.WHITE);
            g.drawString(("Name: " + temp.getData().getName()), currX + 10, currY + 15);

            if (temp.getNext() != null) {
                int lineX = currX + (nodeWidth / 2);
                g.drawLine(lineX, (currY + nodeHeight), lineX, (currY + yOffset));
            } //if

            drawTop(g);

            currY += yOffset;
            temp = temp.getNext();
        } //while

        currY = initialY;
    } //drawStack


    private void drawTop(Graphics g) {
        int stringX = (initialX - 150);
        int stringY = (initialY + 10);

        g.setColor(Color.GREEN);
        g.drawString("Top of stack", stringX, stringY);

        g.drawLine((stringX + 80), (stringY - 5), initialX, (stringY - 5));
    } //drawTop
    
} //StackRender