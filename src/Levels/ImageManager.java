package Levels;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageManager {

	private ImageIcon grass;
	private ImageIcon supergrass;
	private ImageIcon unknown;
	private ImageIcon boat;
	private ImageIcon jungle;
	private ImageIcon mud;
	private ImageIcon cave;
	private ImageIcon piramid;
	private ImageIcon rock;
	private ImageIcon lava;
	private ImageIcon water;
	private ImageIcon village;
	private ImageIcon shrine;
	private ImageIcon mountain;
	private ImageIcon player;


	
	public ImageManager(){
		try {
			this.grass = new ImageIcon((BufferedImage)ImageIO.read(this.getClass().getResource("/Levels/grass.PNG")));
			this.supergrass = new ImageIcon((BufferedImage)ImageIO.read(this.getClass().getResource("/Levels/supergrass.PNG")));
			this.unknown = new ImageIcon((BufferedImage)ImageIO.read(this.getClass().getResource("/Levels/unknown.PNG")));
			this.boat = new ImageIcon((BufferedImage)ImageIO.read(this.getClass().getResource("/Levels/boat.PNG")));
			this.jungle = new ImageIcon((BufferedImage)ImageIO.read(this.getClass().getResource("/Levels/jungle.PNG")));
			this.lava = new ImageIcon((BufferedImage)ImageIO.read(this.getClass().getResource("/Levels/lava.PNG")));
			this.mud = new ImageIcon((BufferedImage)ImageIO.read(this.getClass().getResource("/Levels/mud.PNG")));
			this.piramid = new ImageIcon((BufferedImage)ImageIO.read(this.getClass().getResource("/Levels/piramid.PNG")));
			this.rock = new ImageIcon((BufferedImage)ImageIO.read(this.getClass().getResource("/Levels/rock.PNG")));
			this.cave = new ImageIcon((BufferedImage)ImageIO.read(this.getClass().getResource("/Levels/cave.PNG")));
			this.water = new ImageIcon((BufferedImage)ImageIO.read(this.getClass().getResource("/Levels/water.PNG")));
			this.village = new ImageIcon((BufferedImage)ImageIO.read(this.getClass().getResource("/Levels/village.PNG")));
			this.shrine = new ImageIcon((BufferedImage)ImageIO.read(this.getClass().getResource("/Levels/shrine.PNG")));
			this.mountain = new ImageIcon((BufferedImage)ImageIO.read(this.getClass().getResource("/Levels/mountain.PNG")));
			this.player = new ImageIcon((BufferedImage)ImageIO.read(this.getClass().getResource("/Levels/player.PNG")));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ImageIcon getImage(int n){
		if(n>0){
			return unknown;
		}if(n==-1){
			return water;
		}else if(n==-2){
			return grass;
		}else if(n==-3){
			return supergrass;
		}else if(n==-4){
			return mud;
		}else if(n==-5){
			return player;
		}else if(n==-6){
			return cave;
		}else if(n==-7){
			return shrine;
		}else if(n==-8){
			return lava;
		}else if(n==-9){
			return piramid;
		}else if(n==-10){
			return village;
		}else if(n==-11){
			return boat;
		}else if(n==-12){
			return mountain;
		}else if(n==-13){
			return jungle;
		}else if(n==-14){
			return rock;
		}
		return unknown;
		
	}
}

