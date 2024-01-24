package src.gui;

import javax.swing.JFrame;

public class Frame  extends JFrame {

    private Panel panel;


    public Frame(Panel panel) {
        this.panel = panel;

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        /* Uncomment this setUndecored line when the app is ready to run 
         * It gets rid of the title bar at the top.
        */
        this.setUndecorated(false);


        this.add(panel);

        this.pack();
        this.setVisible(true);
    } //constructor
    
} //Frame
