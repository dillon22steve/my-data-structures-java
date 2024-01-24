package src.scenes;

public class Scenes {

    public static final char SELECTION_MENU = 's';
    public static final char DATA_INPUT = 'i';
    public static final char DISPLAY = 'd';
    public static final char PAUSE_MENU = 'p';

    
    public static char CurrentScene = 's';


    public static void UpdateCurrentScene(char scene) {
        CurrentScene = scene;
    } //UpdateCurrentScene
    
} //Scenes
