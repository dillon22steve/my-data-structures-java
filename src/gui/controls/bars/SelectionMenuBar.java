package src.gui.controls.bars;

import src.App;
import src.gui.Panel;
import src.gui.controls.buttons.Button;
import src.scenes.Display;
import src.scenes.Scenes;


public class SelectionMenuBar extends ButtonBar {

    public SelectionMenuBar(int width, int height, int xPos, int yPos, App app) {
        super(width, height, xPos, yPos, app);
        initButtons();
    } //constructor

    private void initButtons() {
        buttons = new Button[11];

        int initialY = 50;
        int yOffset = 30 + (Panel.SCREEN_HEIGHT / 20);
        int otherX = Panel.SCREEN_WIDTH - 200;
        buttons[0] = createButton("Unsorted Linked List", initialY, 100, 'u');
        buttons[1] = createButton("Stack", initialY, otherX, 't');
        buttons[2] = createButton("Sorted Linked List", (initialY + yOffset), 100, 's');
        buttons[3] = createButton("Queue", initialY + yOffset, otherX, 'q');
        buttons[4] = createButton("Doubly Linked List", (initialY + (2 * yOffset)), 100, 'd');
        buttons[5] = createButton("Priority Queue", (initialY + (2 * yOffset)), otherX, 'p');
        buttons[6] = createButton("Binary Search Tree", (initialY + (3 * yOffset)), 100, 'b');
        buttons[7] = createButton("Heap", (initialY + (3 * yOffset)), otherX, 'h');
        buttons[8] = createButton("AVL Tree", (initialY + (4 * yOffset)), 100, 'a');
        buttons[9] = createButton("Hash Map", (initialY + (4 * yOffset)), otherX, 'm');
        buttons[10] = createButton("Red-Black Tree", (initialY + (5 * yOffset)), 100, 'r');
    } //initButtons

    private Button createButton(String text, int y, int x, char structureType) {
        return new Button(x, y, 100, 30, text, structureType);
    } //createButton


    @Override void selectHandler() {
        Display.DataStructureType = buttons[selectedIndex].getStructureType();
        app.getDisplay().initDisplay();
        Scenes.UpdateCurrentScene(Scenes.DISPLAY);
    } //selectHandler
    
} //SelectionMenuBar
