package src;

import src.utils.HelperMethods;


public class DataStructuresDriver {
    
    public static void main(String[] args) {
        HelperMethods.InitApp();
        
        App app = new App();
        app.getPanel().initInputs();
        app.start();
    } //main

} //DataStructuresDriver
