package src;
import src.gui.*;
import src.scenes.Display;
import src.scenes.Scenes;
import src.scenes.SelectionMenu;

public class App implements Runnable {

    public static float opacity = 255f;
    public static float opacityUpdate = 1.2f;

    private final double FPS_SET = 120;
    private final double UPS_SET = 200;

    public static boolean draw = true;

    private Panel panel;
    private Frame frame;
    private Thread appThread;

    private SelectionMenu selectionMenu;
    private Display display;


    public App() {
        this.panel = new Panel(this);
        this.frame = new Frame(panel);

        initScenes();
    } //constructor

    private void initScenes() {
        selectionMenu = new SelectionMenu(this);
        display = new Display();
    } //initScenes


    public void start() {
        appThread = new Thread(this);
        appThread.start();
    } //start


    private void update() {
        switch (Scenes.CurrentScene) {
            case Scenes.SELECTION_MENU:
                selectionMenu.update();
                break;
            case Scenes.DATA_INPUT:
                break;
            case Scenes.DISPLAY:
                display.getRender().update();
                break;
            case Scenes.PAUSE_MENU:
                break;
        } //switch
    } //update


    public static void UpdateOpacity() {
        if (opacity < 35) {
            opacity = 35;
            opacityUpdate *= -1;
        } else if (opacity > 255) {
            opacity = 255;
            opacityUpdate *= -1;
        } //if

        opacity -= opacityUpdate;
    } //updateOpacity


    @Override
    public void run() {

        double timePerFrame = (1_000_000_000.0 / FPS_SET);
		double timePerUpdate = (1_000_000_000.0 / UPS_SET);
        long lastFrame = System.nanoTime();
        long lastUpdate = System.nanoTime();
        long now = System.nanoTime();

        
        // long lastTimeCheck = 0;
        // int frames = 0;
        // int updates = 0;

        while(true) {
            now = System.nanoTime();

            if((now - lastFrame) >= timePerFrame) {
                lastFrame = now;

                if (draw == true) {
                    panel.repaint();
                } //if
                //frames++;
            } //if

            if((now - lastUpdate) >= timePerUpdate) {
                lastUpdate = now;
                update();
                //updates++;
            } //if

            
            // if ( System.currentTimeMillis() - lastTimeCheck >= 1000) {
            //     System.out.println("frames: " + frames + " | updates: " + updates);
            //     frames = 0;
            //     updates = 0;
            //     lastTimeCheck = System.currentTimeMillis();
            // } //if
        } //while
        
    } //run



    public SelectionMenu getSelectionMenu() {
        return selectionMenu;
    } //getSelectionMenu

    public Display getDisplay() {
        return display;
    }

    public Panel getPanel() {
        return panel;
    } //getPanel

} //App
