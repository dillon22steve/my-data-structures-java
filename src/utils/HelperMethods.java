package src.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import src.App;
import src.gui.Panel;
import src.person.Person;
import src.utils.constants.FontConstants;
import src.utils.constants.ImageConstants;
import src.utils.constants.PersonConstants;


public class HelperMethods {

	public static void InitApp() {
		Person.initIdChars();
		PersonConstants.InitPeople();
		ImageConstants.InitImages();
	}

    public static BufferedImage LoadImage(String filename) {
        BufferedImage imgToReturn = null;
        InputStream is = HelperMethods.class.getResourceAsStream("/res/" + filename);
		
		try {
			imgToReturn = ImageIO.read(is);
		} catch (IOException e) {
            System.out.println(filename);
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException io) {
				io.printStackTrace();
			} catch (Exception e) {
                System.out.println(filename + ": " + e.getMessage());
            } //try
		} //try

        return imgToReturn;
    } //LoadImage


	public static void drawInsertedName(Graphics g, String name) {
		g.setFont(FontConstants.INSERT_TEXT_FONT);
        g.setColor(new Color(255, 255, 255, (int)App.opacity));
		g.drawString(("Inserting " + name), ((Panel.SCREEN_WIDTH / 2) - 56), 100);
	} //drawInsertedName
    
} //Helper Methods
