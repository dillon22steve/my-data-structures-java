package src.scenes;

import java.awt.Graphics;

import src.App;
import src.data_structures.DataStructure;
import src.data_structures.hash_maps.HashMap;
import src.data_structures.heaps.Heap;
import src.data_structures.linked_list.doubly_linked.SortedDoublyLinkedList;
import src.data_structures.linked_list.singly_linked.SortedLinkedList;
import src.data_structures.linked_list.singly_linked.UnsortedLinkedList;
import src.data_structures.queues.PriorityQueue;
import src.data_structures.queues.Queue;
import src.data_structures.stack.Stack;
import src.data_structures.trees.AvlTree;
import src.data_structures.trees.BinarySearchTree;
import src.person.Person;
import src.render.RenderInterface;
import src.render.lists.ListRender;
import src.render.trees.BstRender;

public class Display {

    public static float opacity = 0;
    public static float opacityUpdate = 1.2F;

    public static char DataStructureType;

    private RenderInterface render;

    private DataStructure<Person> dataStructure;
    private AvlTree avlTree;
    private Stack<Person> stack;
    private Heap<Person> heap;
    private PriorityQueue<Person> priorityQueue;
    private HashMap hashMap;

    public Display() {
        dataStructure = null;
    } //constructor


    public void draw(Graphics g) {
        render.render(g);
    } //draw


    public void initDisplay() {
        switch (DataStructureType) {
            case 'u':
                dataStructure = new UnsortedLinkedList<Person>();
                render = new ListRender();
                break;
            case 's':
                dataStructure = new SortedLinkedList<Person>();
                render = new ListRender();
                break;
            case 'd':
                dataStructure = new SortedDoublyLinkedList<Person>();
                break;
            case 'b':
                dataStructure = new BinarySearchTree<Person>();
                render = new BstRender();
                break;
            case 'q':
                dataStructure = new Queue<Person>();
                break;
            case 't':

                break;
            case 'p':

                break;
            case 'h':

                break;
            case 'a':

                break;
            case 'r':

                break;
            case 'm':

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
