package src.render.trees;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import src.data_structures.trees.AvlTree;
import src.data_structures.trees.BinarySearchTree;
import src.data_structures.trees.Tree;
import src.gui.Panel;
import src.nodes.trees.TreeNode;
import src.person.Person;
import src.render.RenderInterface;
import src.render.StructureRender;
import src.scenes.Display;
import src.utils.HelperMethods;
import src.utils.constants.ImageConstants;
import src.utils.constants.PersonConstants;


public class BstRender extends StructureRender implements RenderInterface {

    private Tree<Person> tree;

    private int nodeRadius;


    public BstRender() {
        super();

        nodeRadius = 85;

        initialX = (Panel.SCREEN_WIDTH / 2) - (150 / 2);
        initialY = 100;
        currX = initialX;
        currY = initialY;

        xOffset = ((Panel.SCREEN_WIDTH - 100) / 4);
        yOffset = (Panel.SCREEN_HEIGHT - 200) / 5;

        if (Display.DataStructureType == 'b') {
            tree = new BinarySearchTree<Person>();
        } else if (Display.DataStructureType == 'a') {
            tree = new AvlTree<Person>();
        } //if

        PersonConstants.RandomizePeople();
    } //constructore


    @Override
    public void insertNext() {
        if (insertIndex == PersonConstants.people.length) {
            System.exit(0);
        } //if

        tree.insert(PersonConstants.people[insertIndex], tree.getRoot());
        insertIndex++;
    } //insertNext


    @Override
    public void render(Graphics g) {
        if (drawStructure) {
            drawRoot(g);
            drawTree(g, tree.getRoot().getLeftChild(), initialX, (initialY + yOffset), 4, true);
            drawTree(g, tree.getRoot().getRightChild(), initialX, (initialY + yOffset), 4, false);
        } else {
            String name = PersonConstants.people[insertIndex].getName();
            HelperMethods.drawInsertedName(g, name);
        } //if
    } //render


    private void drawRoot(Graphics g) {
        g.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        g.setColor(Color.WHITE);

        g.drawImage(ImageConstants.NodeImage, initialX, initialY, 70, 70, null);
        TreeNode<Person> node = tree.getRoot();
        g.drawString(node.getData().getName(), initialX + 10, initialY + 15);
        g.drawString(("Age: " + node.getData().getAge()), initialX + 10, initialY + 40);

        drawLines(g, initialX, initialY, 4);
    } //drawRoot


    private void drawTree(Graphics g, TreeNode<Person> node, int x, int y, int offset, boolean left) {
        if (node == null) {
            return;
        } //if

        int newOffset = (Panel.SCREEN_WIDTH - 100) / (offset);

        if (left == false) {
            x = x + newOffset;
        } else {
            x = x - newOffset;
        } //if

        g.drawImage(ImageConstants.NodeImage, x, y, 70, 70, null);

        g.setFont(new Font("Bookman Old Style", Font.PLAIN, 12));
        g.setColor(Color.WHITE);
        g.drawString(node.getData().getName(), x + 10, y + 15);
        g.drawString(("Age: " + node.getData().getAge()), x + 10, y + 40);

        drawLines(g, x, y, offset);

        drawTree(g, node.getLeftChild(), x, (y + yOffset), (offset * 2), true);
        drawTree(g, node.getRightChild(), x, (y + yOffset), (offset * 2), false);
    } //drawTree


    private void drawLines(Graphics g, int x, int y, int xOffset) {
        int newOffset = (Panel.SCREEN_WIDTH - 100) / (xOffset * 2);

        //g.drawLine((x + 60), (y + 75), ((x + 60) - newOffset), (y + yOffset));
        //g.drawLine((x + 90), (y + 75), ((x + newOffset)), (y + yOffset));

        g.drawLine(x, (y + 75), ((x - newOffset) + 25), (y + yOffset));
        g.drawLine((x + 70), (y + 75), (x + newOffset + 25), (y + yOffset));
    } //drawLines
    
} //BstRender
