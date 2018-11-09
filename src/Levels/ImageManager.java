package Levels;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageManager {

	private ImageIcon grass;
	private ImageIcon supergrass;
	private ImageIcon unknown;
	
	public ImageManager(){
		try {
			this.grass = new ImageIcon((BufferedImage)ImageIO.read(this.getClass().getResource("/Levels/grass.PNG")));
			this.supergrass = new ImageIcon((BufferedImage)ImageIO.read(this.getClass().getResource("/Levels/supergrass.PNG")));
			this.unknown = new ImageIcon((BufferedImage)ImageIO.read(this.getClass().getResource("/Levels/unknown.PNG")));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ImageIcon getImage(int n){
		if(n>0){
			return unknown;
		}if(n==-1){
			return grass;
		}else if(n==-2){
			return supergrass;
		}
		return unknown;
	}
}
