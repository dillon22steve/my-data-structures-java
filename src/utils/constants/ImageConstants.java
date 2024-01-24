package src.utils.constants;

import java.awt.image.BufferedImage;

import src.utils.HelperMethods;


public class ImageConstants {

    public static BufferedImage NodeImage;
    public static BufferedImage TreeNodeImage;


    public static void InitImages() {
        NodeImage = HelperMethods.LoadImage("LinkedListNode.jpg");
    } //InitImages
    
} //ImageConstants
