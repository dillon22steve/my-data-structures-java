package src.render.trees;

import java.awt.Color;
import java.awt.Graphics;

import src.data_structures.trees.RedBlackTree;
import src.gui.Panel;
import src.nodes.trees.RedBlackNode;
import src.person.Person;
import src.render.RenderInterface;
import src.render.StructureRender;
import src.utils.HelperMethods;
import src.utils.constants.FontConstants;
import src.utils.constants.PersonConstants;


public class RedBlackTreeRender extends StructureRender implements RenderInterface {

    private RedBlackTree<Person> tree;

    private Color nodeColor = Color.WHITE;
    private Color textColor = Color.RED;


    public RedBlackTreeRender() {
        super();

        tree = new RedBlackTree<Person>();

        nodeWidth = 70;
        nodeHeight = 70;

        nodeWidth = 70;
        nodeHeight = 70;

        initialX = (Panel.SCREEN_WIDTH / 2) - (150 / 2);
        initialY = 50;
        currX = initialX;
        currY = initialY;

        xOffset = ((Panel.SCREEN_WIDTH - 100) / 4);
        yOffset = (Panel.SCREEN_HEIGHT - 200) / 7;

        PersonConstants.RandomizePeople();
    } //constructor


    @Override
    public void insertNext() {
        if (insertIndex >= PersonConstants.people.length) {
            System.exit(0);
        } //if

        tree.insert(PersonConstants.people[insertIndex], tree.getRootNode());
        insertIndex++;
    } //insertNext


    @Override
    public void render(Graphics g) {
        if (drawStructure) {
            g.setFont(FontConstants.NODE_TEXT_FONT);
            g.setColor(Color.WHITE);

            drawRoot(g);

            if (tree.getRootNode() != null) {
                drawTree(g, tree.getRootNode().getLeftChild(), initialX, (initialY + yOffset), 4, true);
                drawTree(g, tree.getRootNode().getRightChild(), initialX, (initialY + yOffset), 4, false);
            } //if

            disableRendering();
        } else {
            if (insertIndex >= PersonConstants.people.length) {
                System.exit(0);
            } //if
            String name = PersonConstants.people[insertIndex].getName();
            HelperMethods.drawInsertedName(g, name);
        } //if
    } //render


    private void drawRoot(Graphics g) {
        RedBlackNode<Person> root = tree.getRootNode();

        if (root == null) {
            return;
        } else {
            int rootX = (initialX - (nodeWidth / 2));
            drawNode(g, rootX, initialY, 2, root);
        } //if
    } //drawRoot


    private void drawTree(Graphics g, RedBlackNode<Person> tree, int nodeX, int nodeY, int offset, boolean left) {
        if (tree == null) {
            return;
        } //if

        int newOffset = (Panel.SCREEN_WIDTH - 100) / (offset);
        nodeX = calculateNewX(nodeX, newOffset, left);

        drawNode(g, nodeX, nodeY, newOffset, tree);

        drawTree(g, tree.getLeftChild(), nodeX, (nodeY + yOffset), (offset * 2), true);
        drawTree(g, tree.getRightChild(), nodeX, (nodeY + yOffset), (offset * 2), false);
    } //drawTree


    private void drawNode(Graphics g, int nodeX, int nodeY, int offset, RedBlackNode<Person> tree) {
        determineColors(tree.getColor());

        drawOval(g, nodeX, nodeY);

        drawTreeText(tree, nodeX, nodeY, g);

        drawLines(g, nodeX, nodeY, offset);
    } //drawNode


    private void drawOval(Graphics g, int nodeX, int nodeY) {
        g.setColor(nodeColor);
        g.fillOval(nodeX, nodeY, nodeWidth, nodeHeight);
    } //drawOval

    private void drawTreeText(RedBlackNode<Person> tree, int nodeX, int nodeY, Graphics g) {
        g.setColor(textColor);
        g.drawString(tree.getData().getName(), nodeX + 10, nodeY + 15);
        g.drawString(("Age: " + tree.getData().getAge()), nodeX + 10, nodeY + 40);
    } //drawTreeText


    private int calculateNewX(int origX, int xOffset, boolean left) {
        if (left) {
            return origX - xOffset;
        } else {
            return origX + xOffset;
        } //if
    } //calculateNewX


    private void determineColors(char redOrBlack) {
        if (redOrBlack == 'b') {
            nodeColor = Color.WHITE;
            textColor = Color.BLACK;
        } else {
            nodeColor = Color.RED;
            textColor = Color.WHITE;
        } //if
    }  //determineColors


    private void drawLines(Graphics g, int x, int y, int offset) {
        int newOffset = (Panel.SCREEN_WIDTH - 100) / (offset * 2);

        g.setColor(Color.WHITE);
        g.drawLine(x, (y + nodeHeight), ((x - newOffset) + 10), (y + yOffset));
        g.drawLine((x + nodeWidth), (y + nodeHeight), (x + newOffset + 10), (y + yOffset));
    } //drawLines
    
} //RedBlackTreeRender
